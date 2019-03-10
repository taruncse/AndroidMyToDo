package com.tkb.mytodo;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public abstract class CoreActivity extends AppCompatActivity /*implements ColorPickerDialogListener*/ {

   // MaterialDialog progress;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(ThemeUtils.styleId, ThemeUtils.colorPrimaryDark);
        super.onCreate(savedInstanceState);
    }

    private void setTheme(int theme, int colorPrimaryDark) {
        setTheme(theme);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(colorPrimaryDark));
        }
    }

    private void homeAsUpByBackStack() {
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) return;
        if (backStackEntryCount > 0) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        } else {
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    /**
     * Load fragment by replacing all previous fragments
     * @param fragment
     */
   /* public void loadFragment(Fragment fragment) {
        if (fragment == null) return;
        FragmentManager fragmentManager = getSupportFragmentManager();
        // clear back stack
        for (int i = 0; i < fragmentManager.getBackStackEntryCount(); i++) {
            fragmentManager.popBackStack();
        }
        FragmentTransaction t = fragmentManager.beginTransaction();
        t.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        t.replace(R.id.mainView, fragment, "main");
        fragmentManager.popBackStack();
        // TODO: we have to allow state loss here
        // since this function can get called from an AsyncTask which
        // could be finishing after our app has already committed state
        // and is about to get shutdown.  What we *should* do is
        // not commit anything in an AsyncTask, but that's a bigger
        // change than we want now.
        t.commitAllowingStateLoss();
    }

    /**
     * Load Fragment on top of other fragments
     * @param fragment
     */
    /*public void  loadChildFragment(Fragment fragment) {
        if (fragment == null) return;
//        Validate.notNull(fragment);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        ft.replace(R.id.mainView, fragment, "main")
                .addToBackStack(null)
                .commit();
    }

    /*@Override
    public void onColorSelected(int dialogId, int color) {
        EventBus.getDefault().post(new ColorPickerEvent(true, dialogId, color));
    }

    @Override
    public void onDialogDismissed(int dialogId) {
        EventBus.getDefault().post(new ColorPickerEvent(false, dialogId, 0));
    }

    public void showProgress(@StringRes int msg) {
        if (progress == null) {
            progress = new MaterialDialog.Builder(this)
                    .content(msg == 0 ? R.string.please_wait : msg)
                    .progress(true, 0)
                    .cancelable(false).show();
        } else {
            progress.setContent(msg == 0 ? R.string.please_wait : msg);
            progress.show();
        }
    }

    public void dismissProgress() {
        progress.hide();
    }*/
}
