package ru.test_shop.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import ru.test_shop.model.entity.Clothes;

public class ClothesStore implements Serializable {
  private static final long serialVersionUID = 4578739690497706090L;

  public ClothesStore() {}

  public ClothesStore(int id, String name) {
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
