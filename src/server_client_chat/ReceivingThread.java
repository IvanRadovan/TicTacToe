package server_client_chat;

import java.io.BufferedReader;
import java.io.IOException;

public class ReceivingThread extends Thread {

    private BufferedReader in;
    private String sender;

    public ReceivingThread(BufferedReader in, String sender) {
        this.in = in;
        this.sender = sender;
    }

    @Override
    public void run() {

        String receivedLine;
        try {
            while ((receivedLine = in.readLine()) != null) {
                System.out.println(sender + ": " + receivedLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
