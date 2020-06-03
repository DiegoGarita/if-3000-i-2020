
package edu.ucr.rp.laboratorio7.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    ServerSocket serverSocket;
    
    String [] answers = new String [] {"Si","No","Probablemente","Es lógico","Nunca"};

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Esperando conexión");
            while (true) {
                Socket socket = serverSocket.accept();//esperando a que llegue una conexión
                System.out.println("Conexión recibida");
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                String message = (String) in.readObject();
                System.out.println("Pregunta recibida: " + message);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                int i = new Random().nextInt(answers.length-1);
                System.out.println("Respuesta enviada:" + answers[i]);
                out.writeObject(answers[i]);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();//Puede lanzar una excepción puesto que el puerto puede estar ocupado
        }

    }
}