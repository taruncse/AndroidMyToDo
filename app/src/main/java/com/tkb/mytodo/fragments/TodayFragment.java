package com.tkb.mytodo.fragments;

import com.tkb.mytodo.R;
import com.tkb.mytodo.base.CoreFragment;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_today)
public class TodayFragment extends CoreFragment {

    @AfterViews
    void afterViews() {
        //super.afterViews();

    }

    @Override
    public void onResume() {
        super.onResume();
        setTitle(getString(R.string.drawer_item_today));
    }

    public TodayFragment() {
        // Required empty public constructor
    }

}
