package com.sms.poc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SMS {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String sourceAddress;

	@Column
	private String destinationAddress;

	@Column
	private String shortMessage;

	@Column
	private String serviceType;

	private byte esmClass;

	private byte protocolId;

	private byte priority;

	private String scheduledDeliveryTime;

	private String validityPeriod;

	private byte registeredDelivery;

	private byte replaceIfPresent;

	private byte defaultMsgId;

	private byte dataCoding;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public String getShortMessage() {
		return shortMessage;
	}

	public void setShortMessage(String shortMessage) {
		this.shortMessage = shortMessage;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public byte getEsmClass() {
		return esmClass;
	}

	public void setEsmClass(byte esmClass) {
		this.esmClass = esmClass;
	}

	public byte getProtocolId() {
		return protocolId;
	}

	public void setProtocolId(byte protocolId) {
		this.protocolId = protocolId;
	}

	public byte getPriority() {
		return priority;
	}

	public void setPriority(byte priority) {
		this.priority = priority;
	}

	public void setScheduledDeliveryTime(String scheduledDeliveryTime) {
		this.scheduledDeliveryTime = scheduledDeliveryTime;
	}

	public String getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(String validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public SMS(String sourceAddress, String destinationAddress, String shortMessage, String serviceType, byte esmClass,
			byte protocolId, byte priority, String scheduledDeliveryTime, String validityPeriod,
			byte registeredDelivery, byte replaceIfPresent, byte defaultMsgId, byte dataCoding) {
		super();
		this.sourceAddress = sourceAddress;
		this.destinationAddress = destinationAddress;
		this.shortMessage = shortMessage;
		this.serviceType = serviceType;
		this.esmClass = esmClass;
		this.protocolId = protocolId;
		this.priority = priority;
		this.scheduledDeliveryTime = scheduledDeliveryTime;
		this.validityPeriod = validityPeriod;
		this.registeredDelivery = registeredDelivery;
		this.replaceIfPresent = replaceIfPresent;
		this.defaultMsgId = defaultMsgId;
		this.dataCoding = dataCoding;
	}

	public String getScheduledDeliveryTime() {
		return scheduledDeliveryTime;
	}

	public byte getRegisteredDelivery() {
		return registeredDelivery;
	}

	public void setRegisteredDelivery(byte registeredDelivery) {
		this.registeredDelivery = registeredDelivery;
	}

	public byte getReplaceIfPresent() {
		return replaceIfPresent;
	}

	public void setReplaceIfPresent(byte replaceIfPresent) {
		this.replaceIfPresent = replaceIfPresent;
	}

	public byte getDefaultMsgId() {
		return defaultMsgId;
	}

	public void setDefaultMsgId(byte defaultMsgId) {
		this.defaultMsgId = defaultMsgId;
	}

	public byte getDataCoding() {
		return dataCoding;
	}

	public void setDataCoding(byte dataCoding) {
		this.dataCoding = dataCoding;
	}

}
