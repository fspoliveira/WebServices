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
	Key myKey = null;

	@Override
	public String save(Contato contato) {

		majorComponents.add(contato.getEmail());
		minorComponents.add("nome");
		myKey = Key.createKey(majorComponents, minorComponents);
		return kvstore.put(myKey, contato.getNome());

	}

	@Override
	public String remove(Contato contato) {
		// TODO Auto-generated method stub
		return "Removido com sicesso";

	}

	@Override
	public Contato getContato(String email) {
		Contato c = new Contato();

		if (myKey instanceof Key) {
			myKey = Key.createKey(majorComponents, minorComponents);	
			c.setNome(kvstore.get(myKey));
		} else {
			majorComponents.add(email);
			minorComponents.add("nome");
			myKey = Key.createKey(majorComponents, minorComponents);
			c.setNome(kvstore.get(myKey));
		}

		return c;
	}

	/*
	 * @Override public List<Contato> list() { // TODO Auto-generated method
	 * stub return null; }
	 */

}