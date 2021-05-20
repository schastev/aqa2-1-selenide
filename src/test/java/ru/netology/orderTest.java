package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class orderTest {

    @Test
    public void correctInputTest(){
        open("http://localhost:9999");
        $("[type='tel']").setValue("+00000000000");
        $("[name='name']").setValue("Аа-бБ вВ");
        $("[data-test-id='agreement']").click();
        $("[type='button']").click();
        $(".paragraph")
                .shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void emptyNameTest() {
        open("http://localhost:9999");
        $("[type='tel']").setValue("+00000000000");
        $("[data-test-id='agreement']").click();
        $("[type='button']").click();
        $(".input_invalid .input__sub")
                .shouldHave(Condition.text("Поле обязательно для заполнения"));
    }

    @Test
    public void incorrectNameTest() {
        open("http://localhost:9999");
        $("[name='name']").setValue("123");
        $("[type='tel']").setValue("+00000000000");
        $("[data-test-id='agreement']").click();
        $("[type='button']").click();
        $(".input_invalid .input__sub")
                .shouldHave(Condition.text("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }
    @Test
    public void emptyPhoneTest() {
        open("http://localhost:9999");
        $("[name='name']").setValue("Аа-бБ вВ");
        $("[data-test-id='agreement']").click();
        $("[type='button']").click();
        $(".input_invalid .input__sub")
                .shouldHave(Condition.text("Поле обязательно для заполнения"));
    }
    @Test
    public void incorrectPhoneTest() {
        open("http://localhost:9999");
        $("[type='tel']").setValue("123");
        $("[name='name']").setValue("Аа-бБ вВ");
        $("[data-test-id='agreement']").click();
        $("[type='button']").click();
        $(".input_invalid .input__sub")
                .shouldHave(Condition.text("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }
    @Test
    public void noAgreementTest() {
        open("http://localhost:9999");
        $("[type='tel']").setValue("+00000000000");
        $("[name='name']").setValue("Аа-бБ вВ");
        $("[type='button']").click();
        $(".input_invalid")
                .shouldHave(Condition.text("Я соглашаюсь с условиями обработки и использования моих персональных данных и разрешаю сделать запрос в бюро кредитных историй"));
    }
    @Test
    public void twoIncorrectFieldsFirstTest() {
        open("http://localhost:9999");
        $("[data-test-id='agreement']").click();
        $("[type='button']").click();
        $(".input_invalid .input__sub")
                .shouldHave(Condition.text("Поле обязательно для заполнения"));
    }

}
