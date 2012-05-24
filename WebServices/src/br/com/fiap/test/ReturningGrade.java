package br.com.fiap.test;

import java.util.ArrayList;

public class ReturningGrade {
	public static void main(String[] args)
	
	    {

	        ArrayList grade = new ArrayList();

	        System.out.println("Initial size of grade is: " +grade.size());

	        grade.add("A");
	        grade.add("C");

	        grade.add("D");

	        grade.add("F");

	         

	        Object letterGrade[] = grade.toArray();

	        int letgrade = 0;

	        // sum the array

	       

	        System.out.println("Your letter grade is: "  +grade.toArray());
	        System.out.println(grade.toArray(letterGrade));
	    }

	        

}
