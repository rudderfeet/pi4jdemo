package us.mccrory.pi4jdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pi4j.platform.PlatformManager;
import com.pi4j.system.NetworkInfo;
import com.pi4j.system.SystemInfo;

@Service
public class PiSystemInfoService {

	private static Logger LOG = LoggerFactory.getLogger(PiSystemInfoService.class);

	public void getPiSystemStatus() {

		// display a few of the available system information properties
		LOG.info("----------------------------------------------------");
		LOG.info("PLATFORM INFO");
		LOG.info("----------------------------------------------------");
		try {
			LOG.info("Platform Name     :  " + PlatformManager.getPlatform().getLabel());
		} catch (Exception ex) {
		}
		try {
			LOG.info("Platform ID       :  " + PlatformManager.getPlatform().getId());
		} catch (Exception ex) {
		}
		LOG.info("----------------------------------------------------");
		LOG.info("HARDWARE INFO");
		LOG.info("----------------------------------------------------");
		try {
			LOG.info("Serial Number     :  " + SystemInfo.getSerial());
		} catch (Exception ex) {
		}
		try {
			LOG.info("CPU Revision      :  " + SystemInfo.getCpuRevision());
		} catch (Exception ex) {
		}
		try {
			LOG.info("CPU Architecture  :  " + SystemInfo.getCpuArchitecture());
		} catch (Exception ex) {
		}
		try {
			LOG.info("CPU Part          :  " + SystemInfo.getCpuPart());
		} catch (Exception ex) {
		}
		try {
			LOG.info("CPU Temperature   :  " + SystemInfo.getCpuTemperature());
		} catch (Exception ex) {
		}
		try {
			LOG.info("CPU Core Voltage  :  " + SystemInfo.getCpuVoltage());
		} catch (Exception ex) {
		}
		try {
			LOG.info("CPU Model Name    :  " + SystemInfo.getModelName());
		} catch (Exception ex) {
		}
		try {
			LOG.info("Processor         :  " + SystemInfo.getProcessor());
		} catch (Exception ex) {
		}
		try {
			LOG.info("Hardware          :  " + SystemInfo.getHardware());
		} catch (Exception ex) {
		}
		try {
			LOG.info("Hardware Revision :  " + SystemInfo.getRevision());
		} catch (Exception ex) {
		}
		try {
			LOG.info("Is Hard Float ABI :  " + SystemInfo.isHardFloatAbi());
		} catch (Exception ex) {
		}
		try {
			LOG.info("Board Type        :  " + SystemInfo.getBoardType().name());
		} catch (Exception ex) {
		}

		LOG.info("----------------------------------------------------");
		LOG.info("MEMORY INFO");
		LOG.info("----------------------------------------------------");
		try {
			LOG.info("Total Memory      :  " + SystemInfo.getMemoryTotal());
		} catch (Exception ex) {
		}
		try {
			LOG.info("Used Memory       :  " + SystemInfo.getMemoryUsed());
		} catch (Exception ex) {
		}
		try {
			LOG.info("Free Memory       :  " + SystemInfo.getMemoryFree());
		} catch (Exception ex) {
		}
		try {
			LOG.info("Shared Memory     :  " + SystemInfo.getMemoryShared());
		} catch (Exception ex) {
		}
		try {
			LOG.info("Memory Buffers    :  " + SystemInfo.getMemoryBuffers());
		} catch (Exception ex) {
		}
		try {
			LOG.info("Cached Memory     :  " + SystemInfo.getMemoryCached());
		} catch (Exception ex) {
		}
		try {
			LOG.info("SDRAM_C Voltage   :  " + SystemInfo.getMemoryVoltageSDRam_C());
		} catch (Exception ex) {
		}
		try {
			LOG.info("SDRAM_I Voltage   :  " + SystemInfo.getMemoryVoltageSDRam_I());
		} catch (Exception ex) {
		}
		try {
			LOG.info("SDRAM_P Voltage   :  " + SystemInfo.getMemoryVoltageSDRam_P());
		} catch (Exception ex) {
		}

		LOG.info("----------------------------------------------------");
		LOG.info("OPERATING SYSTEM INFO");
		LOG.info("----------------------------------------------------");
		try {
			LOG.info("OS Name           :  " + SystemInfo.getOsName());
		} catch (Exception ex) {
		}
		try {
			LOG.info("OS Version        :  " + SystemInfo.getOsVersion());
		} catch (Exception ex) {
		}
		try {
			LOG.info("OS Architecture   :  " + SystemInfo.getOsArch());
		} catch (Exception ex) {
		}
		try {
			LOG.info("OS Firmware Build :  " + SystemInfo.getOsFirmwareBuild());
		} catch (Exception ex) {
		}
		try {
			LOG.info("OS Firmware Date  :  " + SystemInfo.getOsFirmwareDate());
		} catch (Exception ex) {
		}

		LOG.info("----------------------------------------------------");
		LOG.info("JAVA ENVIRONMENT INFO");
		LOG.info("----------------------------------------------------");
		LOG.info("Java Vendor       :  " + SystemInfo.getJavaVendor());
		LOG.info("Java Vendor URL   :  " + SystemInfo.getJavaVendorUrl());
		LOG.info("Java Version      :  " + SystemInfo.getJavaVersion());
		LOG.info("Java VM           :  " + SystemInfo.getJavaVirtualMachine());
		LOG.info("Java Runtime      :  " + SystemInfo.getJavaRuntime());

		LOG.info("----------------------------------------------------");
		LOG.info("NETWORK INFO");
		LOG.info("----------------------------------------------------");

		// display some of the network information
		try {
			LOG.info("Hostname          :  " + NetworkInfo.getHostname());
		} catch (Exception e) {
		}
		try {
			for (String ipAddress : NetworkInfo.getIPAddresses())
				LOG.info("IP Addresses      :  " + ipAddress);
		} catch (Exception e) {
		}
		try {
			for (String fqdn : NetworkInfo.getFQDNs())
				LOG.info("FQDN              :  " + fqdn);
		} catch (Exception e) {
		}
		try {
			for (String nameserver : NetworkInfo.getNameservers())
				LOG.info("Nameserver        :  " + nameserver);
		} catch (Exception e) {
		}

		LOG.info("----------------------------------------------------");
		LOG.info("CODEC INFO");
		LOG.info("----------------------------------------------------");
		try {
			LOG.info("H264 Codec Enabled:  " + SystemInfo.getCodecH264Enabled());
		} catch (Exception ex) {
		}
		try {
			LOG.info("MPG2 Codec Enabled:  " + SystemInfo.getCodecMPG2Enabled());
		} catch (Exception ex) {
		}
		try {
			LOG.info("WVC1 Codec Enabled:  " + SystemInfo.getCodecWVC1Enabled());
		} catch (Exception ex) {
		}

		LOG.info("----------------------------------------------------");
		LOG.info("CLOCK INFO");
		LOG.info("----------------------------------------------------");
		try {
			LOG.info("ARM Frequency     :  " + SystemInfo.getClockFrequencyArm());
		} catch (Exception ex) {
		}
		try {
			LOG.info("CORE Frequency    :  " + SystemInfo.getClockFrequencyCore());
		} catch (Exception ex) {
		}
		try {
			LOG.info("H264 Frequency    :  " + SystemInfo.getClockFrequencyH264());
		} catch (Exception ex) {
		}
		try {
			LOG.info("ISP Frequency     :  " + SystemInfo.getClockFrequencyISP());
		} catch (Exception ex) {
		}
		try {
			LOG.info("V3D Frequency     :  " + SystemInfo.getClockFrequencyV3D());
		} catch (Exception ex) {
		}
		try {
			LOG.info("UART Frequency    :  " + SystemInfo.getClockFrequencyUART());
		} catch (Exception ex) {
		}
		try {
			LOG.info("PWM Frequency     :  " + SystemInfo.getClockFrequencyPWM());
		} catch (Exception ex) {
		}
		try {
			LOG.info("EMMC Frequency    :  " + SystemInfo.getClockFrequencyEMMC());
		} catch (Exception ex) {
		}
		try {
			LOG.info("Pixel Frequency   :  " + SystemInfo.getClockFrequencyPixel());
		} catch (Exception ex) {
		}
		try {
			LOG.info("VEC Frequency     :  " + SystemInfo.getClockFrequencyVEC());
		} catch (Exception ex) {
		}
		try {
			LOG.info("HDMI Frequency    :  " + SystemInfo.getClockFrequencyHDMI());
		} catch (Exception ex) {
		}
		try {
			LOG.info("DPI Frequency     :  " + SystemInfo.getClockFrequencyDPI());
		} catch (Exception ex) {
		}

	}

}
