package br.com.fiap.webservice;

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
		// TODO Auto-generated method stub
		return contatos.remove(email);
	}

	/*@Override
	public List<Contato> listContacts() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
}