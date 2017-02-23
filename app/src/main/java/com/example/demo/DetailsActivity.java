package com.example.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;


/**
 * Created by Administrator on 2017/2/17.
 */

public class DetailsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailsactivity);
        AppBarLayout appbarlayout = (AppBarLayout)findViewById(R.id.appbarlayout);
        CollapsingToolbarLayout toolbarlayout = (CollapsingToolbarLayout)findViewById(R.id.toolbarlayout);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
    }
}
