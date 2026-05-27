import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.io.*;

/*
At this class I'll create a basic web server (at its completion, 
starting just as a socket server and than making it handle http requests).
*/


public class WebServer {
   public void start(int portNumber) {
      try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
         System.out.println("Waiting for clients...");
         Socket clientSocket = serverSocket.accept(); //A single client connection
         String clientIp = clientSocket.getInetAddress().getHostAddress(); //Gets the client ip address
         int clientPort = clientSocket.getPort(); //Gets the client TCP port
         BufferedReader clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //Creates a buffered stream with the received data
         
         for (String input; (input = clientInput.readLine()) != null;) {
            String formatedInput = input.toUpperCase();
            System.out.printf("(%s:%d): %s%n", clientIp, clientPort, formatedInput);
         }
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }
}