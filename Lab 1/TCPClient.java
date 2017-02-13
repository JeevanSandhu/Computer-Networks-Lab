import java.io.*;
import java.net.*;

public class TCPClient
{
	public static void main(String[] args) throws Exception
	{
		//create socket object at the client to connect to server
		Socket client= new Socket("127.0.0.1", 6969);
		
		System.out.println("Connected to server...");

		BufferedReader inputServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintWriter outputServer = new PrintWriter(client.getOutputStream());
		OutToServer.println("Hi from Client!");
		OutToServer.flush();
		String received = InputServer.readLine();
		System.out.println("Received from server: " + received);
	}
}
