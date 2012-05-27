package br.com.fiap.webservice;

import java.util.List;

import javax.jws.WebService;
import br.com.fiap.bean.Contato;
import br.com.fiap.dao.ContatoDao;
import br.com.fiap.dao.ContatoDaoImpl;

@WebService(endpointInterface = "br.com.fiap.webservice.ContatoServer")
public class ContatoServerImpl implements ContatoServer {

	private ContatoDao contatos = new ContatoDaoImpl();

	@Override
	public String addContact(Contato contato) {

		return contatos.save(contato);
	}

	@Override
	public Contato getContact(Contato contato) {
		return contatos.getContato(contato);
	}

	@Override
	public String deleteContact(Contato contato) {

		return contatos.removeRecord(contato);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Contato[] listContacts() {

		List retorno = contatos.list();
		Contato[] contatos = new Contato[retorno.size()];
		for (int i = 0; i < retorno.size(); i++) {
			contatos[i] = (Contato) retorno.get(i);
		}

		return contatos;
	}
}