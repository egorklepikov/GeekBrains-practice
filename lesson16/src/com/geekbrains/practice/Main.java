package com.geekbrains.practice;

public class Main {
  private final Object monitor = new Object();
  private volatile int characterIndex;  //0 - A; 1 - B; 2 - C;

  public static void main(String[] args) {
    new Main().initialize();
  }

  public void initialize() {
    characterIndex = 0;
    new APrinter().start();
    new BPrinter().start();
    new CPrinter().start();
  }

  private class APrinter extends Thread {
    @Override
    public void run() {
      for (int i = 0; i < 5; i++) {
        synchronized (monitor) {
          while (characterIndex != 0) {
            try {
              monitor.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          characterIndex = 1;
          System.out.println("A");
          monitor.notifyAll();
        }
      }
    }
  }

  private class BPrinter extends Thread {
    @Override
    public void run() {
      for (int i = 0; i < 5; i++) {
        synchronized (monitor) {
          while (characterIndex != 1) {
            try {
              monitor.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          characterIndex = 2;
          System.out.println("B");
          monitor.notifyAll();
        }
      }
    }
  }

  private class CPrinter extends Thread {
    @Override
    public void run() {
      for (int i = 0; i < 5; i++) {
        synchronized (monitor) {
          while (characterIndex != 2) {
            try {
              monitor.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          characterIndex = 0;
          System.out.println("C");
          monitor.notifyAll();
        }
      }
    }
  }
}
