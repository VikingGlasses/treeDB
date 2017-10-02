package com.benjamin.tree.model;

import java.util.ArrayList;
import java.util.List;

public class Command {
  
  private String input;
  private CommandEnum com;
  private String tableName;
  private Attribute id;
  private List<Attribute> attributes;

  public Command(String input) {
    this.input = input;
    build();
  }

  private void build() {
    String[] splitInput = input.trim().split("\\s+");
    if (splitInput.length == 0) {
      setCommand(CommandEnum.EMPTY);
    } else if (splitInput.length == 1) {
      setCommand(CommandEnum.commandOf(splitInput[0]));
    } else {
      setCommand(CommandEnum.commandOf(splitInput[0]));
      setTableName(splitInput[1]);
      
      if (splitInput.length > 2) {
        setAttributes(new ArrayList<>());
        for (int i = 2; i < splitInput.length; i++) {
          String[] tmp = splitInput[i].split("\\=+");
          getAttributes().add(new Attribute(tmp[0], tmp[1]));
        }
        switch (getCommand()) {
          case DELETE:
          case READ:
          case UPDATE:
            id = attributes.remove(0);
            break;
          default:
            break;
          
        }
      }
    }
  }

  public CommandEnum getCommand() {
    return com;
  }

  public void setCommand(CommandEnum com) {
    this.com = com;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public Attribute getId() {
    return id;
  }

  public void setId(Attribute id) {
    this.id = id;
  }

  public List<Attribute> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<Attribute> attributes) {
    this.attributes = attributes;
  }
  

}
