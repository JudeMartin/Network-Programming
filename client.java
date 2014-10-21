import java.io.*;
import java.net.*;

public class client 
{

	public static void main(String[] args) throws IOException
	{
		Socket echoSocket = null;
		try 
		{
			echoSocket = new Socket("192.168.0.105", 10101);
			
		}
		catch (UnknownHostException e) 
		{
			System.err.println("Couldn't connect to local host");
		}
		catch (IOException e) 
		{
			System.err.println("Couldn't get I/O for the connection to local host");
		}
		
		BufferedReader in = new BufferedReader ( new InputStreamReader (echoSocket.getInputStream()));  
		PrintWriter os = new PrintWriter(new BufferedWriter ( new OutputStreamWriter(echoSocket.getOutputStream())),true);
		String userInput;
		
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
				
			while ((userInput = stdIn.readLine()) != null) 
			{
				os.println(userInput);
				
				if(userInput.equals("QUIT"))
					break;
				
				System.out.println("echo: " + in.readLine());
			}
			
			os.close();
			in.close();
			echoSocket.close();
		
		
		
	}
}