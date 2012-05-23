package br.com.fiap.webservice;

import javax.jws.WebService;

import br.com.fiap.bean.Contato;

@WebService(endpointInterface = "br.com.fiap.webservice.ContatoServer")
public class ContatoServerImpl implements ContatoServer{

	@Override
	public String addContact(Contato contato) {
		System.out.println("Contact insert sucessfull");
		return null;
	}

	@Override
	public Contato getContact(String email) {
		System.out.println("Contact get sucessfull");
		return null;
	}

	@Override
	public String deleteContact(String email) {
		// TODO Auto-generated method stub
		System.out.println("Contact delete sucessfull");
		return null;
	}

	@Override
	public String updateContact(String email) {
		// TODO Auto-generated method stub
		System.out.println("Contact update sucessfull");
		return null;
	}
	
}