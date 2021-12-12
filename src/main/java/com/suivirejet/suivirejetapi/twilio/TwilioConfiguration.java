package com.suivirejet.suivirejetapi.twilio;

import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@NoArgsConstructor
@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfiguration {
    private String accountSid ;
    private String authTocken ;
    private String phoneNumber ;

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAuthTocken() {
        return authTocken;
    }

    public void setAuthTocken(String authTocken) {
        this.authTocken = authTocken;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
