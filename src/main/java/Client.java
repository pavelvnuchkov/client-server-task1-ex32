import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket client = new Socket("localhost", Server.PORT)) {

            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("Клиент Павла стартовал");
            writer.println("Павел!!!!!");

            final String message = reader.readLine();
            System.out.println("Сервер прислал: " + message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
