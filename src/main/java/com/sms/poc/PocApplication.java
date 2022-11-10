package com.sms.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.cloudhopper.smpp.type.SmppChannelException;

import net.gescobar.smppserver.SmppServer;

@SpringBootApplication
public class PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}

	@Autowired
	private SmppServer smppServer;

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		try {
			smppServer.start();
		} catch (SmppChannelException e) {
			e.printStackTrace();
		}
	}

}
