import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static int PORT = 8189;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");
            socket = server.accept();
            System.out.println("Клиент подключился");
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            Scanner console = new Scanner(System.in);
            while (true) {
                System.out.println("Введите сообщение");
                String cons = console.nextLine();
                System.out.println("Сервер: " + cons);
                if(cons.equals("/end")){
                    System.out.println("Клиент отключился");
                    break;
                }
                out.println(cons);
                System.out.println("Клиент: " + in.nextLine());

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}