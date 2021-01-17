package akka.quickfix;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientSubscriptions<ClientId, Key> {

	private final Map<ClientId, Key> subscriptions = new ConcurrentHashMap<>();
	
	public void addSubscription(ClientId id, Key key) {
		subscriptions.put(id, key);
	}
}
