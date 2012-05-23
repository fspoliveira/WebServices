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
	@WebMethod Contato getContact(String email);
	@WebMethod String deleteContact(String email);
	@WebMethod String updateContact(String email);
	
}