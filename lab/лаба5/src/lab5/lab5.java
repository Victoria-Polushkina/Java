package lab5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class lab5 {
	private static Scanner s;

    public static void main(String[] args) {
        // TODO code application logic here
        
    	String csvFile = "Толстой.txt";
        String line = "";
    HashMap<Character, Integer> med = new HashMap<Character, Integer>();
 Scanner s= new Scanner(System.in);
 char x;
         try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

             while ((line = br.readLine()) != null) {
                 for(int i = 0; i<line.length(); i++)
                 {x = line.charAt(i);
                  if (med.containsKey(x))
            {
                int j = med.get(x);
                med.put(x, (j+1));
            }
            else
            {
                med.put(x, 1);
            }      
                  }
                 
             }
             med.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).forEach(System.out::println);
             int max = 0;
             for(Character d: med.keySet())
             {
            	 if(med.get(d) > max)
            		 max = med.get(d);
            	 
             }
             int mid;
             for(Character d: med.keySet())
             {
            	 mid = (med.get(d)*100)/max;
            	 
            	 if(mid == 0)
            		 continue;
            	 System.out.print(d+":");
            	 for(int j = 0;j<mid;j++)
            		 System.out.print("|");
            	 System.out.println("");
            	 
             }
             
            	
         } catch (IOException e) {
             e.printStackTrace();
         } 
     }
     
 }
