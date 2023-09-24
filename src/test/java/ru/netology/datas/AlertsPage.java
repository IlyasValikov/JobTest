package ru.netology.datas;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class AlertsPage {
    public void clickClickMeButtonForAlert() {
        $("#alertButton").click();
    }

    public void closeAlert() {
        switchTo().alert().accept();
    }

    public void clickClickMeButtonWithDelay() {
        $("#timerAlertButton").click();
    }

    public void clickConfirmButton() {
        $("#confirmButton").click();
    }

    public void acceptConfirmAlert() {
        switchTo().alert().accept();
    }

    public void verifyConfirmText(String expectedText) {
        $("#confirmResult").shouldHave(Condition.text(expectedText));
    }

    public void clickPromptButton() {
        $("#promptButton").click();
    }

    public void enterTextInPrompt(String text) {
        switchTo().alert().sendKeys(text);
        switchTo().alert().accept();
    }

    public void verifyPromptResult(String expectedText) {
        $("#promptResult").shouldHave(Condition.text(expectedText));
    }
}
