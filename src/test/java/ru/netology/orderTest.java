package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class orderTest {

    @Test
    public void correctInputTestSelenide(){
        open("http://localhost:9999");
        $("[type='tel']").setValue("+00000000000");
        $("[name='name']").setValue("Аа-бБ вВ");
        $("[data-test-id='agreement']").click();
        $("[type='button']").click();
        $(".paragraph").shouldHave(Condition.exactText("Ваши заявки успешно отправлены! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
