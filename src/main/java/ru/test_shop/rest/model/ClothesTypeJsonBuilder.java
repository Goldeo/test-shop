package ru.test_shop.rest.model;

import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import ru.test_shop.model.entity.RClothesType;

public class ClothesTypeJsonBuilder {
  public static JsonObject getTypesJson(List<RClothesType> types) {
    JsonArrayBuilder builder = Json.createArrayBuilder();
    for (RClothesType type : types) {
      builder.add(getTypeJsonObjectBuilder(type));
    }

    return Json.createObjectBuilder().add("types", builder).build();
  }

  public static JsonObject getTypeJsonObject(RClothesType type) {
    return getTypeJsonObjectBuilder(type).build();
  }

  private static JsonObjectBuilder getTypeJsonObjectBuilder(RClothesType type) {
    JsonObjectBuilder builder =
        Json.createObjectBuilder().add("id", type.getId()).add("name", type.getName());

    return builder;
  }
}
