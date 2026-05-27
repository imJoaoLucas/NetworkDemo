import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class Client {
   public void start(int port, Scanner scanner) {
      try (Socket clientSocket = new Socket("localhost", port); //Creating a socket called localhost 
           PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) { //Using the printwriter class to wrap the outputstream and use print methods auto flush enabled
         System.out.println("Socket created");
         for (String text; !(text = scanner.nextLine()).isEmpty();) {
             writer.println(text);
         }
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }
}