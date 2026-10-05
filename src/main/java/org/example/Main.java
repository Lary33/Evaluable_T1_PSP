package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String ip = "10.112.11.8";
        System.out.println("PID del coordinador: " + ProcessHandle.current().pid());

        ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", "target/classes", "org.example.PingWorker", ip);
        try {
            Process process = processBuilder.start();

            System.out.println("Lanzando PingWorker");

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea;

            while ((linea = reader.readLine()) != null) System.out.println(linea);

            int exit = process.waitFor();
            System.out.println("PingWorker terminó con salida: " + exit);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
