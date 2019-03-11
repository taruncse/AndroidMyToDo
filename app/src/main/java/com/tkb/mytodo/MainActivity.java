package com.tkb.mytodo;

import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import org.androidannotations.annotations.EActivity;

//@EActivity(R.layout.activity_main)
public class MainActivity extends CoreActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        DrawerManager drawerManager =  new DrawerManager(this);
        drawerManager.setupHeader(savedInstanceState);

        drawerManager.setupDrawer(savedInstanceState, toolbar);

    }
}
