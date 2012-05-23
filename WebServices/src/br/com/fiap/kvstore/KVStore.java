package br.com.fiap.kvstore;

import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;
import oracle.kv.Key;
import oracle.kv.Value;
import oracle.kv.ValueVersion;

public class KVStore {
		
	String[] hhosts = {"localhost:5000"};
	KVStoreConfig kconfig = new KVStoreConfig("kvstore", hhosts);
	oracle.kv.KVStore kvstore = KVStoreFactory.getStore(kconfig);
		
	public String put(Key myKey, String data) {
				
		Value myValue = Value.createValue(data.getBytes());	
		kvstore.put(myKey, myValue);
		return "Sucess";
		
	}

	public String get(Key key) {
				
		ValueVersion vv = kvstore.get(key);
		Value v = vv.getValue();		
		String dados = new String(v.getValue());
		System.out.println(dados.toString());
		return dados;
	}	

}