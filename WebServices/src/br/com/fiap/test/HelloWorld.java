package br.com.fiap.test;

import java.util.List;
import oracle.kv.Key;
import oracle.kv.Value;
import oracle.kv.ValueVersion;

import java.util.ArrayList;

import br.com.fiap.kvstore.KVStore;

public class HelloWorld {

	private static List<String> majorComponents = new ArrayList<String>();
	private static List<String> minorComponents = new ArrayList<String>();
	private static KVStore kvstore = new KVStore();

	public static void main(String args[]) {

		HelloWorld h = new HelloWorld();
		
		majorComponents.add("fspo1@hotmail.com");
		minorComponents.add("nome");
		Key myKey = Key.createKey(majorComponents, minorComponents);
		//kvstore.put(myKey, "Fernando Santiago");
		kvstore.get(myKey);
		
		if(myKey  instanceof Key){
			
		}else
		{
			majorComponents.add("fspo1@hotmail.com");
			minorComponents.add("nome");
			 myKey = Key.createKey(majorComponents, minorComponents);
		}
		
	
		//kvstore.put(myKey, "Fernando Santiago");
		kvstore.get(myKey);
		
	/*	majorComponents.add("cmarquesani@hotmail.com");
		minorComponents.add("nome");
		Key myKey = Key.createKey(majorComponents, minorComponents);
		//kvstore.put(myKey, "Fernando Santiago");
		kvstore.get(myKey);*/


		

	}


}
