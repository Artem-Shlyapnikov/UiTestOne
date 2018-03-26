package com.example.test.uitestone.uitestOne.instrumentationClasses.objectActivities;


import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.example.test.uitestone.uitestOne.instrumentationClasses.testConfig.Selector;

public class GalleryActivity {

    public UiObject image (int i) throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/recyclerView")
                .getChild(new UiSelector().className("android.widget.FrameLayout").index(i));
    }
    public UiObject chooseImageButton() throws UiObjectNotFoundException{
        return Selector.ById("co.namba1:id/send");
    }

}
