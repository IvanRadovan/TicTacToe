package server_client_chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public Client() {

        try (Socket socket = new Socket("localhost", 9999)) {

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            new ReceivingThread(in, "SERVER").start();
            while (!socket.isClosed()) {
                String input = scanner.nextLine();
                out.println(input);

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
