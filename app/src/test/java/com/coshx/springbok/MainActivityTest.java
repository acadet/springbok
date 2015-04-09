package com.coshx.springbok;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

/**
 * @class MainActivityTest
 * @brief
 */
@RunWith(GradleRobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity _activity;

    @Before
    public void setUp() {
        _activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void notNull() {
        Assert.assertNotNull(_activity);
    }
}
