package com.example.test.uitestone.uitestOne.UiTestsClasses;


import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.example.test.uitestone.uitestOne.instrumentationClasses.commands.Scripts;
import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.CountryListActivity;
import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.LoginActivity;
import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.SplashScreenActivity;
import com.example.test.uitestone.uitestOne.instrumentationClasses.testConfig.StartMainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)


public class LoginUiTest{

    private LoginActivity loginActivityObject = new LoginActivity();
    private SplashScreenActivity splashScreenObject = new SplashScreenActivity();
    private CountryListActivity countryActivityObject = new CountryListActivity();
    private Scripts script = new Scripts();

    @Before
    public void startMainActivity() throws InterruptedException {
        StartMainActivity mainActivity = new StartMainActivity();
        mainActivity.startMainActivity();

    }

    @Test
    public void checkSplashScreenTitle() throws UiObjectNotFoundException {
        for (int i = 0; i < 2; i++) {
            String currentTitle = splashScreenObject.title().getText();
            assertTrue("Отображается тайтл: "+currentTitle+
                    "\nКорректный тайтл: "+splashScreenObject.correctTitle(i),
                    currentTitle.equals(splashScreenObject.correctTitle(i)));
            splashScreenObject.activity().swipeLeft(5);
            }
    }

    @Test
    public void checkSplashScreenDescription() throws UiObjectNotFoundException {
        for (int i = 0; i < 2; i++) {
            String currentDescription = splashScreenObject.description().getText();
            assertTrue("Отображается дескрипшен: "+currentDescription+
                    "\nКорректный дескрипшен: "+splashScreenObject.correctDescription(i),
                    currentDescription.equals(splashScreenObject.correctDescription(i)));
            splashScreenObject.activity().swipeLeft(5);
        }
    }

    @Test
    public void checkOpenLoginActivity() throws UiObjectNotFoundException {
        script.openLoginActivity();
        assertTrue("Окно входа не отображается после нажатия на кнопку \"Начать\"",
                loginActivityObject.licenseAgreement().isEnabled());
    }

    @Test
    public void checkOpenCountryWindow() throws UiObjectNotFoundException {
        script.openCountryActivity();
        assertTrue("Окно списка стран не открывается",
                countryActivityObject.countryList().isEnabled());
    }

//    //Проверка соответствия стран в начале, середине и в конце списка стран
//    @Ignore
//    public void countriesInTheList() throws UiObjectNotFoundException {
//        startButton().clickAndWaitForNewWindow();
//        countryButton().clickAndWaitForNewWindow();
//        assertTrue("Не отображается в начале списка страна \"Афганистан\" или не " +
//                        "соответствует ее код",
//                nameCountry(1).getText().contains("Afghanistan") &&
//                        codeCountry(1).getText().contains("+93"));
//        for (int i = 0; i < 10; i++) {
//            countryListActivity().swipeUp(40);
//        }
//        assertTrue("Не отображается в начале списка страна \"Мексика\" или не " +
//                        "соответствует ее код",
//                nameCountry(3).getText().contains("Mexico") &&
//                        codeCountry(3).getText().contains("+52"));
//        for (int i = 0; i < 10; i++) {
//            countryListActivity().swipeUp(40);
//        }
//    }
//
//    Проверка на отображение соответвующей страны, при вводе в поле "код страны" разных значений
////    @Test
////    public void changeCountryWhenEnterCode() throws UiObjectNotFoundException {
////        String code[]={"+996","+254","+1264"};
////        String nameCountry[]={"Kyrgyzstan", "Kenya","Anguilla"};
////        startButton().clickAndWaitForNewWindow();
////        for (int i=0; i<3;i++){
////            codeField().clearTextField();
////            codeField().setText(code[i]);
////            assertTrue("При вводе кода: "+code[i]+"\nОтображается страна: "+
////                            countryButton().getText()+"\nСоответсующая страна: "+
////                    nameCountry[i], countryButton().getText().equals(nameCountry[i]));
////        }
////    }
////
////     Проверка, соответсвует ли код страны, при выборе страны из общего списка стран
////     (например: +996 соответсвует выбранной стране "Кыргызстан")
////    @Test
////    public void changeCodeCountryWhenSelectCountry()throws UiObjectNotFoundException{
////        String listCountry[]={"Afghanistan","Zimbabwe"};
////        String codeSelectedCountry[]={"+93","+263"};
////        int countryId[]={1,10};
////        startButton().clickAndWaitForNewWindow();
////        for (int i=0; i<2; i++){
////            countryButton().clickAndWaitForNewWindow();
////            if (i==1) {
////                for (int j=0; j<20;j++){
////                    countryListActivity().swipeUp(40);
////                }
////            }
////            nameCountry(countryId[i]).clickAndWaitForNewWindow();
////            assertTrue("В поле кода отображается значение: "+codeField().getText()+
////                            " \nКорректное значение: "+codeSelectedCountry[i]+
////                            ", для выбранной страны " +listCountry[i],
////                    codeField().getText().equals(codeSelectedCountry[i]));
////        }
////
////    }
}
