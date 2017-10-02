package com.benjamin.tree.model;

public class Attribute {
  
  private String name;
  private String value;
  
  public Attribute() {
  }

  public Attribute(String attribute, String value) {
    super();
    this.name = attribute;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String attribute) {
    this.name = attribute;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.format("Attribute [attribute=%s, value=%s]", name, value);
  }

}
