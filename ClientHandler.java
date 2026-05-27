import java.lang.Runnable;
import java.net.Socket;
import java.util.*;
import java.io.*;


public class ClientHandler implements Runnable {
   private Socket clientSocket;
   
   public ClientHandler(Socket socket) {
      this.clientSocket = socket;
   }
   
   @Override
   public void run() {
      try (BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
           PrintWriter output = new PrintWriter(clientSocket.getOutputStream(),true)) { //Creates a buffered stream with the received data
           
         String clientIp = clientSocket.getInetAddress().getHostAddress(); //Gets the client ip address
         int clientPort = clientSocket.getPort(); //Gets the client TCP port 
              
         for (String inputLine; (inputLine = input.readLine()) != null;) {
            System.out.printf("(%s:%d): %s%n", clientIp, clientPort, inputLine);
            String formatedInput = inputLine.toUpperCase();
            output.println("Formated input: " + formatedInput);
         }
      } catch (IOException e) {
         System.out.println("Client disconnected");
      }
   }
}