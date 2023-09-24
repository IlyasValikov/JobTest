package ru.netology.test;

import io.qameta.allure.Story;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.datas.AlertsPage;
import ru.netology.datas.ButtonsPage;
import ru.netology.datas.TextBoxPage;
import ru.netology.datas.WindowsPage;
import ru.netology.pages.ElementsPage;
import ru.netology.pages.FramesPage;
import ru.netology.pages.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;

// Добавьте импорт AlertsPage в ваш тестовый класс
public class FormTest {
    private StartPage startPage = new StartPage();
    private ElementsPage elementsPage = new ElementsPage();
    private FramesPage framesPage = new FramesPage();
    private TextBoxPage textBoxPage = new TextBoxPage();
    private ButtonsPage buttonsPage = new ButtonsPage();
    private AlertsPage alertsPage = new AlertsPage();
    private WindowsPage windowsPage = new WindowsPage();

    @BeforeEach
    public void setUp() {
        open("https://demoqa.com/");
    }

    @Test
    @DisplayName("Fill and submit the text box form")
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
}
