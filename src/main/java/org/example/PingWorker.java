package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PingWorker {
    static void pingWorker(String comando, String arg1) throws IOException, InterruptedException {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(comando, arg1);
            Process process = processBuilder.start();

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
