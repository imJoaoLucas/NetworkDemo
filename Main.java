import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      final int PORT_NUMBER = 4123;
      
      try (Scanner scanner = new Scanner(System.in)) {
         System.out.println("Is this a server? (y/n)");
         if (scanner.nextLine().equalsIgnoreCase("y")) {
            new WebServer().start(PORT_NUMBER);
         } else {
         System.out.println("Client TODO");
         }
      }
      
   }
}