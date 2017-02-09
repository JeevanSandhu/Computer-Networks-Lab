import java.io.*;
import java.net.*;
import java.lang.*;

public class TCPServer implements Runnable
{    
    Socket socket;
    
    public TCPServer(Socket clientsocket)
    {
        socket = clientsocket;
    }

    public void run()
    {
        try
        {
            //Attach an input stream and outputstream to send/receive via the perclientsocket
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           
            //Accumulate all the input in a line. That is why we create a buffer...
            PrintWriter output = new PrintWriter(socket.getOutputStream());
      
            //Attach an input stream and outputstream
            //to send/receive via the clientsocket
            String fromClient = input.readLine();
            System.out.println("Received  : " + fromClient);

            String toClient = fromClient.toUpperCase();
            System.out.println("Sent  : " + toClient);
            
            output.println(toClient);
            output.flush();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws Exception
    {
        //create a ServerSocket via port number 6789 and wait for connection from client
        ServerSocket serverSocketObj = new ServerSocket(6969);
        //the server application will be assigned address of 6969

        while(true)
        {
            System.out.println("Server is listening on port 6969 ...");
            //Listen for connection from client
            Socket clientSocket = serverSocketObj.accept();

            //start a client thread to serve the connected client using clientsocket
            TCPServer TCPServerObj = new TCPServer(clientSocket);
            
            //create a thread for each client...
            Thread newClient = new Thread(TCPServerObj);
            newClient.start();
        }
    }
}
