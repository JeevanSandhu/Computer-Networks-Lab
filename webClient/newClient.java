import java.io.*;
import java.net.*;

public class newClient
{
	public static void main(String[] args) throws Exception
	{
		URL url = new URL("https://smartspot.co.in");
		URLConnection connection = url.openConnection();
		connection.connect();

		BufferedReader fromServer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String fileName = "/home/jeevan/Desktop/asdf.html";
		FileWriter fileWriter = new FileWriter(fileName, true);
		String html;

		while((html = fromServer.readLine()) != null)
		{
			fileWriter.write(html);
			fileWriter.write("\n");
		}

		fileWriter.flush();
		fileWriter.close();
	}
}