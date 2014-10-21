import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientProgramming {
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Socket echosocket = new Socket("192.168.0.105", 10102);

		Scanner scoketInputString = new Scanner(echosocket.getInputStream());
		PrintWriter scoketOutputString = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(echosocket.getOutputStream())));

		Scanner userInputString = new Scanner(System.in);

		while (userInputString.nextLine() != null) {
			String userInputStringStorage = userInputString.next();
			scoketOutputString.println(userInputStringStorage);
			scoketOutputString.flush();

			if (userInputStringStorage.equalsIgnoreCase("quit")) {
				break;
			}
			System.out.println("Echoed output:" + scoketInputString.next());
		}
		echosocket.close();
		scoketInputString.close();
		userInputString.close();
	}
}
