import java.net.*;
import java.io.*;
import java.util.*;
public class TCPClient
{
public static void main(String args[])throws IOException
{
try
{
//creating client socket with default ip and port nos and establishing connection with server whose ip is 127.0.0.0 and port 95
Socket con= new Socket("localhost",95);
//creating in object to read data from socket
BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream()));
//creating out object to write data into socket
PrintWriter out=new PrintWriter(con.getOutputStream(),true);
System.out.print("enter the message to the server:");
BufferedReader din=new BufferedReader(new InputStreamReader(System.in));
//reading data from keyboard inorder to send to server
System.out.println("Enter 5 nums");
int a[]=new int[5];
	for(int i=0;i<5;i++){
        a[i]=Integer.parseInt(din.readLine());
	}
String st=Arrays.toString(a);
//writing(sending) data to server
out.println(st);
//reading(recieving) data from server
String s1=in.readLine();
//printing data recived from server on console
System.out.println("from server:"+s1);
//closing all the streams opened
in.close();
out.close();
con.close();
}
catch(UnknownHostException e)
{
}

}
}
