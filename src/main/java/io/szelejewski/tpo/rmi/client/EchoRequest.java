package io.szelejewski.tpo.rmi.client;

import java.io.Serializable;

public class EchoRequest implements Serializable {
  private static final long serialVersionUID = 1;
  private String message;

  public EchoRequest(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return message;
  }
}
