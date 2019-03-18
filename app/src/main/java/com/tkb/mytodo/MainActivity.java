package com.tkb.mytodo;

import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;

import com.tkb.mytodo.base.CoreActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_main)

public class MainActivity extends CoreActivity {

    @ViewById(R.id.toolbar)
    Toolbar toolbar;
    Bundle savedInstanceState;

    @Bean
    DrawerManager drawerManager;

    @OptionsMenuItem
    MenuItem menuSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
    }

    @AfterViews
    void afterView() {
        setSupportActionBar(toolbar);
        drawerManager.setupHeader(savedInstanceState);
        drawerManager.setupDrawer(savedInstanceState, toolbar);
        //setSupportActionBar(toolbar);
        //Load Initial fragment
        loadFragment((new FileBrowserFactory().getFragment(FileBrowserFactory.TODAY)));
        //toolbar.setTitle("Tarun");
    }
}
