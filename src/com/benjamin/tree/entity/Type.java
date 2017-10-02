package com.benjamin.tree.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="type")
public class Type {

  @Id
  @Column(name="type_id")
  private int id;
  
  @Column(name="name")
  private String name;
  
  @Column(name="growth_rate")
  private int growthRate;
  
  @Column(name="leaf_density")
  private int leafDensity;
  
  public Type() {}
  
  public Type(String name, int growthRate, int leafDensity) {
    super();
    this.name = name;
    this.growthRate = growthRate;
    this.leafDensity = leafDensity;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getGrowthRate() {
    return growthRate;
  }

  public void setGrowthRate(int growthRate) {
    this.growthRate = growthRate;
  }

  public int getLeafDensity() {
    return leafDensity;
  }

  public void setLeafDensity(int leafDensity) {
    this.leafDensity = leafDensity;
  }

  @Override
  public String toString() {
    return String.format("Type [id=%s, name=%s, growthRate=%s, leafDensity=%s]", id, name,
        growthRate, leafDensity);
  }
  
}
