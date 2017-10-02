package com.benjamin.tree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leaf")
public class Leaf {
  
  @Id
  @Column(name="leaf_id")
  private int id;
  
  @Column(name="color")
  private String color;
  
  @Column(name="base")
  private int base;
  
  public Leaf() {}

  public Leaf(String color, int base) {
    super();
    this.color = color;
    this.base = base;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getBase() {
    return base;
  }

  public void setBase(int base) {
    this.base = base;
  }

  @Override
  public String toString() {
    return String.format("Leaf [id=%s, color=%s, base=%s]", id, color, base);
  }

}
