package com.example.test.uitestone.uitestOne.UiTestsClasses;


import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiObjectNotFoundException;

import com.example.test.uitestone.uitestOne.instrumentationClasses.commands.Scripts;

import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.GalleryActivity;
import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.RegistrationActivity;
import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.SmsCodeActivity;
import com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities.SplashScreenActivity;
import com.example.test.uitestone.uitestOne.instrumentationClasses.testConfig.StartMainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)


public class RegistrationUiTest {

    private Scripts script = new Scripts();
    private SmsCodeActivity smsActivity = new SmsCodeActivity();
    private RegistrationActivity regActivity = new RegistrationActivity();
    private GalleryActivity gallery = new GalleryActivity();
    private SplashScreenActivity splashScreenActivity = new SplashScreenActivity();

    @Before
    public void startMainActivity() throws InterruptedException, UiObjectNotFoundException {
        StartMainActivity mainActivity = new StartMainActivity();
        mainActivity.startMainActivity();
    }

    @Test
    public void checkDescription() throws UiObjectNotFoundException{
        script.openSmsCodeActivity();
        assertTrue("Дескрипшин не содержит номер телефона указанный при регистрации",
                smsActivity.description().getText().contains("Мы отправили код через СМС"));
    }
    @Test
    public void checkSendEmptyConfirmationCode()throws UiObjectNotFoundException{
        script.openSmsCodeActivity();
        smsActivity.startButton().clickAndWaitForNewWindow();
        assertTrue("Окно ввода подтверждения не отображэается после отправки пустой формы " +
                "\"Код подтверждения\"", smsActivity.description().isEnabled());
    }
    @Ignore // В связи с багом тест пока стоит в стаутсе игнор
    public void checkSendIncorrectConfirmationCode() throws UiObjectNotFoundException{
        script.openSmsCodeActivity();
        smsActivity.codeSmsField().setText("78954");
        smsActivity.startButton().clickAndWaitForNewWindow();
        assertTrue("Окно ввода подтверждения не отображэается после отправки не корректного " +
                "кода подтверждения", smsActivity.description().isEnabled());
    }
    @Test
    public void checkRepeatButton() throws UiObjectNotFoundException{
        script.openSmsCodeActivity();
        smsActivity.sendSmsCode().clickAndWaitForNewWindow();
        assertTrue("У кнопки повторной отправки отсутствует ограничение на использование",
                smsActivity.sendSmsCode().getText().contains("Повторная отправка кода через"));
    }
    @Test
    public void checkRegisterWithEmptyNameField()throws UiObjectNotFoundException{
        script.openRegistrationActivity();
        regActivity.nameField().clearTextField();
        regActivity.doneButton().clickAndWaitForNewWindow();
        assertTrue("Пользователь может зарегестрироваться с пустым именем",
                regActivity.nameField().isEnabled());
    }
}
