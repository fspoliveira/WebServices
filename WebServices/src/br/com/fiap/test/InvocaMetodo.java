package br.com.fiap.test;

import java.lang.reflect.Method;

public class InvocaMetodo {
	
	public int umMetodo(int a, int b) {  
        return a + b;  
    }  
    
    public static void main(String args[]) {  
        try {  
            Class partypes[] = new Class[2];  
            partypes[0] = Integer.TYPE;  
            partypes[1] = Integer.TYPE;  
  
            Class cls = Class.forName("br.com.fiap.test.InvocaMetodo");  
            Method meth = cls.getMethod("umMetodo", partypes);  
  
            Object arglist[] = new Object[2];  
            arglist[0] = new Integer(37);  
            arglist[1] = new Integer(47);  
  
            InvocaMetodo methobj = new InvocaMetodo();  
            Object retobj = meth.invoke(methobj, arglist);  
            Integer retval = (Integer)retobj;  
            System.out.println(retval.intValue());  
        }  
        catch (Throwable e) {  
            System.err.println(e);  
        }  
    }

}
