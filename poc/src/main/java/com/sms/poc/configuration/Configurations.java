package com.sms.poc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sms.poc.MyPacketProcessor;

import net.gescobar.smppserver.SmppServer;

@Configuration
public class Configurations {	

	@Bean
	public MyPacketProcessor packetProcessor() {
		MyPacketProcessor packetProcessor = new MyPacketProcessor();
		return packetProcessor;
	}

	@Bean
	public SmppServer smppServer() {
		final SmppServer smppServer = new SmppServer(1234);
		smppServer.setPacketProcessor(packetProcessor());
		return smppServer;
	}
}
