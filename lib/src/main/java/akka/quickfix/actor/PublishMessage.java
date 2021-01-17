package akka.quickfix.actor;

import quickfix.Message;

public class PublishMessage extends AbstractMessage {

	private final Message message;
	
	public PublishMessage(Message message) {
		this.message = message;
	}
	
	public Message getMessage() {
		return message;
	}
}
