package ru.netology.test;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.datas.AlertsPage;
import ru.netology.datas.ButtonsPage;
import ru.netology.datas.TextBoxPage;
import ru.netology.datas.WindowsPage;
import ru.netology.pages.ElementsPage;
import ru.netology.pages.FramesPage;
import ru.netology.pages.StartPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.devtools.v116.page.Page.close;

@Epic("DemoQA Automation")
@Feature("Elements")
public class FormTest {
    StartPage startPage = new StartPage();
    ElementsPage elementsPage = new ElementsPage();
    FramesPage framesPage = new FramesPage();
    TextBoxPage textBoxPage = new TextBoxPage();
    ButtonsPage buttonsPage = new ButtonsPage();
    AlertsPage alertsPage = new AlertsPage();
    WindowsPage windowsPage = new WindowsPage();

    @BeforeEach
    public void setUp() {
        open("https://demoqa.com/");
    }


    @Test
    @Description("Complete the entire form and verify data")
    @Story("Text box operations")
    public void fillAndSubmitFormTest() {
        startPage.navigateToElementsPage();
        elementsPage.navigateToTextBoxPage();
        String fullName = "John Doe";
        String email = "johndoe@example.com";
        String currentAddress = "123 Main St";
        String permanentAddress = "456 Oak Ave";

        textBoxPage.fillForm(fullName, email, currentAddress, permanentAddress);
        textBoxPage.submitForm();

        // Проверяем, что данные в блоке сохранены корректно
        textBoxPage.verifyData(fullName, email, currentAddress, permanentAddress);
    }

    @Test
    @Description("First click button and verify text")
    @Story("Button operations")
    public void testClickFirstButton() {
        startPage.navigateToElementsPage();
        elementsPage.navigateToButtonsPage();
        buttonsPage.clickFirstButton();

        // Проверяем, что текст "You have done a dynamic click" появился после клика
        $("#dynamicClickMessage").shouldHave(text("You have done a dynamic click"));
    }

    @Test
    @Description("Second click button and verify text")
    @Story("Button operations")
    public void testClickSecondButton() {
        startPage.navigateToElementsPage();
        elementsPage.navigateToButtonsPage();
        buttonsPage.clickSecondButton();

        // Проверяем, что текст "You have done a right click" появился после клика
        $("#dynamicClickMessage").shouldHave(text("You have done a right click"));
    }

    @Test
    @Description("Third click button and verify text")
    @Story("Button operations")
    public void testClickThirdButton() {
        startPage.navigateToElementsPage();
        elementsPage.navigateToButtonsPage();
        buttonsPage.clickThirdButton();

        // Проверяем, что текст "You have done a double click" появился после клика
        $("#dynamicClickMessage").shouldHave(text("You have done a double click"));
    }


    @Test
    @Description("Handle alerts")
    @Story("Alert operations")
    public void handleAlerts() {
        startPage.navigateToBrowserWindows();
        framesPage.navigateToAlerts();
        alertsPage.clickClickMeButtonForAlert();
        alertsPage.closeAlert();
        alertsPage.clickClickMeButtonWithDelay();
        alertsPage.closeAlert();
        alertsPage.clickConfirmButton();
        alertsPage.acceptConfirmAlert();
        alertsPage.clickConfirmButton();
        alertsPage.acceptConfirmAlert();
        alertsPage.verifyConfirmText("You selected Ok");
        alertsPage.clickPromptButton();
        alertsPage.enterTextInPrompt("Test name");
        alertsPage.verifyPromptResult("You entered Test name");
    }

    @Test
    @Description("First open and close new tab and windows")
    @Story("Window operations")
    public void testOpenNewTabAndClose() {
        startPage.navigateToBrowserWindows();
        framesPage.navigateToWindows();
        // Нажать на "Browser Windows"
        windowsPage.OpenTab();

        // Переключиться на новую вкладку и проверить, что она открыта
        switchTo().window(1);
        assertEquals("This is a sample page", title());

        // Закрыть новую вкладку и вернуться на предыдущую
        close();
        switchTo().window(0);

        // Проверить, что вернулись на исходную вкладку
        assertEquals("Browser Windows", title());
    }

    @Test
    @Description("Second open and close new tab and windows")
    @Story("Window operations")
    public void testOpenNewWindowAndClose() {
        startPage.navigateToBrowserWindows();
        framesPage.navigateToWindows();
        // Нажать на "Browser Windows"
        windowsPage.OpenTab();

        // Нажать на кнопку "New Tab"
        windowsPage.OpenTab();

        // Закрыть новую вкладку и вернуться на предыдущую
        close();
        switchTo().window(0);

        // Нажать на кнопку "New window"
        windowsPage.clickNewWindowButton();

        // Переключиться на новое окно и проверить, что оно открыто
        switchTo().window(1);
        assertEquals("This is a sample page", title());

        // Закрыть новое окно и вернуться на предыдущее окно
        close();
        switchTo().window(0);

        // Проверить, что вернулись на исходное окно
        assertEquals("Browser Windows", title());
    }
}


