package ru.test_shop.model.entity;

import java.io.Serializable;

public class RClothesType implements Serializable {
  private static final long serialVersionUID = 1719442616959287443L;

  public RClothesType() {}


  public RClothesType(int id, String name) {
    this.id = id;
    this.name = name;
  }

  private int id;
  private String name;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
