package com.suivirejet.suivirejetapi.twilio;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class TwilioService {

    private final TwilioSMSSender twilioSMSSender ;

    @Autowired
    public TwilioService(TwilioSMSSender twilioSMSSender) {
        this.twilioSMSSender = twilioSMSSender;
    }

    public void sendSMS(SMSRequest smsRequest){
        twilioSMSSender.sendSMS(smsRequest);
    }
}
