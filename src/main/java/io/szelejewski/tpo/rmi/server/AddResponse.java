package io.szelejewski.tpo.rmi.server;

import java.io.Serializable;

public class AddResponse implements Serializable {
  private static final long serialVersionUID = 1;
  private int sum;

  public AddResponse(int sum) {
    this.sum = sum;
  }

  public int getSum() {
    return sum;
  }

  @Override
  public String toString() {
    return Integer.toString(sum);
  }
}