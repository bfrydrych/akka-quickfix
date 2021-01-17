package akka.quickfix;

import quickfix.Message;

public interface MessageConverter<Key> {

	ClientObject<Key> convert(Message message);
	
}
