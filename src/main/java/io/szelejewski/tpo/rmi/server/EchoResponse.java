package io.szelejewski.tpo.rmi.server;

import java.io.Serializable;

public class EchoResponse implements Serializable {
  private static final long serialVersionUID = 1;
  private String message;

  public EchoResponse(String message) {
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
