package lab3;
import java.util.Scanner;
class uravn{
public static void main (String args[]){
Scanner sc = new Scanner(System.in);
float a,b,c,d,x1,x2;
System.out.print("¬ведите а: ");
a = sc.nextFloat();
System.out.print("¬ведите b: ");
b = sc.nextFloat();
System.out.print("¬ведите c: ");
c = sc.nextFloat();
d=(float)Math.pow(b,2)-(4*a*c);
if (d<0){
          System.out.println("–ешени€ нет");
          }
          else { if (d==0) {
                          x1=b/(-2*a);
                          System.out.println("ќдно решение х= "+x1);
                          }
                            else{
                                x1=-b+(float)(Math.sqrt(d))/2*a;
                                x2=-b-(float)(Math.sqrt(d))/2*a;
                                System.out.println("x1= "+x1+" x2= "+x2);
                                }
                }
}
}