package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PingWorker {
    static void pingWorker(String[] args) throws IOException, InterruptedException {
        String ip = args[0];
        System.out.println("PID de PingWorker: " + ProcessHandle.current().pid());

        ProcessBuilder processBuilder = new ProcessBuilder("ping", ip);
        try {
            Process process = processBuilder.start();
            System.out.println("PID del proceso ping: " + ProcessHandle.current().pid());

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) System.out.println(linea);

            int exit = process.waitFor();
            System.out.println("El proceso ha sido exitoso con la salida de : " + exit);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
