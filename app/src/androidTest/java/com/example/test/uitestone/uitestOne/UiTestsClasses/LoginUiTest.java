package com.example.test.uitestone.uitestOne.UiTestsClasses;


import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.example.test.uitestone.uitestOne.instrumentationClasses.commands.Scripts;
import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.CountryListActivity;
import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.LoginActivity;
import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.SmsCodeActivity;
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
    private SmsCodeActivity smsActivity = new SmsCodeActivity();
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
    @Test
    public void checkChangeCountryEnterCodeField() throws UiObjectNotFoundException{
        script.openLoginActivity();
        for (int i=0;i<3;i++){
            String correctCode = loginActivity.testDataCountryCode(i);
            String correctCountry = loginActivity.testDataCountryName(i);
            loginActivity.codeField().clearTextField();
            loginActivity.codeField().setText(correctCode);
            String currentCountry = loginActivity.countryButton().getText();
            assertTrue("При вводе кода: "+correctCode+"\nОтображается страна: "+
                            currentCountry+"\nСоответсующая страна: "+
                    correctCountry, currentCountry.equals(correctCountry));
        }
    }
    @Test
    public void loginWithEmptyPhoneField() throws UiObjectNotFoundException{
        script.openLoginActivity();
        loginActivity.phoneField().clearTextField();
        loginActivity.startButton().clickAndWaitForNewWindow();
        assertTrue("пользователь сумел авторизоваться с пустым полем телефона",
                loginActivity.licenseAgreement().isEnabled());
    }
    @Test
    public void loginWithIncorrectPhoneField() throws UiObjectNotFoundException{
        script.openLoginActivity();
        loginActivity.phoneField().clearTextField();
        loginActivity.phoneField().setText("552875");
        loginActivity.startButton().clickAndWaitForNewWindow();
        assertTrue("Пользователь сумел авторизоваться с неполностью заполненым полем телефона",
                loginActivity.licenseAgreement().isEnabled());
    }
    @Test
    public void loginNewRegisteredUser() throws UiObjectNotFoundException{
        script.openSmsCodeActivity();
        assertTrue("Не отображается окно с вводом кода подтверждения",
                smsActivity.description().isEnabled());
    }
}

