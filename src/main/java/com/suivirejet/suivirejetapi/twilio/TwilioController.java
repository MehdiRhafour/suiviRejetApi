package com.suivirejet.suivirejetapi.twilio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sms")
public class TwilioController {

    private final TwilioService service ;

    @Autowired
    public TwilioController(TwilioService service) {
        this.service = service;
    }

    @PostMapping
    public void sendSMS(@RequestBody SMSRequest smsRequest){
        service.sendSMS(smsRequest);
    }
}
