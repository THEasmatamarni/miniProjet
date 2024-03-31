package chat_socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Connected to chat server. Start chatting:");

            // Thread to read messages from the server
            Thread readThread = new Thread(() -> {
                String serverMessage;
                try {
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            readThread.start();

            // Thread to send messages to the server
            while (true) {
                String message = scanner.nextLine();
                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
