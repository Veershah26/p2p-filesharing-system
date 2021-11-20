import java.io.*;
import java.net.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Integer;
import java.lang.Runnable;

@SuppressWarnings("unused")

public class Server {
    public static ArrayList<Fileinfo> global_array = new ArrayList<FileInfo>();

    @SuppressWarnings("resource")

    public Server() throws NumberFormatException, IOException {
        ServerSocket server_socket = null;
        Socket socket = null;
        try {
            server_socket = new ServerSocket(7799);
            System.out.println("Server Initiated");
            System.out.println(" ");
            System.out.println("Waiting For Client Connection ...");
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                socket = server_socket.accept();
            }

            catch (IOException e) {
                System.out.println("I/O Error: " + e);
            }
            new server_testclass(socket, global_array).start();
        }
    }
}