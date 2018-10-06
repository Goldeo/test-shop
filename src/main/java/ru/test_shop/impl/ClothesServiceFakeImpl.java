package ru.test_shop.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import ru.test_shop.api.ClothesService;
import ru.test_shop.model.entity.Clothes;
import ru.test_shop.model.entity.ClothesStore;
import ru.test_shop.model.entity.RClothesColor;
import ru.test_shop.model.entity.RClothesSize;
import ru.test_shop.model.entity.RClothesType;
import ru.test_shop.service.FakeRepository;

@Stateless
@Local(ClothesService.class)
public class ClothesServiceFakeImpl implements ClothesService {

  @Inject
  FakeRepository repo;

  @Override
  public List<ClothesStore> getAllClothesStores() {
    return repo.getStores();
  }

  @Override
  public Clothes getClothesById(int id) {
    return repo.getClothesList().stream().filter(c -> c.getId() == id).findAny().orElse(null);
  }

  @Override
  public ClothesStore getClothesStoreById(int id) {
    return repo.getStores().stream().filter(s -> s.getId() == id).findAny().orElse(null);
  }

  @Override
  public int getClothesCount() {
    return repo.getClothesList().size();
  }

  @Override
  public List<Clothes> getClothesByStoreId(int storeId) {
    return repo.getClothesList().stream().filter(c -> c.getStore().getId() == storeId)
        .collect(Collectors.toList());
  }

  @Override
  public void addClothes(double value, String shortDescription, ClothesStore store,
      RClothesSize size, RClothesType type, RClothesColor color) {
    // TODO
    int id = 6;
    Clothes newClothes = new Clothes(id, value, shortDescription, store, size, type, color);
    repo.getClothesList().add(newClothes);
  }

  @Override
  public void removeClothes(int id) {
    repo.getClothesList().removeIf(c -> c.getId() == id);
  }

  @Override
  public void saveClothes(Clothes clothes) {
    if (clothes.isDeleteMark() == true) {
      removeClothes(clothes.getId());
    }
    Clothes savedCl = repo.getClothesList().stream().filter(c -> c.getId() == clothes.getId())
        .findAny().orElse(null);
    if (savedCl != null) {
      savedCl.setColor(clothes.getColor());
      savedCl.setType(clothes.getType());
      savedCl.setSize(clothes.getSize());
      savedCl.setStore(clothes.getStore());
      savedCl.setValue(clothes.getValue());
      savedCl.setShortDescription(clothes.getShortDescription());
    }
  }

  @Override
  public void saveClothes(List<Clothes> clothes) {
    for (Clothes cl : clothes) {
      saveClothes(cl);

    }
  }

  @Override
  public RClothesColor getClothesColorById(int id) {
    return repo.getColors().stream().filter(c -> c.getId() == id).findAny().orElse(null);
  }

  @Override
  public List<RClothesColor> getAllClothesColors() {
    return repo.getColors();
  }

  @Override
  public RClothesSize getClothesSizeById(int id) {
    return repo.getSizes().stream().filter(s -> s.getId() == id).findAny().orElse(null);
  }

  @Override
  public List<RClothesSize> getAllClothesSizes() {
    return repo.getSizes();
  }

  @Override
  public RClothesType getClothesTypeById(int id) {
    return repo.getTypes().stream().filter(t -> t.getId() == id).findAny().orElse(null);
  }

  @Override
  public List<RClothesType> getAllClothesTypes() {
    return repo.getTypes();
  }
}
