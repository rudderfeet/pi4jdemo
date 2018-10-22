package us.mccrory.pi4jdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

/**
 * Toggles GPIO pins.
 */
@Service
public class PiBlinkService {

	/**
	 * An slf4j logging object for this class.
	 */
	private static Logger LOG = LoggerFactory.getLogger(PiBlinkService.class);

	/**
	 * Toggle GPIO pins on and off.
	 */
	public void blink() throws Exception {

		LOG.info("<--Pi4J--> GPIO Blink Example ... started.");

		// create gpio controller
		final GpioController gpio = GpioFactory.getInstance();

		// provision gpio pin #05 as an output pin and blink
		final GpioPinDigitalOutput led = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05);

		// provision gpio pin #06 as an input pin with its internal pull down resistor enabled
		final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_06, PinPullResistance.PULL_DOWN);

		// create and register gpio pin listener
		myButton.addListener(new GpioPinListenerDigital() {
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				// when button is pressed, speed up the blink rate on LED
				if (event.getState().isHigh()) {
					LOG.info("HIGH button");
					led.blink(200);
				} else {
					LOG.info("LOW button");
					led.blink(1000);
				}
			}
		});

		// continuously blink the led every 1 second
		led.blink(1000);

		LOG.info(" ... The LED will continue blinking until stopped...");
		LOG.info(" ... PRESS <CTRL-C> TO STOP THE PROGRAM.");

		// keep program running until user aborts (CTRL-C)
		while(true) {
			Thread.sleep(500);
		}

		// Stop all GPIO activity/threads
		// (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
		// gpio.shutdown();  // <--- implement this method call if you wish to terminate the Pi4J GPIO controller

	}

}
