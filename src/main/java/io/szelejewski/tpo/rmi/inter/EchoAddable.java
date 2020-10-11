package io.szelejewski.tpo.rmi.inter;

import io.szelejewski.tpo.rmi.client.AddRequest;
import io.szelejewski.tpo.rmi.client.EchoRequest;
import io.szelejewski.tpo.rmi.server.AddResponse;
import io.szelejewski.tpo.rmi.server.EchoResponse;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EchoAddable extends Remote {
  EchoResponse echoMsg(EchoRequest echoRequest) throws RemoteException;
  AddResponse add(AddRequest addRequest) throws RemoteException;
}
