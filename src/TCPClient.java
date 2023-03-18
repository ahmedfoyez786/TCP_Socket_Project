import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        // create a TCP/IP socket
        Socket socket = new Socket("localhost", 12345);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {
            // read input from the user
            System.out.print("Enter two numbers to add (in the format num1+num2): ");
            String requestData = scanner.nextLine();
            // send the request data
            out.println(requestData);
            // receive the response data
            String responseData = in.readLine();
            // print the result
            System.out.println("Result: " + responseData);
        }
    }
}
