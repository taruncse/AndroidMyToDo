package com.tkb.mytodo;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.itemanimators.AlphaCrossFadeAnimator;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.interfaces.OnCheckedChangeListener;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

public class DrawerManager  implements OnCheckedChangeListener {

    private static final int MY_DOCUMENTS = 1;
    private static final int UNFILED = 2;
    private static final int SHARED_WITH_ME = 3;
    private static final int LOGOUT = 20;

    private AccountHeader headerResult = null;
    private Drawer result = null;
    private MainActivity activity;
    DrawerManager (MainActivity activity){
        this.activity = activity;
    }
    void setupDrawer(Bundle savedInstanceState, Toolbar toolbar) {

        result = new DrawerBuilder()
                .withActivity(activity)
                .withToolbar(toolbar)
                .withHasStableIds(true)
                .withItemAnimator(new AlphaCrossFadeAnimator())
                .withAccountHeader(headerResult) //set the AccountHeader we created earlier for the header
                .withActionBarDrawerToggle(true)
                .withActionBarDrawerToggleAnimated(true)
                .withOnDrawerNavigationListener(clickedView -> {
                    activity.onBackPressed();
                    return true;
                })
                .addDrawerItems(getItem(MY_DOCUMENTS), getItem(UNFILED), getItem(SHARED_WITH_ME),
                        new DividerDrawerItem(), getItem(LOGOUT)
                ) // add the items we want to use with our Drawer
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    if (drawerItem != null) {
                        onClickedItem(drawerItem.getIdentifier());
                    }

                    return false;
                })

                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(true)
                .withShowDrawerUntilDraggedOpened(true)
                .build();

        if (savedInstanceState == null) {
            result.setSelection(1, false);
        }

        activity.getSupportFragmentManager().addOnBackStackChangedListener(() -> {
            int backStackEntryCount = activity.getSupportFragmentManager().getBackStackEntryCount();
            ActionBar supportActionBar = activity.getSupportActionBar();
            if (supportActionBar == null) return;
            if (backStackEntryCount > 0) {
                result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(false);
                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            } else {
                activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
            }
        });

        loadProfiles();
    }
    void setupHeader(Bundle savedInstanceState) {
        headerResult = new AccountHeaderBuilder()
                .withActivity(activity)
                .withTranslucentStatusBar(true)
                .withHeaderBackground(R.drawable.header)
                .withOnAccountHeaderListener((view, profile, current) -> {

                    return false;
                })
                .withSavedInstance(savedInstanceState)
                .build();

    }
    private IDrawerItem getItem(final int identifier) {
        switch (identifier) {
            case MY_DOCUMENTS: return new PrimaryDrawerItem().withName(R.string.drawer_item_my_documents).withIcon(GoogleMaterial.Icon.gmd_folder_open).withIdentifier(MY_DOCUMENTS).withSelectedIconColorRes(ThemeUtils.colorAccent).withSelectedTextColorRes(ThemeUtils.colorAccent);
            case UNFILED : return new PrimaryDrawerItem().withName(R.string.drawer_item_unfiled)
                    .withIcon(GoogleMaterial.Icon.gmd_assignment)
                    .withIdentifier(UNFILED)
                    .withSelectedIconColorRes(ThemeUtils.colorAccent)
                    .withSelectedTextColorRes(ThemeUtils.colorAccent)
                    .withDisabledIconColorRes(ThemeUtils.disabled)
                    .withDisabledTextColorRes(ThemeUtils.disabled)
                    .withBadgeStyle(new BadgeStyle().withTextColor(Color.WHITE).withColorRes(R.color.md_red_500));
            case SHARED_WITH_ME: return new PrimaryDrawerItem().withName(R.string.drawer_item_shared_with_me)
                    .withIcon(GoogleMaterial.Icon.gmd_folder_shared)
                    .withIdentifier(SHARED_WITH_ME)
                    .withSelectedIconColorRes(ThemeUtils.colorAccent)
                    .withSelectedTextColorRes(ThemeUtils.colorAccent)
                    .withDisabledIconColorRes(ThemeUtils.disabled)
                    .withDisabledTextColorRes(ThemeUtils.disabled);
            case LOGOUT: return new PrimaryDrawerItem().withName(R.string.drawer_item_logout).withTextColorRes(R.color.md_red_500).withIcon(FontAwesome.Icon.faw_sign_out_alt).withIconColorRes(R.color.md_red_500).withIdentifier(20).withSelectable(false);

            default: return null;
        }
    }

    @Override
    public void onCheckedChanged(IDrawerItem drawerItem, CompoundButton buttonView, boolean isChecked) {

    }

    private void onClickedItem(long identifier) {
        if (identifier == 1) {
            //activity.loadFragment((new FileBrowserFactory().getFragment(FileBrowserFactory.SYSTEM)));
        }else if (identifier == 10 ) {
           // activity.loadFragment(EntityFragment_.builder().build());
        } else if (identifier == LOGOUT) {
            new AlertDialog.Builder(activity)
                    .setTitle("Logout")
                    .setMessage("Do you want to logout?")
                    .setNegativeButton("NO", null)
                    .setPositiveButton("YES", (dialogInterface, i) -> {
                        Toast.makeText(activity,"Logout",Toast.LENGTH_LONG).show();
                    }).show();
        }
    }

    private void loadProfiles() {
        int index = 100;

        headerResult.addProfile(new AccountSectionDrawerItem().withName("Trusted Advisor Access").withSelectable(false).withDivider(index > 100), index % 100);

        Profile profile = new Profile("Tarun","tarun.pstu@gmail.com",true);
            ProfileDrawerItem profileItem = new ProfileDrawerItem()
                    .withName(profile.getName())
                    .withEmail(profile.getEmail())
                    .withNameShown(true)
                    .withTextColorRes(profile.isActive() ? R.color.material_drawer_primary_text : R.color.material_drawer_hint_text)
                    .withIcon(TextDrawable
                            .builder()
                            .beginConfig()
                            .bold()
                            .height(64)
                            .width(64)
                            .endConfig()
                            .buildRound("Ta",
                                    ColorGenerator.MATERIAL.getColor(profile.getName())))
                    .withIdentifier(1)
                    .withSelectedTextColorRes(ThemeUtils.colorAccent)
                    .withTag(profile);
            headerResult.addProfile(profileItem, index % 100);
        }
}

