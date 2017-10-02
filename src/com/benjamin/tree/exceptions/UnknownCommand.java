package com.benjamin.tree.exceptions;

public class UnknownCommand extends Exception {

  private String msg;

  public UnknownCommand(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }

}
