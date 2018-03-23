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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)


public class LoginUiTest {

    private LoginActivity loginActivity = new LoginActivity();
    private SplashScreenActivity splashScreen = new SplashScreenActivity();
    private CountryListActivity countryActivity = new CountryListActivity();
    private Scripts script = new Scripts();

    @Before
    public void startMainActivity() throws InterruptedException {
        StartMainActivity mainActivity = new StartMainActivity();
        mainActivity.startMainActivity();

    }

    @Test
    public void checkSplashScreenTitle() throws UiObjectNotFoundException {
        for (int i = 0; i < 2; i++) {
            String currentTitle = splashScreen.title().getText();
            assertTrue("Отображается тайтл: " + currentTitle +
                            "\nКорректный тайтл: " + splashScreen.correctTitle(i),
                    currentTitle.equals(splashScreen.correctTitle(i)));
            splashScreen.activity().swipeLeft(5);
        }
    }

    @Test
    public void checkSplashScreenDescription() throws UiObjectNotFoundException {
        for (int i = 0; i < 2; i++) {
            String currentDescription = splashScreen.description().getText();
            assertTrue("Отображается дескрипшен: " + currentDescription +
                            "\nКорректный дескрипшен: " + splashScreen.correctDescription(i),
                    currentDescription.equals(splashScreen.correctDescription(i)));
            splashScreen.activity().swipeLeft(5);
        }
    }

    @Test
    public void checkOpenLoginActivity() throws UiObjectNotFoundException {
        script.openLoginActivity();
        assertTrue("Окно входа не отображается после нажатия на кнопку \"Начать\"",
                loginActivity.licenseAgreement().isEnabled());
    }

    @Test
    public void checkOpenCountryActivity() throws UiObjectNotFoundException {
        script.openCountryActivity();
        assertTrue("Окно списка стран не открывается",
                countryActivity.activity().isEnabled());
    }

    @Ignore
    public void checkDisplayListInCountryActivity() throws UiObjectNotFoundException {
        script.openCountryActivity();
        for (int i = 0; i <=1; i++) {
            String correctName =  countryActivity.correctNameCountry(i);
            assertTrue("В списке не отображается страна: "+correctName,
                    countryActivity.nameCountry(i).getText().equals(correctName));
            for (int j=0; j<12;j++){
                countryActivity.activity().swipeUp(5);
            }
        }
    }
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

