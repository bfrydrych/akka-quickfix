package akka.quickfix;

import akka.actor.ActorSystem;
import akka.actor.typed.javadsl.ActorContext;
import akka.quickfix.actor.MessagePublisherActor;

public class StartMeUp {
    public static void main(String[] args) {
    	ActorSystem as = ActorSystem.create("quickfixActorSystem");
    	
    	
    }
}
