package akka.quickfix;

public interface ClientEndpoint<Key> {

	void accept(ClientObject<Key> object);
}
