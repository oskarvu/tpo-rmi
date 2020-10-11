package io.szelejewski.tpo.rmi.client;

import io.szelejewski.tpo.rmi.inter.*;
import io.szelejewski.tpo.rmi.server.AddResponse;
import io.szelejewski.tpo.rmi.server.EchoResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
  private Client() {
  }
  public static void main(String[] args) {
    String[] inputFromUser = parseInput(getInputFromUser());
    if (inputFromUser[0].equals("ERROR")) {
      System.out.println("Incorrect input");
      return;
    }
    try {
      Registry registry = LocateRegistry.getRegistry();
      EchoAddable stub = (EchoAddable) registry.lookup("EchoAddable");
      if (inputFromUser[0].equals("ECHO")) {
        EchoRequest echoRequest = new EchoRequest(inputFromUser[1]);
        EchoResponse echoResponse = stub.echoMsg(echoRequest);
        System.out.println(echoResponse);
      } else {
        AddRequest addRequest = new AddRequest(Integer.parseInt(inputFromUser[1]), Integer.parseInt(inputFromUser[2]));
        AddResponse addResponse = stub.add(addRequest);
        System.out.println(addResponse);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static String getInputFromUser() {
    String input = "";
    try(BufferedReader consoleBufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.println("ADD message format: \"ADD a b\", where a and b are integers;");
      System.out.println("ECHO message format: \"ECHO text\", where text is any text.");
      System.out.println();
      System.out.println("Input request message:");
      input = consoleBufferedReader.readLine();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return input;
  }

  private static String[] parseInput(String input) {
    Pattern bodyPattern = Pattern.compile("(?i)(ECHO|ADD)(?-i)\\s([\\S\\s]+)");
    Matcher bodyMatcher = bodyPattern.matcher(input);
    if (!bodyMatcher.find()) {
      return new String[]{"ERROR"};
    }
    if (bodyMatcher.group(1).toUpperCase().equals("ECHO")) {
      return new String[]{bodyMatcher.group(1).toUpperCase(), bodyMatcher.group(2)};
    }
    Pattern argumentsPattern = Pattern.compile("[^\\d-]*([\\d-]+)[^\\d-]+([\\d-]+)[^\\d-]*");
    Matcher argumentsMatcher = argumentsPattern.matcher(bodyMatcher.group(2));
    if (!argumentsMatcher.find()) {
      return new String[]{"ERROR"};
    }
    String firstArgument = argumentsMatcher.group(1);
    String secondArgument = argumentsMatcher.group(2);
    return new String[]{bodyMatcher.group(1).toUpperCase(), firstArgument, secondArgument};
  }
}
