package com.prospecta;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSV {
	
	static String question;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader( new FileReader("D:\\Revision\\proscepta_CSV\\src.csv"));
		
		while((question =  reader.readLine()) != null) {
			
			String[] lineArray = question.split(",");
			getAnswer(lineArray);
			
		}
		
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	//A1: 5, A2: 7, A3: 9, B1: 3, B2: 8, B3: =4+5, C1: =5+A1, C2: =A2+B2, C3: =C2+B3
	
	static Map<String,Integer> getAnswer(String[] lineArray){
		
		Map<String,Integer> ans = new HashMap<>();
		
		for(String str : lineArray) {
			String[] table = str.split(":");
			String col = table[0];
			String row = table[1];
			
			if(row.charAt(0) != '=') {
				ans.put(col, Integer.parseInt(row));
			}
			
			else {
				String[] lhs = row.split("+");
				int sum = 0;
				
				
			}
			
			
			
		}
		
		return null;
	}

	
	
}
