package com.suivirejet.suivirejetapi.twilio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import lombok.ToString;

@ToString
public class SMSRequest {

    @NonNull
    private final String phoneNumber ;

    @NonNull
    private final String message ;

    public SMSRequest(@JsonProperty("phoneNumber") String phoneNumber,@JsonProperty("message") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }
}
