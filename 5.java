import java.net.*;
import java.io.*;
import java.util.*;
public class TcpClient
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
while(true)
{ 
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
if(st.equalsIgnoreCase("bye")||st==null)
break;
}
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
import java.net.*;
import java.io.*;
import java.util.*;
public class TcpServer 
{
public static void main(String args[])throws IOException
{
try
{
//Server scoket creation with default ip address and port no 95
ServerSocket s= new ServerSocket(95);
System.out.println("Server Waiting for the Client");
//waiting for client requests
Socket cs=s.accept();
//Fetching client address and displaying
InetAddress ie=cs.getInetAddress();
String cli=ie.getHostAddress();
System.out.println("Connected to the client with IP "+cli);
//creating in object on client socket for read 
BufferedReader in=new BufferedReader(new InputStreamReader(cs.getInputStream()));
//creating out object on clinet socket for write
PrintWriter out=new PrintWriter(cs.getOutputStream(),true);
do
{ 
//reading(recieving) data from client(if no data from client waits till data is ready)
String st=in.readLine();
//converting into array
String c[]=st.replaceAll("\\[","").replaceAll("]","").replaceAll(" ","").split(",");
		
		int n[]=new int[c.length];
		for(int i=0;i<c.length;i++){
			n[i]=Integer.valueOf(c[i]);
		}
//sorting
TcpServer ts=new TcpServer();
ts.sort(n);
String res=Arrays.toString(n);
//writing(sending) data to client
out.println(res);
if(st.equalsIgnoreCase("bye")||st==null)
break;
//printing data from client on console
System.out.println("from client.  "+st);
}while(true);
//closing all streams opened
in.close();
out.close();
cs.close();
}
catch(IOException e)
{
}

}

void sort(int n[]){
	int i,j,temp;
	int l=n.length;
	for(i=0;i<l-1;i++){
		for(j=0;j<l-i-1;j++){
			if(n[j]>n[j+1]){
				temp=n[j];
				n[j]=n[j+1];
				n[j+1]=temp;
			}
		}
	}
}

}
