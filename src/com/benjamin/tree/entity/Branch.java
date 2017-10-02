package com.benjamin.tree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="branch")
public class Branch {
  
  @Id
  @Column(name="branch_id")
  private int id;
  
  @Column(name="length")
  private int length;
  
  @Column(name="age")
  private int age;
  
//  @ManyToOne
  @Column(name="branch_type")
  private int type;
  
//  @ManyToOne(fetch=FetchType.LAZY)
  @Column(name="parent")
  private int parent;
  
  public Branch() {}

  public Branch(int length, int age, int type, int parent) {
    super();
    this.length = length;
    this.age = age;
    this.type = type;
    this.parent = parent;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public int getParent() {
    return parent;
  }

  public void setParent(int parent) {
    this.parent = parent;
  }

  @Override
  public String toString() {
    return String.format("Branch [id=%s, length=%s, age=%s, type=%s, parent=%s]", id, length, age,
        type, parent);
  }

}
