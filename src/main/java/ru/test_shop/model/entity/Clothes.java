package ru.test_shop.model.entity;

import java.io.Serializable;

public class Clothes implements Serializable {
  private static final long serialVersionUID = 8263090861169983156L;

  public Clothes() {

  }

  public Clothes(int id, double value, String shortDescription, ClothesStore store,
      RClothesSize size, RClothesType type, RClothesColor color) {
    this.id = id;
    this.value = value;
    this.shortDescription = shortDescription;
    this.store = store;
    this.size = size;
    this.type = type;
    this.color = color;
  }

  private int id;
  private double value;
  private String shortDescription;

  private ClothesStore store;

  private RClothesSize size;
  private RClothesType type;
  private RClothesColor color;

  private boolean deleteMark;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Clothes other = (Clothes) obj;
    if (id != other.id)
      return false;
    return true;
  }

  public RClothesSize getSize() {
    return size;
  }

  public void setSize(RClothesSize size) {
    this.size = size;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public RClothesType getType() {
    return type;
  }

  public void setType(RClothesType type) {
    this.type = type;
  }

  public RClothesColor getColor() {
    return color;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setColor(RClothesColor color) {
    this.color = color;
  }

  public int getId() {
    return id;
  }

  public ClothesStore getStore() {
    return store;
  }

  public void setStore(ClothesStore store) {
    this.store = store;
  }

  public boolean isDeleteMark() {
    return deleteMark;
  }

  public void setDeleteMark(boolean deleteMark) {
    this.deleteMark = deleteMark;
  }
}
