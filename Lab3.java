package cisc3130Lab3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Lab3 {
	
	public static void main(String[]args) throws IOException {
			FileReader fr = new FileReader("regional-global-daily-latest.csv"); //Have to use BufferedReader because it stopped reading when I used Scanner
	        BufferedReader br = new BufferedReader(fr);
	        File output= new File(("Artists-WeekOf09062020.txt")); 
	        PrintWriter outputWriter = new PrintWriter(output);
	        br.readLine();
	        br.readLine();
	        HashSet<String> nameSet = new HashSet<String>(); //Creating a hashset to put all my data in
	        LinkedList<String> list = new LinkedList<String>();
	        for (String line = br.readLine(); line != null; line = br.readLine()) {
	        	String temp=line.split(",")[2]; // Sets the line with the artist name
	        	String result = temp.replaceAll("^\"+|\"+$", "");
	        	for(int i=0; i<result.length();i++) { // Loop to check for parenthesis so artist name is next
	        		char c=')';
	        		if(result.charAt(i)==c) {
	        			temp=line.split(",")[3];
	        			temp = temp.replaceAll("^\"+|\"+$", "");
	        			temp=temp.replaceAll("\\s+","");
	        			result = temp;
	        			break;
	        		}
	        	}
	        	String tem=new String(result);
	        	nameSet.add(tem); 
	        	}
	        	for(String artist : nameSet ) {
	        		list.add(artist);
	        	}
	        	Collections.sort(list);// Sorts the artists in Alphabetical order

	        	for(String artist : list ) { //Prints to outputF the toString from artistName
	        		System.out.println(artist);
	        	}
	        
	        	for(String artist : list ) { //Prints to outputF the toString from artistName
	        		outputWriter.println(artist);
	        	}
	        br.close();
	        outputWriter.close();     
	}
}
