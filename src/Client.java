import com.sun.org.omg.CORBA.Initializer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int PORT = 8189;
    private static final String IP_ADRESS = "localhost";
    private static Socket socket;
    public static void main(String[] args) {
        try {
            socket = new Socket(IP_ADRESS,PORT);
            System.out.println("Подключился");
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            Scanner console = new Scanner(System.in);
            while (true) {

                String inCons = in.nextLine();
                System.out.println("Сервер: " + inCons);
                System.out.println("Введите сообщение");
                String cons = console.nextLine();
                if(cons.equals("/end")){
                    System.out.println("Клиент отключился");
                    break;
                }
                System.out.println("Клиент: " + cons);
                out.println(cons);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
