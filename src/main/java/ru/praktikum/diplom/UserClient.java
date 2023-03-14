package ru.praktikum.diplom;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_ACCEPTED;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static ru.praktikum.diplom.URLS.BASE_URI;

public class UserClient {

    public ValidatableResponse createUser(User user) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(user)
                .log().all()
                .post(URLS.ROOT + "register")
                .then()
                .log().all();
    }

    @Step("Login user")
    public ValidatableResponse loginUser(User user) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .body(user)
                .when()
                .post(URLS.ROOT + "login")
                .then().log().all();
    }

    @Step("Delete user")
    public ValidatableResponse deleteUser(String accessToken){
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .header("Authorization", accessToken)
                .when()
                .delete(URLS.ROOT + "user")
                .then().log().all();
    }

    @Step("Get token")
    public String getToken(ValidatableResponse response){
        return response.assertThat()
                .body("success", equalTo(true))
                .statusCode(HTTP_OK)
                .extract()
                .body()
                .path("accessToken");
    }

    @Step("User successfully deleted response")
    public void userDeleted(ValidatableResponse response){
        response.assertThat()
                .body("message", equalTo("User successfully removed"))
                .statusCode(HTTP_ACCEPTED);
    }
}