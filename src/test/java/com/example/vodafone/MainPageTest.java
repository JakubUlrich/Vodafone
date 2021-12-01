package com.example.vodafone;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.screenshot;

public class MainPageTest {
    MainPage mainPage = new MainPage();
    private String urlName = "https://www.vodafone.cz";

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {}

    @Test
    public void Vodafone(){
        // Step 1
        open(urlName);
        // Step 2
        $(By.className("vfcc__button")).click(); // Přijmutí cookies
        $(byText("Telefony a zařízení")).click();
        // Step 3
        $(By.className("select2-container")).shouldHave(text("Nejsem"));
        // Step 4
        $(byText("Neomezený Premium 5G")).scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}").click();
        // Step 5
        $(byText("Ne, chci telefon bez tarifu")).click();
        // Step 6
        $(byText("Samsung Galaxy Z Flip3 5G 128 GB, černá")).click();
        // Step 7
        $(byText("Koupit telefon bez tarifu")).click();
        // Step 8
        String pngFileName = screenshot("my_file_name");
        // Step 9
        $(byText("Pokračovat v objednávce")).scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}").click();
        sleep(10000);
    }
}
