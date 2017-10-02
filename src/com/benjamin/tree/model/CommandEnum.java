package com.benjamin.tree.model;

public enum CommandEnum {
  
  CREATE("-c"),
  READ("-r"),
  UPDATE("-u"),
  DELETE("-d"),
  SEARCH("-s"),
  CALL("-call"),
  QUIT("-q"),
  HELP("-h"),
  EMPTY("");
  
  private String symbol;

  private CommandEnum() {
  }
  
  private CommandEnum(String command) {
    this.setSymbol(command);
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public static CommandEnum commandOf(String string) {
    for (CommandEnum e : CommandEnum.values()) {
      if (string.equals(e.getSymbol())) {
        return e;
      }
    }
    throw new IllegalArgumentException(String.format("Command not '%s' not found", string));
  }

}
