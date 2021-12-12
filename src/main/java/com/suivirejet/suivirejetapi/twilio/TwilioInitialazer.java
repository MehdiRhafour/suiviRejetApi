package com.suivirejet.suivirejetapi.twilio;

import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TwilioInitialazer {

    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitialazer.class) ;

    private final TwilioConfiguration twilioConfiguration ;

    @Autowired
    public TwilioInitialazer(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(twilioConfiguration.getAccountSid(),twilioConfiguration.getAuthTocken());
        LOGGER.info("Twilio initialisé.......");
    }
}
