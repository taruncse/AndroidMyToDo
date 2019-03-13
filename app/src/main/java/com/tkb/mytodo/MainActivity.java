package com.tkb.mytodo;

import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.tkb.mytodo.base.CoreActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends CoreActivity {

    @ViewById(R.id.toolbar)
    Toolbar toolbar;
    Bundle savedInstanceState;

    @Bean
    DrawerManager drawerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
    }

    @AfterViews
    void init() {
        drawerManager.setupHeader(savedInstanceState);
        drawerManager.setupDrawer(savedInstanceState, toolbar);

        //Load Initial fragment
        loadFragment((new FileBrowserFactory().getFragment(FileBrowserFactory.TODAY)));

    }
}
