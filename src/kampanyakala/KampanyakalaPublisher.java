package kampanyakala;

import javax.xml.ws.Endpoint;
import kampanyakala.KonumKarsilaImpl;

public class KampanyakalaPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://0.0.0.0:6153/ws/hello", new KonumKarsilaImpl());
	}
}