import java.net.*;
import java.io.*;

public class TCPSimpleServer
{
    public static void main(String[] args) throws Exception
    {
        //Create a ServerSocket via port number 6969
        ServerSocket serverSocket = new ServerSocket(6969);

        //Listen for connection from the client
        Socket clientSocket = serverSocket.accept();
        
        //clientSocket is used for further communication between the server and client
        //sockets being byte oriented devices, we should attach inputstream as well as outputstream
        
        BufferedReader inputFromClientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter outputToClientWriter = new PrintWriter(clientSocket.getOutputStream());

        //Read data sent by the client
        String input = inputFromClientReader.readLine();
        System.out.println("Recieved : " + input);
        
        //Convert the string to uppper case
        String output = input.toUpperCase();
        System.out.println("Sent : " + output);
        
        //Send the string back to the client. Important to flush at the end.
        outputToClientWriter.println(output);//write into PrintWriter
        outputToClientWriter.flush();
    }
}