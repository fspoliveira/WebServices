package br.com.fiap.client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import br.com.fiap.webservice.ContatoServer;
import java.net.MalformedURLException;
import java.net.URL;


public class ContatoClient {

	public static void main(String[] args) throws MalformedURLException {
		
		URL url = new URL("http://localhost:9103/contatos?wsdl");
		
		QName qname = new QName("http://webservice.fiap.com.br/", "ContatoServerImplService");

		Service service = Service.create(url, qname);
		ContatoServer cs = service.getPort(ContatoServer.class);
		
		cs.getContact("fspo1@hotmail.com");
		
	}

}
