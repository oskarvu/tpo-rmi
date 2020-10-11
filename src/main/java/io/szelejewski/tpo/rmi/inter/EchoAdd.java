package io.szelejewski.tpo.rmi.inter;

import io.szelejewski.tpo.rmi.client.AddRequest;
import io.szelejewski.tpo.rmi.client.EchoRequest;
import io.szelejewski.tpo.rmi.server.AddResponse;
import io.szelejewski.tpo.rmi.server.EchoResponse;

import java.rmi.RemoteException;

public class EchoAdd implements EchoAddable {
  @Override
  public EchoResponse echoMsg(EchoRequest echoRequest) throws RemoteException {
    return new EchoResponse(echoRequest.getMessage());
  }

  @Override
  public AddResponse add(AddRequest addRequest) throws RemoteException {
    return new AddResponse(addRequest.getA() + addRequest.getB());
  }
}
