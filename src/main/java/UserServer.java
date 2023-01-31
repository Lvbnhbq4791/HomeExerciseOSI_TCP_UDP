import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class UserServer {

    public static void main(String... args) {

        try (Socket socket = new Socket("127.0.0.1", 8080);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            Scanner scanner = new Scanner(System.in);
            out.println("Привет Сервер");
            System.out.printf("Server: %s%n",in.readLine());
            out.println(scanner.nextLine());
            System.out.printf("Server: %s%n",in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
