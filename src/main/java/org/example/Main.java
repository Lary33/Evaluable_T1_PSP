package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static org.example.PingWorker.pingWorker;

public class Main {
    static void main() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe el comando de Linux a ejecutar");
        String comando = sc.nextLine();

        System.out.println("Escribe el primer argumento para el comando que has escrito anteriormente");
        String arg1 = sc.nextLine();

        pingWorker(comando, arg1);
    }
}
