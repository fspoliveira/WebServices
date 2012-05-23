package br.com.fiap.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import oracle.kv.Key;

import br.com.fiap.bean.Contato;
import br.com.fiap.dao.ContatoDao;
import br.com.fiap.dao.ContatoDaoImpl;
import br.com.fiap.kvstore.KVStore;

@WebService(endpointInterface = "br.com.fiap.webservice.ContatoServer")
public class ContatoServerImpl implements ContatoServer{
	
	private static List<String> majorComponents = new ArrayList<String>();
	private static List<String> minorComponents = new ArrayList<String>();
	private static KVStore kvstore = new KVStore();
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
		// TODO Auto-generated method stub
		System.out.println("Contact delete sucessfull");
		return null;
	}

	/*@Override
	public List<Contato> listContacts() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
}