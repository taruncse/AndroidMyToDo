package com.tkb.mytodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

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
