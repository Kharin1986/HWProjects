package HW_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777)) { //try с ресурсами
            while (true) { // процесс подключения в бесконечном цикле
                Socket socket = serverSocket.accept(); // метод переводит сервер в режим ожидания до тех пор, пока
                                                        // никто не подключился
                System.out.println("Client connected!");

                try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     // ссылка на поток ввода
                     PrintWriter output = new PrintWriter(socket.getOutputStream())) {  // ссылка на поток вывода

                    while (!input.ready()) ;

                    while (input.ready()) {
                        System.out.println(input.readLine());
                    }
                    // отвечаем в браузер
                    output.println("HTTP/1.1 200 OK");
                    output.println("Content-Type: text/html; charset=utf-8");
                    output.println();
                    output.println("<p>Привет всем!</p>");
                    output.flush();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}