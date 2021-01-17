package akka.quickfix.actor;

import java.util.List;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import akka.quickfix.ClientObject;
import akka.quickfix.ClientSubscriptions;
import akka.quickfix.MessageConverter;
import quickfix.Message;

public class MessagePublisherActor<ClientId, Key> extends AbstractBehavior<AbstractMessage> {

	private final MessageConverter<Key> messageConverter;
	private final ClientSubscriptions<ClientId, List<Key>> subscriptions = new ClientSubscriptions<>();
	
	private MessagePublisherActor(ActorContext<AbstractMessage> context, MessageConverter<Key> messageConverter) {
		super(context);
		this.messageConverter = messageConverter;
	}

	public static <ClientId, Key> Behavior<AbstractMessage> create(MessageConverter<Key> messageConverter) {
		return Behaviors.setup((context) -> new MessagePublisherActor<ClientId, Key>(context, messageConverter));
	}
	
	@Override
	public Receive<AbstractMessage> createReceive() {
		return newReceiveBuilder().onMessage(PublishMessage.class, (message) -> {
			ClientObject<Key> converted = messageConverter.convert(message.getMessage());
			
			return this;
		}).build();
	}
}
