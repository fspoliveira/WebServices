package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import oracle.kv.Key;
import br.com.fiap.bean.Contato;
import br.com.fiap.kvstore.KVStore;

public class ContatoDaoImpl implements ContatoDao {
	
	private static List<String> majorComponents = new ArrayList<String>();
	private static List<String> minorComponents = new ArrayList<String>();
	private static KVStore kvstore = new KVStore();

	@Override
	public String save(Contato contato) {
		// TODO Auto-generated method stub
		majorComponents.add(contato.getEmail());
		minorComponents.add("nome");
		Key myKey = Key.createKey(majorComponents, minorComponents);
		return kvstore.put(myKey, contato.getNome());
		
	}

	@Override
	public String remove(Contato contato) {
		// TODO Auto-generated method stub
		return "Removido com sicesso";
		
	}

	@Override
	public Contato getContato(String email) {
		majorComponents.add(email);
		minorComponents.add("nome");
		Key myKey = Key.createKey(majorComponents, minorComponents);
		
		System.out.println("Email que chegou no get" + email);
	
		Contato c = new Contato();
		c.setNome(kvstore.get(myKey));
		
		return c;
	}

	/*@Override
	public List<Contato> list() {
		// TODO Auto-generated method stub
		return null;
	}*/

}