package com.tkb.mytodo.base;

import androidx.fragment.app.Fragment;

/**
 * Created by itc on 9/18/17.
 */

public abstract class CoreFragment extends Fragment {

    protected void setTitle(String title) {
        getActivity().setTitle(title);
    }

}
