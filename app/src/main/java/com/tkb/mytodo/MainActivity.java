package com.tkb.mytodo;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.tkb.mytodo.base.CoreActivity;
import com.tkb.mytodo.today.TodayFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)

public class MainActivity extends CoreActivity {

    @ViewById(R.id.toolbar)
    Toolbar toolbar;
    Bundle savedInstanceState;
    Fragment todayFragment;
    @Bean
    DrawerManager drawerManager;



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
        todayFragment = new FileBrowserFactory().getFragment(FileBrowserFactory.TODAY);
        loadFragment(todayFragment);
    }

    //https://developer.android.com/training/search/setup
   }
