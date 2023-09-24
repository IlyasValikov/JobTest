package ru.netology.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StartPage {

    private SelenideElement elements = $(byText("Elements"));
    private SelenideElement alerts = $(byText("Alerts, Frame & Windows"));
    public void navigateToElementsPage() {
        elements.shouldBe(Condition.visible);
        elements.click();
    }

    public void navigateToBrowserWindows() {
        alerts.shouldBe(Condition.visible);
        alerts.click();
    }
}