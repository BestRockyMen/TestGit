package com.example.demo;

import okhttp3.CookieJar;

/**
 * Created by Administrator on 2017/2/17.
 */

public abstract class ClearableCookieJar implements CookieJar {
    public abstract void clear();
}
