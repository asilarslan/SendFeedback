package com.asilarslan.sendfeedback;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by asilarslan on 10.09.2015.
 */
public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "6LLVC8fyo9yU5B0080GIVhLer84e7QW77dFcPt8d", "M96pK0SoKk8QccDTy1J7cw4jWX37fqnmaYZ4jcRq");
    }
}