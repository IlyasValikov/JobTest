package ru.netology.datas;

import static com.codeborne.selenide.Selenide.$;

public class ButtonsPage {
    public void clickFirstButton() {
        $("#8NN0R").click();
    }
    public void clickSecondButton() {
        $("#rightClickBtn").click();
    }
    public void clickThirdButton() {
        $("#doubleClickBtn").click();
    }
}
