package ru.netology.pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FramesPage {
    public void navigateToWindows() {
        $(byText("Browser Windows")).click();
    }
    public void navigateToAlerts() {
        $(byText("Alerts")).click();
    }
}
