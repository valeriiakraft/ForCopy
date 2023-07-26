package tests;

import data.DataHelper;
import data.SQLHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.VerifyPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginTests {
    //Валидный вход
    //вход с 3мя неправильными паролями
    // неверный логин - верный пароль
    //неверный пароль - верный логин
    //Невалидный вход
    // неверный код верификации
    static LoginPage loginPage;
    static VerifyPage verifyPage;
    static DashboardPage dashboardPage;


    @BeforeEach
    void setup() {
        loginPage = open("http://localhost:9999/", LoginPage.class);
    }

    @Test
    public void positiveLogin(){
        var validUser = DataHelper.getValidAuthInfoWithTestData();
        DataHelper.VerifyCode validCode = SQLHelper.getVerifyCode();
        verifyPage=loginPage.validLogin(validUser);
        dashboardPage=verifyPage.validVerify(validCode);
    }
    @Test
    public void blockingAfterThreeIncorrectPasswordEntries(){

    }
    @Test
    public void loginWithIncorrectUsernameCorrectPassword(){

    }
    @Test
    public void loginWithCorrectUsernameIncorrectPassword(){

    }
    @Test
    public void loginWithInvalidUser(){

    }
    @Test
    public void loginWithInvalidCode(){

    }



}
