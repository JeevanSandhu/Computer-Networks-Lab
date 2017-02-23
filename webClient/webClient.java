import java.net.*;
import java.io.*;

public class webClient
{
    public static void main(String[] args) throws Exception
    {
        String html;
        URL urlObject = new URL("http://www.bits-pilani.ac.in/Uploads/Campus/BITS_Dubai_campus_logo.gif");
        
        URLConnection connection = urlObject.openConnection();
        connection.connect();
        //Once you open the connection to URL object
        //beneath it a client socket get connected to server
        //and send all the http request headers derived from
        //the url are sent via the socket, also http repsonse
        //headers also got
        
        InputStream FromServer = connection.getInputStream();
        byte[] data= new byte[100];
        int count;
        String fileName = "C:\\Users\\admin\\Desktop\\myFile.gif";
        FileOutputStream outputFileStream = new FileOutputStream(fileName, true);
        while((count = FromServer.read(data))!=-1)
        {
            outputFileStream.write(data, 0, count);
        }
        outputFileStream.flush();
        outputFileStream.close();
    }
}
