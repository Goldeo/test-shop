package ru.test_shop.model.entity;

import java.io.Serializable;

public class RClothesColor implements Serializable {
  private static final long serialVersionUID = -421601722106339435L;

  public RClothesColor() {}

  public RClothesColor(int id, String name) {
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

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }
}
