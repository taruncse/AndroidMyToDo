package com.tkb.mytodo;

import androidx.fragment.app.Fragment;


public class FileBrowserFactory {

    public static final int TODAY = -2;
    public static final int ALL_TASKS = -4;
    public static final int ARCHIVED = -6;


    public Fragment getFragment(int level) {
        return getFragment(level, null,false);
    }
    public Fragment getFragment(int level, String fileId, boolean isTag) {
        if (level == TODAY) {
           // return SharedWithMeFragment_.builder().build();
            return null;
        } else if (level == ALL_TASKS) {
            return null;
        } else if (level == ARCHIVED) {
            return null;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
