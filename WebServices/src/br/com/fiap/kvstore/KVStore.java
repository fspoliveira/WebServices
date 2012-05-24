package br.com.fiap.kvstore;

import java.util.Iterator;

import oracle.kv.Direction;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;
import oracle.kv.Key;
import oracle.kv.KeyValueVersion;
import oracle.kv.Value;
import oracle.kv.ValueVersion;

public class KVStore {
		
	String[] hhosts = {"localhost:5000"};
	KVStoreConfig kconfig = new KVStoreConfig("kvstore", hhosts);
	oracle.kv.KVStore kvstore = KVStoreFactory.getStore(kconfig);
			
	public String put(Key myKey, String data) {
				
		Value myValue = Value.createValue(data.getBytes());	
		kvstore.put(myKey, myValue);
		return "Record insert with sucess";
				
	}

	public String get(Key key) {				
		ValueVersion vv = kvstore.get(key);
		Value v = vv.getValue();		
		String dados = new String(v.getValue());
		System.out.println(dados.toString());
		return dados;
	}
	
	public String delete(Key myKey){
		kvstore.delete(myKey);
		return "Delete record with sucess"; 
	}
	
	public Iterator<KeyValueVersion> storeIterator(Direction d, int y){
		return kvstore.storeIterator(d,y);
	}

}