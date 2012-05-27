package br.com.fiap.test;

import java.util.Iterator;
import java.util.List;

import oracle.kv.Direction;
import oracle.kv.Key;
import oracle.kv.KeyValueVersion;
import oracle.kv.Value;
import oracle.kv.ValueVersion;

import java.util.ArrayList;

import br.com.fiap.dao.ContatoDaoImpl;
import br.com.fiap.kvstore.KVStore;

public class TestCRUD {

	private static KVStore kvstore = new KVStore();

	public static void main(String args[]) {

		//TestCRUD h = new TestCRUD();

		// h.addRecord("", "");

		// h.getRecord("cmarquesani@hotmail.com", "nome");

		// System.out.println("Antes do remove");

		// h.listRecords();

		//h.multiDelete();
		// h.remove("fspoliveira@yahoo.com.br", "telefone");

		//System.out.println("Depois do remove");

		//h.listRecords();
		ContatoDaoImpl c = new ContatoDaoImpl();
		c.list();

	}

	public void addRecord(String majorCom, String minCom) {

		List<String> majorComponents = null;
		List<String> minorComponents = null;

		if (kvstore instanceof KVStore) {
			majorComponents = new ArrayList<String>();
			minorComponents = new ArrayList<String>();
		}

		majorComponents.add("fspoliveira@yahoo.com.br");

		minorComponents.add("nome");
		Key myKey = Key.createKey(majorComponents, minorComponents);
		kvstore.put(myKey, "Fernando Santiago");
		// kvstore.get(myKey);

		minorComponents.add("telefone");
		myKey = Key.createKey(majorComponents, minorComponents);
		kvstore.put(myKey, "2364 7979");
		// kvstore.get(myKey);
	}

	public void listRecords() {
		// Create Iterator.
		Iterator<KeyValueVersion> iter = kvstore.storeIterator(
				Direction.UNORDERED, 100);
		// Now, iterate over the store.
		while (iter.hasNext()) {
			KeyValueVersion keyVV = iter.next();
			Value val = keyVV.getValue();
			Key key = keyVV.getKey();
			System.out.println(val.toString() + " " + key.toString() + "\n");
			String dados = new String(val.getValue());
			System.out.println(dados);
			//kvstore.delete(key);
		}

	}

	public void getRecord(String majorCom, String minCom) {

		List<String> majorComponents = null;
		List<String> minorComponents = null;

		if (kvstore instanceof KVStore) {
			majorComponents = new ArrayList<String>();
			minorComponents = new ArrayList<String>();
		}

		majorComponents.add(majorCom);
		minorComponents.add(minCom);
		Key myKey = Key.createKey(majorComponents, minorComponents);
		kvstore.get(myKey);

	}

	public void remove(String majorCom, String minCom) {

		List<String> majorComponents = null;
		List<String> minorComponents = null;

		if (kvstore instanceof KVStore) {
			majorComponents = new ArrayList<String>();
			minorComponents = new ArrayList<String>();
		}

		majorComponents.add("fspoliveira@yahoo.com.br");

		minorComponents.add("nome");
		Key myKey = Key.createKey(majorComponents, minorComponents);

		// kvstore.get(myKey);

		minorComponents.add("telefone");
		myKey = Key.createKey(majorComponents, minorComponents);

		kvstore.delete(myKey);

	}

	public void removeRecord() {

		List<String> majorComponents = null;
		List<String> minorComponents = null;

		if (kvstore instanceof KVStore) {
			majorComponents = new ArrayList<String>();
			minorComponents = new ArrayList<String>();
		}

		majorComponents.add("fspoliveira@yahoo.com.br");

		minorComponents.add("nome");
		Key myKey = Key.createKey(majorComponents, minorComponents);

		// kvstore.get(myKey);

		minorComponents.add("telefone");
		myKey = Key.createKey(majorComponents, minorComponents);

		kvstore.delete(myKey);

	}

	public void multiDelete() {

		List<String> majorComponents = null;

		if (kvstore instanceof KVStore) {
			majorComponents = new ArrayList<String>();

		}

		majorComponents.add("fspoliveira@yahoo.com.br");

		Key myKey = Key.createKey(majorComponents);

		kvstore.multiDelete(myKey);
	}
}
