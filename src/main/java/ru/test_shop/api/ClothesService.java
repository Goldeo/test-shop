package ru.test_shop.api;

import java.util.List;
import ru.test_shop.model.entity.Clothes;
import ru.test_shop.model.entity.ClothesStore;
import ru.test_shop.model.entity.RClothesColor;
import ru.test_shop.model.entity.RClothesSize;
import ru.test_shop.model.entity.RClothesType;

public interface ClothesService {
  public Clothes getClothesById(int id);

  public List<ClothesStore> getAllClothesStores();

  public ClothesStore getClothesStoreById(int id);

  public int getClothesCount();

  public List<Clothes> getClothesByStoreId(int storeId);

  public void addClothes(double value, String shortDescription, ClothesStore store,
      RClothesSize size, RClothesType type, RClothesColor color);

  public void removeClothes(int id);

  public void saveClothes(List<Clothes> clothes);

  public RClothesColor getClothesColorById(int id);

  public List<RClothesColor> getAllClothesColors();

  public RClothesSize getClothesSizeById(int id);

  public List<RClothesSize> getAllClothesSizes();

  public RClothesType getClothesTypeById(int id);

  public List<RClothesType> getAllClothesTypes();
}
