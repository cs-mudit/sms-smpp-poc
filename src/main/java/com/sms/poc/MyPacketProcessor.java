package com.sms.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.sms.poc.dao.SMSDao;
import com.sms.poc.entity.SMS;

import net.gescobar.smppserver.PacketProcessor;
import net.gescobar.smppserver.Response;
import net.gescobar.smppserver.ResponseSender;
import net.gescobar.smppserver.packet.Bind;
import net.gescobar.smppserver.packet.SmppPacket;
import net.gescobar.smppserver.packet.SmppRequest;
import net.gescobar.smppserver.packet.SubmitSm;

public class MyPacketProcessor implements PacketProcessor {

	@Value("${password}")
	private String password;

	@Autowired
	private SMSDao smsDao;

	@Override
	public void processPacket(SmppRequest packet, ResponseSender responseSender) {
		if (packet.isBind()) {
			Bind bind = (Bind) packet;
			if (!password.contentEquals(bind.getPassword())) {
				responseSender.send(Response.BIND_FAILED);
			}
			responseSender.send(Response.OK);
		} else if (packet.getCommandId() == SmppPacket.SUBMIT_SM) {

			// a message has arrived, what do you want to do with it?
			SubmitSm submit = (SubmitSm) packet;
			SMS sms = new SMS(submit.getSourceAddress().getAddress(), submit.getDestAddress().getAddress(),
					new String(submit.getShortMessage()), submit.getServiceType(), submit.getEsmClass(),
					submit.getProtocolId(), submit.getPriority(), submit.getScheduleDeliveryTime(),
					submit.getValidityPeriod(), submit.getRegisteredDelivery(), submit.getReplaceIfPresent(),
					submit.getDefaultMsgId(), submit.getDataCoding());
			smsDao.save(sms);
			responseSender.send(Response.OK);
		}
	}
}