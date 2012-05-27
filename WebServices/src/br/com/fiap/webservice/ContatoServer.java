package br.com.fiap.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.com.fiap.bean.Contato;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ContatoServer {
	
	@WebMethod String addContact(Contato contato);
	@WebMethod String deleteContact(Contato contato);
	@WebMethod Contato getContact(Contato contato);	
	@WebMethod Contato[] listContacts();
	
}