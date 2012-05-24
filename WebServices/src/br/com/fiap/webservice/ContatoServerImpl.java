package br.com.fiap.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import br.com.fiap.bean.Contato;
import br.com.fiap.dao.ContatoDao;
import br.com.fiap.dao.ContatoDaoImpl;


@WebService(endpointInterface = "br.com.fiap.webservice.ContatoServer")
public class ContatoServerImpl implements ContatoServer{
	
	
	private ContatoDao contatos = new ContatoDaoImpl();


	@Override
	public String addContact(Contato contato) {
		
		return contatos.save(contato);
		
	}

	@Override
	public Contato getContact(String email) {
		return contatos.getContato(email);
	}

	@Override
	public String deleteContact(String email) {
		
		return contatos.removeRecord(email);
	}

	@Override
	public ArrayList<Contato> listContacts() {
		//List<Contato> cont = contatos.list();
		
		//return (ArrayList<Contato>) cont;
		return (ArrayList<Contato>) contatos.list();
		//return null;
	}
	
}