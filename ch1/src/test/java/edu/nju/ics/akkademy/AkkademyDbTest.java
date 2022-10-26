package edu.nju.ics.akkademy;

import static org.junit.Assert.assertEquals;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import edu.nju.ics.akkademy.messages.SetRequest;
import org.junit.Test;

public class AkkademyDbTest {

    ActorSystem system = ActorSystem.create();

    @Test
    public void isShouldPlaceKeyValueFromSetMessageIntoMap() {
        TestActorRef<AkkademyDb> actorRef = TestActorRef.create(system, Props.create(AkkademyDb.class));
        actorRef.tell(new SetRequest("key", "value"), ActorRef.noSender());

        AkkademyDb AkkademyDb = actorRef.underlyingActor();
        assertEquals(AkkademyDb.map.get("key"), "value");
    }
}
