package edu.nju.ics.akkademy;

import javax.naming.Context;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import edu.nju.ics.akkademy.messages.SetRequest;

import java.util.HashMap;
import java.util.Map;

public class AkkademyDb extends AbstractActor {
    
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
    protected final Map<String, Object> map = new HashMap<>();

    private AkkademyDb() {
        receive(ReceiveBuilder
            .match(SetRequest.class, message -> {
                log.info("Received Set request; {}", message);
                map.put(message.getKey(), message.getValue());
            })
            .matchAny(o -> log.info("received unknown message: {}", o))
            .build()
            
            );
    }
    
    

}