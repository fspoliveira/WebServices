package br.com.fiap.publisher;

import javax.xml.ws.Endpoint;
import br.com.fiap.webservice.ContatoServerImpl;

public class ContatoPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9007/contatos", new ContatoServerImpl());
	}

}