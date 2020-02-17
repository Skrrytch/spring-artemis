package com.codenotfound.artemis.consumer;

import org.springframework.stereotype.Component;

import com.codenotfound.artemis.artemis.Queue;

@Component
public class QueueOfIncomingEdigas implements Queue {

    public static final String NAME = "msg-edigas-in";

    @Override
    public String getName() {
        return NAME;
    }
}
