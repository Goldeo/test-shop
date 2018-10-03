package ru.test_shop.rest.model;

import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import ru.test_shop.model.entity.RClothesColor;

public class ClothesColorJsonBuilder {

  public static JsonObject getColorsJson(List<RClothesColor> colors) {
    return Json.createObjectBuilder().add("colors", getColorsJsonArrayBuilder(colors)).build();
  }

  public static JsonArrayBuilder getColorsJsonArrayBuilder(List<RClothesColor> colors) {
    JsonArrayBuilder builder = Json.createArrayBuilder();
    for (RClothesColor color : colors) {
      builder.add(getColorJsonObjectBuilder(color));
    }

    return builder;
  }

  public static JsonObject getColorJsonObject(RClothesColor color) {
    return getColorJsonObjectBuilder(color).build();
  }

  private static JsonObjectBuilder getColorJsonObjectBuilder(RClothesColor color) {
    JsonObjectBuilder builder =
        Json.createObjectBuilder().add("id", color.getId()).add("name", color.getName());

    return builder;
  }
}
