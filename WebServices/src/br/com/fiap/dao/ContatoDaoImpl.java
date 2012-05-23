package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;
import br.com.fiap.bean.Contato;
import br.com.fiap.kvstore.KVStore;

public class ContatoDaoImpl implements ContatoDao {
	
	private static List<String> majorComponents = new ArrayList<String>();
	private static List<String> minorComponents = new ArrayList<String>();
	private static KVStore kvstore = new KVStore();

	@Override
	public void save(Contato contato) {
		// TODO Auto-generated method stub
		majorComponents.add(contato.getEmail());
		minorComponents.add("phonenumber");
	}

	@Override
	public void remove(Contato contato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contato getContato(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> list() {
		// TODO Auto-generated method stub
		return null;
	}

}