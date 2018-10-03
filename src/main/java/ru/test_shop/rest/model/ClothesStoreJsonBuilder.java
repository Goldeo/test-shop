package ru.test_shop.rest.model;

import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import ru.test_shop.model.entity.ClothesStore;

public class ClothesStoreJsonBuilder {

  public static JsonObject getStoresJson(List<ClothesStore> stores) {
    JsonArrayBuilder builder = Json.createArrayBuilder();
    for (ClothesStore store : stores) {
      builder.add(getStoreJsonObjectBuilder(store));
    }

    return Json.createObjectBuilder().add("stores", builder).build();
  }

  public static JsonObject getStoreJsonObject(ClothesStore store) {
    return getStoreJsonObjectBuilder(store).build();
  }

  private static JsonObjectBuilder getStoreJsonObjectBuilder(ClothesStore store) {
    JsonObjectBuilder builder =
        Json.createObjectBuilder().add("id", store.getId()).add("name", store.getName());
    return builder;
  }
}
