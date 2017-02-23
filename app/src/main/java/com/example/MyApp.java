package com.example;

import java.util.concurrent.TimeUnit;

import com.example.demo.ClearableCookieJar;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.https.HttpsUtils;

import okhttp3.OkHttpClient;
import android.app.Application;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class MyApp extends Application {
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
		OkHttpClient okHttpClient = new OkHttpClient.Builder()
				.connectTimeout(10000L, TimeUnit.MICROSECONDS)
				.readTimeout(10000L, TimeUnit.MICROSECONDS)
				.hostnameVerifier(new HostnameVerifier() {
					@Override
					public boolean verify(String s, SSLSession sslSession) {
						return true;
					}
				})
				.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
				.build();
		
		OkHttpUtils.initClient(okHttpClient);
		super.onCreate();


//
//		ClearableCookieJar cookieJar1 = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(getApplicationContext()));
//
//		HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
//
////        CookieJarImpl cookieJar1 = new CookieJarImpl(new MemoryCookieStore());
//		OkHttpClient okHttpClient = new OkHttpClient.Builder()
//				.connectTimeout(10000L, TimeUnit.MILLISECONDS)
//				.readTimeout(10000L, TimeUnit.MILLISECONDS)
//				.addInterceptor(new LoggerInterceptor("TAG"))
//				.cookieJar(cookieJar1)
//				.hostnameVerifier(new HostnameVerifier()
//				{
//					@Override
//					public boolean verify(String hostname, SSLSession session)
//					{
//						return true;
//					}
//				})
//				.sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
//				.build();
//		OkHttpUtils.initClient(okHttpClient);

	}
}
