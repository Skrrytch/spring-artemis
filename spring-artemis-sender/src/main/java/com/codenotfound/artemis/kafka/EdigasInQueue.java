package com.codenotfound.artemis.kafka;

import org.springframework.stereotype.Component;

@Component
public class EdigasInQueue implements QueueDef {

    @Override
    public String getName() {
        return "msg-edigas-in";
    }
}
