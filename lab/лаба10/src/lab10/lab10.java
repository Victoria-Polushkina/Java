package lab10;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class lab10 {

public static void main(String[] args) {

try {
Socket s = new Socket(InetAddress.getLocalHost(), 8888);
PrintStream ps = new PrintStream(s.getOutputStream());
BufferedReader br = new BufferedReader(
new InputStreamReader(s.getInputStream()));
Scanner scanner = new Scanner(System.in);
while(true) {
String input = scanner.nextLine();
if (input.equals("stop"))
    break;
ps.println(input);
System.out.println(br.readLine());

}
s.close();
} 
catch (UnknownHostException e) {
System.out.println("wrong adress");
e.printStackTrace();
} catch (IOException e) {
System.out.println("I|O");
e.printStackTrace();
}
}
}