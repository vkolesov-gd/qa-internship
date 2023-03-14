package tests;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import org.testng.Assert;
import tests.pojo.AuthRequest;
import tests.pojo.DeleteResponse;
import tests.pojo.GetPostResponse;

public class RequestsTest {
    final String baseUrl = "https://api.trello.com";
    final String basePath = "/1/boards/";
    AuthRequest authRequest = new AuthRequest("89c34cc732e65e61386e663446329b2c","ATTAdf89dc47879a8502af425a05be7b81e98c13ee1b71242edd437ae0d36c66f94604E912EE");
    String newBoardName = "Board is created using Java";
    String boardId;
    String boardShortUrl;

    @Test(groups = {"response testing"}, priority = 0)
    public void addBoard() {
        Specs.installSpec(Specs.requestSpec(baseUrl, basePath), Specs.responseSpec());
        Response postResponse = given()
                .when()
                    .queryParams("key", authRequest.getTrelloKey(), "token", authRequest.getTrelloToken(), "name", newBoardName)
                    .post()
                .then()
                    .extract().response();
        boardId = postResponse.path("id");
        boardShortUrl = postResponse.path("shortUrl");
    }

    @Test(groups = {"response testing"}, priority = 1)
    public void getBoardById() {
        Specs.installSpec(Specs.requestSpec(baseUrl, basePath), Specs.responseSpec());
        GetPostResponse getResponse = given()
                .when()
                    .queryParams("key", authRequest.getTrelloKey(), "token", authRequest.getTrelloToken())
                    .get(boardId)
                .then()
                    .log().all()
                    .body("shortUrl", Matchers.equalTo(boardShortUrl))
                    .extract().response().as(GetPostResponse.class);
        Assert.assertEquals(getResponse.getName(), newBoardName);
    }

    @Test(groups = {"response testing"}, priority = 2)
    void deleteBoardById() {
        Specs.installSpec(Specs.requestSpec(baseUrl, basePath), Specs.responseSpec());
        DeleteResponse deleteResponse = given()
                .when()
                    .queryParams("key", authRequest.getTrelloKey(), "token", authRequest.getTrelloToken())
                    .delete(boardId)
                .then()
                .assertThat()
                .log().all()
                .extract().response().as(DeleteResponse.class);
        Assert.assertNull(deleteResponse.get_value());
    }
}
