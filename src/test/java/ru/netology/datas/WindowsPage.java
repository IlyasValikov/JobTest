package ru.netology.datas;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class WindowsPage {
    public void OpenTab() {
        $(byText("New Tab")).click();
    }
    public void closeNewTab() {
        Selenide.switchTo().window(1); // Переключиться на новую вкладку
        Selenide.closeWindow(); // Закрыть новую вкладку
        Selenide.switchTo().window(0); // Вернуться на предыдущую вкладку
    }

    public void clickNewWindowButton() {
        $("#windowButtonWrapper").click();
    }

    public void closeNewWindow() {
        Selenide.switchTo().window(1); // Переключиться на новое окно
        Selenide.closeWindow(); // Закрыть новое окно
        Selenide.switchTo().window(0); // Вернуться на предыдущее окно
    }
}
