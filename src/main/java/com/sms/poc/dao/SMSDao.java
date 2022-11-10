package com.sms.poc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.poc.entity.SMS;

public interface SMSDao extends JpaRepository<SMS, Integer> {

}
