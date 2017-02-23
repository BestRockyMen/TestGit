package com.example.demo;

/**
 * Created by Administrator on 2017/2/17.
 */

import com.example.bean.UserBean;
import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.util.List;

import okhttp3.Response;
public abstract class ListCallBack extends Callback<List<UserBean>> {

    @Override
    public List<UserBean> parseNetworkResponse(Response response, int id) throws IOException
    {
        String string = response.body().string();
        List<UserBean> list = new Gson().fromJson(string, List.class);
        return list;
    }


}




