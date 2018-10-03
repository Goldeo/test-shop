package ru.test_shop.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import ru.test_shop.model.entity.Clothes;
import ru.test_shop.model.entity.ClothesStore;
import ru.test_shop.model.entity.RClothesColor;
import ru.test_shop.model.entity.RClothesSize;
import ru.test_shop.model.entity.RClothesType;

@Singleton
public class FakeRepository {

  @PostConstruct
  public void init() {
    initClothesColors();
    initClothesTypes();
    initClothesSizes();
    initClothesStores();
    initClothes();
  }

  private List<RClothesColor> colors = new ArrayList<RClothesColor>(5);
  private List<RClothesType> types = new ArrayList<RClothesType>(5);
  private List<RClothesSize> sizes = new ArrayList<RClothesSize>(6);

  private List<ClothesStore> stores = new ArrayList<ClothesStore>(2);
  private List<Clothes> clothesList = new ArrayList<Clothes>(2);

  private void initClothesColors() {
    colors = new LinkedList<RClothesColor>(Arrays.asList(new RClothesColor(1, "Белый"),
        new RClothesColor(2, "Синий"), new RClothesColor(3, "Красный"),
        new RClothesColor(4, "Зеленый"), new RClothesColor(5, "Черный")));
  }

  private void initClothesTypes() {
    types = new LinkedList<RClothesType>(Arrays.asList(new RClothesType(1, "Платье"),
        new RClothesType(2, "Брюки"), new RClothesType(3, "Юбка"), new RClothesType(4, "Жилет"),
        new RClothesType(5, "Рубашка")));
  }

  private void initClothesSizes() {
    sizes = new LinkedList<RClothesSize>(Arrays.asList(new RClothesSize(1, "42"),
        new RClothesSize(2, "44"), new RClothesSize(3, "46"), new RClothesSize(4, "48"),
        new RClothesSize(5, "50"), new RClothesSize(6, "52")));
  }

  private void initClothesStores() {
    stores = new LinkedList<ClothesStore>(
        Arrays.asList(new ClothesStore(1, "Склад"), new ClothesStore(2, "Магазин")));
  }

  private void initClothes() {
    clothesList = new LinkedList<Clothes>(Arrays.asList(
        new Clothes(1, 4499.01, "Джинсы черные с дырками", stores.get(1), sizes.get(0),
            types.get(1), colors.get(4)),
        new Clothes(2, 3000.00, "Юбка красная", stores.get(1), sizes.get(1), types.get(2),
            colors.get(2)),
        new Clothes(3, 9150.00, "Платье зеленое в белый горошек", stores.get(0), sizes.get(2),
            types.get(0), colors.get(3)),
        new Clothes(4, 899.00, "Рубашка белая в красную полосочку", stores.get(0), sizes.get(3),
            types.get(4), colors.get(0)),
        new Clothes(5, 3199.00, "Жилет синий на рыбьем меху", stores.get(0), sizes.get(4),
            types.get(3), colors.get(1))));
  }

  public List<RClothesColor> getColors() {
    return colors;
  }

  public List<ClothesStore> getStores() {
    return stores;
  }

  public List<Clothes> getClothesList() {
    return clothesList;
  }

  public List<RClothesType> getTypes() {
    return types;
  }

  public List<RClothesSize> getSizes() {
    return sizes;
  }
}
