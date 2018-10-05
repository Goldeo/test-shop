package ru.test_shop.rest;

import java.util.List;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import ru.test_shop.api.ClothesService;
import ru.test_shop.exceptions.ArgumentException;
import ru.test_shop.model.entity.Clothes;
import ru.test_shop.model.entity.ClothesStore;
import ru.test_shop.model.entity.RClothesColor;
import ru.test_shop.model.entity.RClothesSize;
import ru.test_shop.model.entity.RClothesType;
import ru.test_shop.rest.model.ClothesStoreJsonBuilder;
import ru.test_shop.rest.model.ClothesColorJsonBuilder;
import ru.test_shop.rest.model.ClothesJsonBuilder;
import ru.test_shop.rest.model.ClothesSizeJsonBuilder;
import ru.test_shop.rest.model.ClothesTypeJsonBuilder;

@Path("/main")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClothesResource {

  @Inject
  private ClothesService clothesService;

  @GET
  @Path(value = "/stores")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getStores() {
    List<ClothesStore> stores = clothesService.getAllClothesStores();
    JsonObject storeJson = ClothesStoreJsonBuilder.getStoresJson(stores);

    return Response.ok(storeJson).build();
  }

  @GET
  @Path(value = "/stores/{storeId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getClothesForStore(@PathParam(value = "storeId") Integer storeId) {
    if (storeId == null) {
      throw new ArgumentException("Неверный id магазина");
    }

    ClothesStore store = clothesService.getClothesStoreById(storeId);
    JsonObject storeJson = ClothesStoreJsonBuilder.getStoreJsonObject(store);

    return Response.ok(storeJson).build();
  }

  @GET
  @Path(value = "/types")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getClothesTypes() {
    List<RClothesType> types = clothesService.getAllClothesTypes();
    JsonObject typesJson = ClothesTypeJsonBuilder.getTypesJson(types);

    return Response.ok(typesJson).build();
  }

  @GET
  @Path(value = "/types/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getClothesType(@PathParam(value = "id") Integer id) {
    RClothesType type = clothesService.getClothesTypeById(id);
    JsonObject typesJson = ClothesTypeJsonBuilder.getTypeJsonObject(type);

    return Response.ok(typesJson).build();
  }

  @GET
  @Path(value = "/colors")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getClothesColors() {
    List<RClothesColor> colors = clothesService.getAllClothesColors();
    JsonObject colorsJson = ClothesColorJsonBuilder.getColorsJson(colors);

    return Response.ok(colorsJson).build();
  }

  @GET
  @Path(value = "/colors/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getClothesColor(@PathParam(value = "id") Integer id) {
    RClothesColor color = clothesService.getClothesColorById(id);
    JsonObject colorJson = ClothesColorJsonBuilder.getColorJsonObject(color);

    return Response.ok(colorJson).build();
  }

  @GET
  @Path(value = "/sizes")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getClothesSizes() {
    List<RClothesSize> sizes = clothesService.getAllClothesSizes();
    JsonObject sizesJson = ClothesSizeJsonBuilder.getSizesJson(sizes);

    return Response.ok(sizesJson).build();
  }

  @GET
  @Path(value = "/sizes/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getClothesSize(@PathParam(value = "id") Integer id) {
    RClothesSize size = clothesService.getClothesSizeById(id);
    JsonObject sizeJson = ClothesSizeJsonBuilder.getSizeJsonObject(size);

    return Response.ok(sizeJson).build();
  }

  @GET
  @Path(value = "/clothes/{storeId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response getClothesByStoreId(@PathParam(value = "storeId") Integer storeId) {
    List<Clothes> clothes = clothesService.getClothesByStoreId(storeId);
    JsonObject clothesJson = ClothesJsonBuilder.getClothesListJson(clothes);

    return Response.ok(clothesJson).build();
  }

  @POST
  @Path(value = "/clothes/save")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response saveClothes(List<Clothes> clothes) {
    clothesService.saveClothes(clothes);
    return Response.ok().build();
  }

  @DELETE
  @Path(value = "/clothes/remove/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response removeClothes(@PathParam(value = "id") Integer id) {
    if (id == null) {
      return Response.status(Status.BAD_REQUEST).build();
    }

    clothesService.removeClothes(id);
    return Response.ok().build();
  }
}
