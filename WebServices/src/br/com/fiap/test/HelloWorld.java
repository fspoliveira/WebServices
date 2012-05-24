package br.com.fiap.test;

import java.util.List;
import oracle.kv.Key;
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

}
