package br.com.fiap.test;

import java.util.ArrayList;

public class testando {
	
	public static void main(String args[]){
		ArrayList<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");

		String listString = "";

		for (String s : list)
		{
		    listString += s + "\n";
		}

		System.out.println(listString);
	}
	

}
