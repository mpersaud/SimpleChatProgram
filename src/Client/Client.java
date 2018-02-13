package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
        public static void main(String[] args) {

            try {
                Socket connection = new Socket("localhost",5000);

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                PrintWriter out = new PrintWriter(connection.getOutputStream(), true);


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

