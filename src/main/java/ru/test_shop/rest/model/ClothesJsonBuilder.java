package ru.test_shop.rest.model;

import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import ru.test_shop.model.entity.Clothes;

public class ClothesJsonBuilder {
  public static JsonObject getClothesListJson(List<Clothes> clothes) {
    return Json.createObjectBuilder().add("clothes", getClothesListJsonArrayBuilder(clothes))
        .build();
  }

  public static JsonArrayBuilder getClothesListJsonArrayBuilder(List<Clothes> clothes) {
    JsonArrayBuilder builder = Json.createArrayBuilder();
    for (Clothes cl : clothes) {
      builder.add(getClothesJsonObjectBuilder(cl));
    }

    return builder;
  }

  public static JsonObject getClothesJsonObject(Clothes clothes) {
    return getClothesJsonObjectBuilder(clothes).build();
  }

  private static JsonObjectBuilder getClothesJsonObjectBuilder(Clothes clothes) {
    JsonObjectBuilder builder = Json.createObjectBuilder().add("id", clothes.getId())
        .add("store", ClothesStoreJsonBuilder.getStoreJsonObject(clothes.getStore()))
        .add("value", clothes.getValue()).add("shortDescription", clothes.getShortDescription())
        .add("size", clothes.getSize() != null ?
            ClothesSizeJsonBuilder.getSizeJsonObject(clothes.getSize()) : JsonValue.NULL
)
        .add("type", clothes.getType() != null ?
            ClothesTypeJsonBuilder.getTypeJsonObject(clothes.getType()) : JsonValue.NULL
)
        .add("color", clothes.getColor() != null ?

                ClothesColorJsonBuilder.getColorJsonObject(clothes.getColor()) : JsonValue.NULL
);

    return builder;
  }
}
