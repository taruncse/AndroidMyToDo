package com.tkb.mytodo;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.tkb.mytodo.base.CoreActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
//@OptionsMenu(R.menu.menu_main)

public class MainActivity extends CoreActivity {

    @ViewById(R.id.toolbar)
    Toolbar toolbar;
    Bundle savedInstanceState;

    @Bean
    DrawerManager drawerManager;

    /*@OptionsMenuItem
    MenuItem menuSearch;*/

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
//https://developer.android.com/training/search/setup
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.menuSearch).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }
}
