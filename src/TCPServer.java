import java.net.*;
import java.io.*;

public class TCPServer {
    private static int addNumbers(int num1, int num2) {
        return num1 + num2;
    }

    private static void handleRequest(Socket clientSocket) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            // receive the request data
            String requestData = in.readLine();
            // parse the request data
            String[] numbers = requestData.split("\\+");
            int num1 = Integer.parseInt(numbers[0].trim());
            int num2 = Integer.parseInt(numbers[1].trim());
            // add the numbers
            int result = addNumbers(num1, num2);
            // send the response data
            out.println(result);
        }
    }

    public static void main(String[] args) throws IOException {
        // create a TCP/IP socket
        ServerSocket serverSocket = new ServerSocket(12345);
        while (true) {
            // wait for a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected by " + clientSocket.getInetAddress());
            // handle the client request
            handleRequest(clientSocket);
        }
    }
}
