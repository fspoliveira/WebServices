package br.com.fiap.test;

import java.util.Iterator;
import java.util.List;

import oracle.kv.Direction;
import oracle.kv.Key;
import oracle.kv.KeyValueVersion;
import oracle.kv.Value;
import oracle.kv.ValueVersion;

import java.util.ArrayList;

import br.com.fiap.kvstore.KVStore;

public class HelloWorld {

	private static KVStore kvstore = new KVStore();

	public static void main(String args[]) {

		HelloWorld h = new HelloWorld();
		h.getRecord("cmarquesani@hotmail.com", "nome");
		h.getRecord("cmarquesani@hotmail.com", "nome");

		h.teste();

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

	public void teste() {
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
			// kvstore.delete(key);

		}

	}
}
