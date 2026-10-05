package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PingWorker {
    public static void main(String[] args) throws InterruptedException {
        String ip = args[0];

        System.out.println("PID de PingWorker: " + ProcessHandle.current().pid());

        ProcessBuilder processBuilder = new ProcessBuilder("ping", ip, "-c 5");
        try {
            Process process = processBuilder.start();
            System.out.println("PID del proceso ping: " + process.pid());

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea;

            while ((linea = reader.readLine()) != null) System.out.println(linea);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
