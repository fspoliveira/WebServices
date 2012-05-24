package br.com.fiap.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ClassInformation {
	
	public List<String> getAttribute(String classe){
		
		List<String>  fields = new ArrayList<String>();
		try {
			@SuppressWarnings("rawtypes")
			Class cls = Class.forName(classe);

			Field fieldlist[] = cls.getDeclaredFields();
			for (int i = 1; i < fieldlist.length; i++) {
				Field fld = fieldlist[i];
				System.out.println("name  = " + fld.getName());
				fields.add(fld.getName());			
				
			}
		} catch (Throwable e) {
			System.err.println(e);
		}
		return fields;
	}

}
