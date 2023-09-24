package ru.netology.datas;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TextBoxPage {
    public void fillForm(String fullName, String email, String currentAddress, String permanentAddress) {
        $("#userName").setValue(fullName);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
    }

    public void submitForm() {
        $("#submit").click();
    }

    public void verifyData(String fullName, String email, String currentAddress, String permanentAddress) {
        $x("//td[text()='Name']").sibling(0).shouldHave(Condition.text(fullName));
        $x("//td[text()='Email']").sibling(0).shouldHave(Condition.text(email));
        $x("//td[text()='Current Address']").sibling(0).shouldHave(Condition.text(currentAddress));
        $x("//td[text()='Permanent Address']").sibling(0).shouldHave(Condition.text(permanentAddress));
    }
}
