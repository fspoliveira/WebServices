package br.com.fiap.dao;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import oracle.kv.Direction;
import oracle.kv.Key;
import oracle.kv.KeyValueVersion;
import oracle.kv.Value;
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
			
			
			//teste
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
	public String remove(String email) {

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
			// System.out.println(val.toString() + " " + key.toString() + "\n");
			String dados = new String(val.getValue());
			System.out.println(dados);
			contatos.add(c);
			// kvstore.delete(key);
		}
		return contatos;

	}

}