package com.example.test.uitestone.uitestOne.testClasses;


import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.example.test.uitestone.uitestOne.basicClasses.objectActivities.LoginActivity;
import com.example.test.uitestone.uitestOne.basicClasses.testConfig.StartMainActivity;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)


public class LoginUiTest{

    LoginActivity loginObject = new LoginActivity();

    @Before
    public void startMainActivity() throws InterruptedException {
        StartMainActivity mainActivity = new StartMainActivity();
        mainActivity.startMainActivity();

    }

    /* Проверка перехода между окнами при помощи свайпа в приветсвенном окне.
       Проверка соответсвия текста в плейсхолдерах
     */
    @Test
    public void textMatchInWelcomePlaceHolder() throws UiObjectNotFoundException {
        String title[] = {"Делись местоположением", "Находи друзей", "Наслаждайся общением"};
        String description[] = {"Подключи геолокацию для использования функции “Рядом”.",
                "Функция “Рядом” позволит найти собеседников поблизости.",
                "Отправляй сообщение собеседнику поблизости."};
        for (int i = 0; i < 2; i++) {
            assertTrue("Отображается тайтл: "+loginObject.titlePlaceHolder().getText()+
                    "\nКорректный тайтл: "+title[i],
                    loginObject.titlePlaceHolder().getText().equals(title[i]));
            assertTrue("Отображается описание: "+ loginObject.descriptionPlaceHolder().getText()+
                    "\nКорректное описание: "+description[i],
                    descriptionPlaceHolder().getText().equals(description[i]));
            welcomePlaceHolderActivity().swipeLeft(5);
        }
    }

    /*Проверка перехода из приветсвенного окна в окно авторизации после нажатия
    на кнопку "Начать"*/
    @Test
    public void openLogInActivity() throws UiObjectNotFoundException {
        startButton().clickAndWaitForNewWindow();
        assertTrue("Окно входа не отображается после нажатия на кнопку \"Начать\"",
                logInActivity().isEnabled());
    }

    //Проверка открытия активити списка всех стран
    @Test
    public void openCountryWindow() throws UiObjectNotFoundException {
        startButton().clickAndWaitForNewWindow();
        countryButtonLoginActivity().clickAndWaitForNewWindow();
        assertTrue("Окно списка стран не открывается", countryListActivity().isEnabled());
    }

    //Проверка соответствия стран в начале, середине и в конце списка стран
    @Ignore
    public void countriesInTheList() throws UiObjectNotFoundException {
        startButton().clickAndWaitForNewWindow();
        countryButtonLoginActivity().clickAndWaitForNewWindow();
        assertTrue("Не отображается в начале списка страна \"Афганистан\" или не " +
                        "соответствует ее код",
                nameCountry(1).getText().contains("Afghanistan") &&
                        codeCountry(1).getText().contains("+93"));
        for (int i = 0; i < 10; i++) {
            countryListActivity().swipeUp(40);
        }
        assertTrue("Не отображается в начале списка страна \"Мексика\" или не " +
                        "соответствует ее код",
                nameCountry(3).getText().contains("Mexico") &&
                        codeCountry(3).getText().contains("+52"));
        for (int i = 0; i < 10; i++) {
            countryListActivity().swipeUp(40);
        }
    }

    /*Проверка на отображение соответвующей страны, при вводе в поле "код страны" разных значений*/
    @Test
    public void changeCountryWhenEnterCode() throws UiObjectNotFoundException {
        String code[]={"+996","+254","+1264"};
        String nameCountry[]={"Kyrgyzstan", "Kenya","Anguilla"};
        startButton().clickAndWaitForNewWindow();
        for (int i=0; i<3;i++){
            codeField().clearTextField();
            codeField().setText(code[i]);
            assertTrue("При вводе кода: "+code[i]+"\nОтображается страна: "+
                            countryButtonLoginActivity().getText()+"\nСоответсующая страна: "+
                    nameCountry[i], countryButtonLoginActivity().getText().equals(nameCountry[i]));
        }
    }

    /* Проверка, соответсвует ли код страны, при выборе страны из общего списка стран
     (например: +996 соответсвует выбранной стране "Кыргызстан")*/
    @Test
    public void changeCodeCountryWhenSelectCountry()throws UiObjectNotFoundException{
        String listCountry[]={"Afghanistan","Zimbabwe"};
        String codeSelectedCountry[]={"+93","+263"};
        int countryId[]={1,10};
        startButton().clickAndWaitForNewWindow();
        for (int i=0; i<2; i++){
            countryButtonLoginActivity().clickAndWaitForNewWindow();
            if (i==1) {
                for (int j=0; j<20;j++){
                    countryListActivity().swipeUp(40);
                }
            }
            nameCountry(countryId[i]).clickAndWaitForNewWindow();
            assertTrue("В поле кода отображается значение: "+codeField().getText()+
                            " \nКорректное значение: "+codeSelectedCountry[i]+
                            ", для выбранной страны " +listCountry[i],
                    codeField().getText().equals(codeSelectedCountry[i]));
        }

    }
}
