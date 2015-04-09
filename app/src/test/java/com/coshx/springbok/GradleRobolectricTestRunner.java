package com.coshx.springbok;

import android.app.Activity;
import android.os.Build;

import org.robolectric.AndroidManifest;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.res.Fs;

import java.io.File;
import java.io.IOException;

/**
 * @class GradleRobolectricTestRunner
 * @brief
 */
public class GradleRobolectricTestRunner extends RobolectricTestRunner {
    private static final String PROJECT_DIR =
        getProjectDirectory();

    // Include manifest
    private static final String MANIFEST_PROPERTY =
        PROJECT_DIR + "src/main/AndroidManifest.xml";

    // Include compiled resources (not the raw ones)
    private static final String RES_PROPERTY =
        PROJECT_DIR + "build/intermediates/res/app/debug/";

    // Define SDK to use
    private static final int MAX_SDK_SUPPORTED_BY_ROBOLECTRIC =
        Build.VERSION_CODES.JELLY_BEAN_MR2;

    public GradleRobolectricTestRunner(final Class<?> testClass) throws Exception {
        super(testClass);
    }

    private static String getProjectDirectory() {
        String path = "";
        try {
            File file = new File("..");
            path = file.getCanonicalPath();
            path = path + "/app/";
        } catch (IOException ex) {
        }
        return path;
    }

    @Override
    public AndroidManifest getAppManifest(Config config) {
        return new AndroidManifest(
            Fs.fileFromPath(MANIFEST_PROPERTY),
            Fs.fileFromPath(RES_PROPERTY)
        ) {
            @Override
            public int getTargetSdkVersion() {
                return MAX_SDK_SUPPORTED_BY_ROBOLECTRIC;
            }

            @Override
            public String getThemeRef(Class<? extends Activity> activityClass) {
                return "@style/AppTheme"; // Needs to define default theme
            }

        };
    }
}
