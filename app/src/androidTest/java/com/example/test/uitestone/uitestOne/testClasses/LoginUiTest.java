package com.example.test.uitestone.uitestOne.testClasses;


import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.example.test.uitestone.uitestOne.basicClasses.LoginActivitySelectors;
import com.example.test.uitestone.uitestOne.basicClasses.StartMainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)



public class LoginUiTest extends LoginActivitySelectors {

    @Before
    public void startMainActivity() throws InterruptedException {
        StartMainActivity mainActivity = new StartMainActivity();
        mainActivity.startMainActivity();

    }

    /* Проверка свайпа в приветсвенном окне
       Проверка соответсвия текста в плейсхолдерах
     */
    @Test
    public void textMatchInWelcomePlaceHolder() throws UiObjectNotFoundException {
        String title[] = {"Делись местоположением", "Находи друзей", "Наслаждайся общением"};
        String description[] = {"Подключи геолокацию для использования функции “Рядом”.",
                "Функция “Рядом” позволит найти собеседников поблизости.",
                "Отправляй сообщение собеседнику поблизости."};
        for (int i = 0; i<2; i++) {
            assertTrue("Не сoответствует тайтл: " + title[i]+" или описание: "+
                            description[i],
                    titlePlaceHolder().getText().equals(title[i]) &&
                            descriptionPlaceHolder().getText().equals(description[i]));
            welcomePlaceHolderActivity().swipeLeft(5);
        }
    }

    /*Проверка перехода из приветсвенного окна в окно авторизации после нажатия
    на кнопку "Начать"*/
    @Test
    public void openLogInActivity() throws UiObjectNotFoundException{
        startButton().clickAndWaitForNewWindow();
        assertTrue("Окно входа не отображается после нажатия на кнопку \"Начать\"",
                logInActivity().isEnabled());
    }

    //Проверка открытия активити списка всех стран
    @Test
    public void openCountryWindow() throws UiObjectNotFoundException{
        startButton().clickAndWaitForNewWindow();
        countryButtonLoginActivity().clickAndWaitForNewWindow();
        assertTrue("Окно списка стран не открывается", countryListActivity().isEnabled());
    }

    //Проверка соответствия стран в начале, середине и в конце списка стран
    @Test
    public void countriesInTheList() throws UiObjectNotFoundException{
        startButton().clickAndWaitForNewWindow();
        countryButtonLoginActivity().clickAndWaitForNewWindow();
        assertTrue("Не отображается в начале списка страна \"Афганистан\" или не " +
                        "соответствует ее код",
                nameCountry(1).getText().contains("Afghanistan")&&
                        codeCountry(1).getText().contains("+93"));
        for (int i=0; i<10; i++){
            countryListActivity().swipeUp(40);
        }
        assertTrue("Не отображается в начале списка страна \"Мексика\" или не " +
                        "соответствует ее код",
                nameCountry(3).getText().contains("Mexico")&&
                        codeCountry(3).getText().contains("+52"));
        for (int i=0; i<10; i++){
            countryListActivity().swipeUp(40);
        }
    }

}
