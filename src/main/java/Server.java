import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            try (Socket clientSocket = serverSocket.accept(); // ждем подключения
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                System.out.println("New connection accepted");
                System.out.printf("User: %s%n", in.readLine());
                out.println("как тебя зовут");
                final String name = in.readLine();
                System.out.printf("User: меня зовут %s%n",name);
                out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
