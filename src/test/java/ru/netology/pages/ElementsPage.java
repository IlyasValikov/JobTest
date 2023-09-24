package ru.netology.pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ElementsPage {
    public void navigateToTextBoxPage() {
        $(byText("Text Box")).click();
    }

    public void navigateToButtonsPage() {
        $(byText("Buttons")).click();
    }

}
