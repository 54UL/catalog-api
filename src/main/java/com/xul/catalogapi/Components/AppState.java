package com.xul.catalogapi.Components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AppState {
    private String numberOfRequests;
    private static final Logger log = LoggerFactory.getLogger(AppState.class);

    AppState() {
        log.warn("App state initialized");
    }

    public String getNumberOfRequests() {
        return numberOfRequests;
    }

    public void setNumberOfRequests(String numberOfRequests) {
        this.numberOfRequests = numberOfRequests;
    }

    public void incrementRequestCountBy(long count){
        this.numberOfRequests += count;
    }
}
