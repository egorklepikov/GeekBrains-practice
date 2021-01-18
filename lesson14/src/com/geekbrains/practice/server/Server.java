package com.geekbrains.practice.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
  private ServerSocket serverSocket;
  private Socket clientSocket;

  public static void main(String[] args) {
    Server server = new Server();
    server.startServer(8189);
  }

  public void startServer(int portNumber) {
    try {
      serverSocket = new ServerSocket(portNumber);
      System.out.println("Waiting for client connection.");
      clientSocket = serverSocket.accept();
      System.out.println("Client was connected to server.");
      Reader reader = new Reader(clientSocket);
      reader.start();
      Sender sender = new Sender(clientSocket);
      sender.start();
      System.out.println("Connection established.");
      reader.join();
      sender.join();
      System.out.println("Server shutdown.");
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  private class Reader extends Thread {
    private Scanner scanner;

    public Reader(Socket socket) {
      try {
        scanner = new Scanner(socket.getInputStream());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void run() {
      while (!clientSocket.isClosed()) {
        String clientMessage = scanner.nextLine();
        if (clientMessage.equals("/disconnect")) {
          try {
            scanner.close();
            clientSocket.close();
            System.out.println("Client was disconnected...");
          } catch (IOException e) {
            e.printStackTrace();
          }
          break;
        }
        System.out.println("\nMessage from client: " + clientMessage);
      }
    }
  }

  private class Sender extends Thread {
    private PrintWriter printWriter;
    private Scanner scanner;

    public Sender(Socket socket) {
      try {
        printWriter = new PrintWriter(socket.getOutputStream(), true);
        scanner = new Scanner(System.in);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void run() {
      while (!clientSocket.isClosed()) {
        System.out.print("Enter message for client: ");
        printWriter.println(scanner.nextLine());
      }
      try {
        printWriter.close();
        clientSocket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
