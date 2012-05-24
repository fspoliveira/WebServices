package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import oracle.kv.Direction;
import oracle.kv.Key;
import oracle.kv.KeyValueVersion;
import oracle.kv.Value;
import br.com.fiap.bean.Contato;
import br.com.fiap.kvstore.KVStore;

public class ContatoDaoImpl implements ContatoDao {

	private static KVStore kvstore = new KVStore();
	private static Key myKey;
	private List<Contato> contatos = new ArrayList<Contato>();
	

	@Override
	public String save(Contato contato) {
		
		List<String> majorComponents = null;
		List<String> minorComponents = null;
		
		if (kvstore instanceof KVStore) {
			majorComponents = new ArrayList<String>();
			minorComponents = new ArrayList<String>();
		}
		
		majorComponents.add(contato.getEmail());
		minorComponents.add("nome");
		myKey = Key.createKey(majorComponents, minorComponents);
		return kvstore.put(myKey, contato.getNome());

	}

	@Override
	public String remove(String email) {
		
		List<String> majorComponents = null;
		List<String> minorComponents = null;
		
		if (kvstore instanceof KVStore) {
			majorComponents = new ArrayList<String>();
			minorComponents = new ArrayList<String>();
		}
		
		majorComponents.add(email);
		minorComponents.add("nome");
		myKey = Key.createKey(majorComponents, minorComponents);
		return kvstore.delete(myKey);

	}

	@Override
	public Contato getContato(String email) {

		List<String> majorComponents = null;
		List<String> minorComponents = null;

		if (kvstore instanceof KVStore) {
			majorComponents = new ArrayList<String>();
			minorComponents = new ArrayList<String>();
		}

		Contato c = new Contato();

		majorComponents.add(email);
		minorComponents.add("nome");
		myKey = Key.createKey(majorComponents, minorComponents);
		c.setNome(kvstore.get(myKey));

		return c;
	}

	@Override
	public List<Contato> list() {
		
		Contato c = new Contato();
		// Create Iterator.
				Iterator<KeyValueVersion> iter = kvstore.storeIterator(
						Direction.UNORDERED, 100);
				// Now, iterate over the store.
				while (iter.hasNext()) {
					KeyValueVersion keyVV = iter.next();
					Value val = keyVV.getValue();
					Key key = keyVV.getKey();
					//System.out.println(val.toString() + " " + key.toString() + "\n");
					String dados = new String(val.getValue());
					System.out.println(dados);
					contatos.add(c);
					// kvstore.delete(key);
				}
				return contatos;
		
	}

}