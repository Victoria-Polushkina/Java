package mas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class lab4 {

    public static void main(String[] args) {
        
        
        // TODO code application logic here
        
        Random r = new Random();
        int min = 0;
        int max = 9;
        ArrayList randlist = new ArrayList();
        HashMap<Double, Integer> med = new HashMap<Double, Integer>();
        
        randlist.ensureCapacity(10);
        for (int i = 0; i<=100; i++)
        {if (randlist.size() < 6)
                randlist.add(r.nextInt((max - min) + 1) + min);
            else 
            { randlist.remove(0);
                randlist.add(r.nextInt((max - min) + 1) + min);}
           System.out.print(randlist);
           ArrayList randlist2 = new ArrayList(randlist);
           Collections.sort(randlist2);
           
           System.out.print("  " + randlist2);
           double med1;
           if(randlist2.size()%2==0)
           {
               int a  = randlist2.size()/2;
               double b = (int)randlist2.get(a);
               double c = (int)randlist2.get(a-1);
               med1 = (b+c)/2;
               System.out.println("   " + ((b+c)/2));
           }
           else
           {
               int d = (int) randlist2.get(randlist2.size()/2);
               med1 = (double)d;
               System.out.println("  " + (randlist2.get(randlist2.size()/2)));
           }
           if (med.containsKey(med1))
           {
               int e = med.get(med1);
               med.put(med1, (e+1));
           }
           else
           {
               med.put(med1, 1);
           }
           }
        System.out.println(med);
      
        
    }}
