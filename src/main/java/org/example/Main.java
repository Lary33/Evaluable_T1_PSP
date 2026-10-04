package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class Main {
    static void main(String[] args) throws IOException, InterruptedException {
        String ip = args[0];
        System.out.println("PID del coordinador: " + ProcessHandle.current().pid());

        Optional<String> java = ProcessHandle.current().info().command();
        String classPath = System.getProperty("java.class.path");
        String pingWorker = PingWorker.class.getName();

        ProcessBuilder processBuilder = new ProcessBuilder(java.orElse(null), "-cp", classPath, pingWorker, ip);
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
