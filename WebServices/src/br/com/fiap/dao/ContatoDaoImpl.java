package br.com.fiap.dao;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import oracle.kv.ConsistencyException;
import oracle.kv.Direction;
import oracle.kv.Key;
import oracle.kv.KeyValueVersion;
import oracle.kv.RequestTimeoutException;
import oracle.kv.Value;
import oracle.kv.ValueVersion;
import br.com.fiap.bean.Contato;
import br.com.fiap.kvstore.KVStore;
import br.com.fiap.reflect.ClassInformation;


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
		// save nome
		
		ClassInformation c = new ClassInformation();
		c.getAttribute("br.com.fiap.bean.Contato");
		
		List <String> fields = c.getAttribute("br.com.fiap.bean.Contato");
		for(int i=0; i < 2; i++){
			System.out.println(fields.get(i));
			minorComponents.add(fields.get(i));
			myKey = Key.createKey(majorComponents, minorComponents);
			
			try {  
	            Class partypes[] = new Class[0];  
	           // partypes[0] = Integer.TYPE;  
	           // partypes[1] = Integer.TYPE;  
	  
	            Class cls = Class.forName("br.com.fiap.bean.Contato");  
	           // Method meth = cls.getMethod("get".concat(fields.get(i)), partypes);  
	            
	            Method meth = cls.getMethod("get".concat(fields.get(i).substring(0,1).toUpperCase()+
	            		fields.get(i).substring(1)), partypes);  
	             
	            Object retobj = meth.invoke(contato);  
	            String retval = (String)retobj;  
	            
	            kvstore.put(myKey, retval);	
	             
	        }  
	        catch (Throwable e) {  
	            System.err.println(e);  
	        }  
								
		}

		/*minorComponents.add("nome");
		myKey = Key.createKey(majorComponents, minorComponents);
		kvstore.put(myKey, contato.getNome());

		minorComponents.add("telefone");
		myKey = Key.createKey(majorComponents, minorComponents);
		kvstore.put(myKey, contato.getTelefone());
*/
		return "show";

	}

	@Override
	public String removeRecord(String email) {

		List<String> majorComponents = null;		

		if (kvstore instanceof KVStore) {
			majorComponents = new ArrayList<String>();			
		}

		majorComponents.add(email);		
		myKey = Key.createKey(majorComponents);
		
		return kvstore.multiDelete(myKey);

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

		majorComponents.add(email.trim());
		
		minorComponents.add("nome");
		myKey = Key.createKey(majorComponents, minorComponents);
		c.setNome(kvstore.get(myKey));
		
		minorComponents.add("telefone");
		myKey = Key.createKey(majorComponents, minorComponents);
		c.setTelefone(kvstore.get(myKey));

		return c;
	}

	@Override
	public List<Contato> list() {

		Contato c ;
		// Create Iterator.
		Iterator<KeyValueVersion> iter = kvstore.storeIterator(
				Direction.UNORDERED, 100);
		
		
		HashSet<String> getMajorPath = new HashSet<String>();
		
		// Now, iterate over the store.
		while (iter.hasNext()) {
		
			
			KeyValueVersion keyVV = iter.next();
			Value val = keyVV.getValue();
			Key key = keyVV.getKey();
			System.out.println(val.toString() + " " + key.toString());
			String dados = new String(val.getValue());
			System.out.println(dados + "\n");
			
			System.out.println("Major Path" + key.getMajorPath());
			System.out.println("Minor Path" + key.getMinorPath());
			
			getMajorPath.add(key.getMajorPath().toString().replace("[", "").replace("]", ""));
						
			
			// kvstore.delete(key);
		}
		
		Iterator itr = getMajorPath.iterator();
		 while(itr.hasNext()){
			  String email;
		     // System.out.println(itr.next());
		 	  // c= new Contato();
			  email= (String) itr.next();
		       c = this.getContato(email);
		       contatos.add(c);
		  }
		
		 return contatos;

	}
	
	public void teste(){
		
		List<String> majorComponents = null;
		
		if (kvstore instanceof KVStore) {
			majorComponents = new ArrayList<String>();
			
		}
		
		majorComponents.add("fspoliveira@yahoo.com.br");
		
		Key myKey = Key.createKey(majorComponents);

		
		SortedMap<Key, ValueVersion> myRecords = null;
		
		try {
			myRecords = kvstore.multiGet(myKey);
			} catch (ConsistencyException ce) {
			// The consistency guarantee was not met
			} catch (RequestTimeoutException re) {
			// The operation was not completed within the
			// timeout value
			}
			
		for (Map.Entry<Key, ValueVersion> entry : myRecords.entrySet()) {
			ValueVersion vv = entry.getValue();
			Value v = vv.getValue();
		}
		
	}
	
	public static void main(String args[]){
		ContatoDaoImpl cdi = new ContatoDaoImpl();
		//cdi.teste();
		System.out.println(cdi.list().toString());
	}

}