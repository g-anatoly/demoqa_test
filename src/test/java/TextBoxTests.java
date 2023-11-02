package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
       // Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Garik");
        $("#lastName").setValue("Kharlamov");
        $("#userEmail").setValue("qaguru@mail.ru");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("9012345678");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1986");
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__day--007").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("123.jpg");
        $("#currentAddress").setValue("Lenin street 19");
        $("#state").scrollTo().click();
        $("#react-select-3-input").val("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").val("Gurgaon").pressEnter();
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Garik Kharlamov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("qaguru@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9012345678"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("07 September,1986"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Computer Science"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("123.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Lenin street 19"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Gurgaon"));
    }
}