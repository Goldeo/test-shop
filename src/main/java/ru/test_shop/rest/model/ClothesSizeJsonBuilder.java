package ru.test_shop.rest.model;

import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import ru.test_shop.model.entity.RClothesSize;

public class ClothesSizeJsonBuilder {

  public static JsonObject getSizesJson(List<RClothesSize> sizes) {
    return Json.createObjectBuilder().add("sizes", getSizesJsonArrayBuilder(sizes)).build();
  }

  public static JsonArrayBuilder getSizesJsonArrayBuilder(List<RClothesSize> sizes) {
    JsonArrayBuilder builder = Json.createArrayBuilder();
    for (RClothesSize size : sizes) {
      builder.add(getSizeJsonObjectBuilder(size));
    }

    return builder;
  }

  public static JsonObject getSizeJsonObject(RClothesSize size) {
    return getSizeJsonObjectBuilder(size).build();
  }

  private static JsonObjectBuilder getSizeJsonObjectBuilder(RClothesSize size) {
    JsonObjectBuilder builder =
        Json.createObjectBuilder().add("id", size.getId()).add("name", size.getName());

    return builder;
  }
}
