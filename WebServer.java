import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.io.*;

/*
At this class I'll create a basic web server (at its completion, 
starting just as a socket server and than making it handle http requests).
*/


public class WebServer {
   public void start(int port) {
      try (ServerSocket serverSocket = new ServerSocket(port)) {
      
         while (true) {
            System.out.println("Waiting for clients...");
         
            Socket clientSocket = serverSocket.accept(); //A single client connection
            System.out.println("Client Connected! ");
            new Thread(new ClientHandler(clientSocket)).start();
         }
         
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }
}