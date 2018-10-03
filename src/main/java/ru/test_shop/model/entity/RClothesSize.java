package ru.test_shop.model.entity;

import java.io.Serializable;

public class RClothesSize implements Serializable {
  private static final long serialVersionUID = 3426271387274701913L;

  public RClothesSize() {}


  public RClothesSize(int id, String name) {
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
