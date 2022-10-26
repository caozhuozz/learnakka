package edu.nju.ics.akkademy;

import javax.naming.Context;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import edu.nju.ics.akkademy.message.SetRequest;


public class AkkademyDb extends AbstractActor {
    
    protected final LoggingAdapter log = Logging.getLogger(contex().system(), this);
    protected final Map<Stirng, Object> map = new HashMap<>();

    private AkkademyDb() {
        receive(ReceiveBulider
            .match(SetRequest.class, message -> {
                log.info("Received Set request; {}", message);
                map.put(message.getKey(), message.getValue());
            })
            .matchAny(o -> log.info("received unknown message: {}", o))
            .build()
            
            );
    }
    
    

}