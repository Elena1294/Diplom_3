package ru.praktikum.diplom;

import io.qameta.allure.Allure;
import org.apache.commons.lang3.RandomStringUtils;

public class User {
    private String email;
    private String password;

    public User(){}
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail() {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public static User getRandomUser() {
        String name = RandomStringUtils.randomAlphabetic(8);
        String email = name.toLowerCase() + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(8);

        Allure.addAttachment("Email : ", email);
        Allure.addAttachment("Password : ", password);

        return new User(email, password);
    }
}