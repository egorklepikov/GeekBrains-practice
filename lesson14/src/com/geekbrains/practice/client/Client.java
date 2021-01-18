package com.geekbrains.practice.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  private Socket socket;

  private void startClient(String ip, int port) {
    try {
      socket = new Socket(ip, port);
      System.out.println("Socket was created.");
      Reader reader = new Reader(socket);
      reader.start();
      Sender sender = new Sender(socket);
      sender.start();
      System.out.println("Connection established.");
      reader.join();
      sender.join();
      System.out.println("Client shutdown.");
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Client client = new Client();
    client.startClient("localhost", 8189);
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
      while (!socket.isClosed()) {
        System.out.println("Message from server: " + scanner.nextLine());
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
      while (!socket.isClosed()) {
        System.out.print("Enter message for server: ");
        String message = scanner.nextLine();
        printWriter.println(message);
        if (message.equals("/disconnect")) {
          try {
            printWriter.close();
            socket.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}
