package lab9;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class lab9 {

public static void main(String[] args) {

try {
ServerSocket serv = new ServerSocket(8888);
System.out.println("start");

while (true) {
Socket sock = serv.accept();
System.out.println(sock.getInetAddress().getHostAddress() + "connect");
ServerThread server = new ServerThread(sock);
server.start();
}
} catch (IOException e) {

System.err.println(e);

}
}
}

class Calc{
public float add(float a, float b){
    float c;
    c = a + b;
return c;}
public float subs(float a, float b){
    float c;
    c = a - b;
return c;}
public float mult(float a, float b){
    float c;
    c = a * b;
return c;}
public float divide(float a, float b){
    float c;
    c = a / b;
return c;}
}

class ServerThread extends Thread {
private PrintStream os;
private BufferedReader is;
private InetAddress addr;

public ServerThread(Socket s) throws IOException {

os = new PrintStream(s.getOutputStream());
is = new BufferedReader(
new InputStreamReader(
s.getInputStream()));
addr = s.getInetAddress();
}

public void run() {
int i = 0;
String str;
Calc c = new Calc();
try {
while ((str = is.readLine()) != null) {
StringTokenizer stk = new StringTokenizer(str," ");	    
	    ArrayList<String> list = new ArrayList<String>();
	    String []ar = new String[stk.countTokens()];
            if (ar.length != 3)
            {
                os.println("wrong input");
                continue;}
	    for(int j = 0; j<ar.length; j++)
	    {
	    	ar[j] = stk.nextToken();
	    }
    
      float a,b;
      a = Float.parseFloat(ar[0]);
      b = Float.parseFloat(ar[2]); 
      
      if (ar[1].equals("add"))
      {os.println(c.add(a,b));}
      else if (ar[1].equals("subs"))
      {os.println(c.subs(a, b));}
      else if (ar[1].equals("mult"))
      {os.println(c.mult(a, b));}
      else if (ar[1].equals("divide"))
      {
      if (b == 0)
          os.println("divide 0");
      else
          os.println(c.divide(a, b));
      }
      else
          os.println("wrong input");
}
} catch (IOException e) {
System.out.println("disconnected");
} 
finally {
disconnect();
}
}

public void disconnect() {
try {

System.out.println(addr.getHostName()+ "disconnected");

os.close();
is.close();

} catch (IOException e) {
e.printStackTrace();
} 
finally {
this.interrupt();
}
}
}