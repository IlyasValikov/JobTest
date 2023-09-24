package ru.netology.datas;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ButtonsPage {
    public void clickFirstButton() {
        $(byText("Click Me")).click();
    }
    public void clickSecondButton() {
        $(byText("Right Click Me")).click();
    }
    public void clickThirdButton() {
        $(byText("Double Click Me")).click();
    }
}
