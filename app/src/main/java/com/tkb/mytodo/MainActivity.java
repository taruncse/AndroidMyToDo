package com.tkb.mytodo;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.tkb.mytodo.base.CoreActivity;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
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
        loadFragment((new FileBrowserFactory().getFragment(FileBrowserFactory.TODAY)));
    }

    //https://developer.android.com/training/search/setup
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menuSearch.getActionView();

        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        return true;
    }
    @OptionsItem
    void menuSearch() {
        Toast.makeText(MainActivity.this,"SearchCliked",Toast.LENGTH_LONG).show();
    }
}
