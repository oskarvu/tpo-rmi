package io.szelejewski.tpo.rmi.server;

import io.szelejewski.tpo.rmi.inter.EchoAddable;
import io.szelejewski.tpo.rmi.inter.EchoAdd;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends EchoAdd {
  public Server() {
  }
  public static void main(String[] args) {
    try {
      EchoAdd obj = new EchoAdd();
      EchoAddable stub = (EchoAddable) UnicastRemoteObject.exportObject(obj, 0);
      Registry registry = LocateRegistry.getRegistry();
      registry.rebind("EchoAddable", stub);
      System.out.println("Server is running...");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
