import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 8080;

    public static void main(String[] args) {


        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                final String message = in.readLine();
                System.out.println("Подключение нового клиента");
                out.println(String.format("Привет %s, твой порт %d", message, clientSocket.getPort()));
                System.out.printf("Клиент прислал: %s с порта: %d", message, clientSocket.getPort());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
