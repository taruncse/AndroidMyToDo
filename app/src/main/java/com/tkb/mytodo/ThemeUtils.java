package com.tkb.mytodo;

public class ThemeUtils {
    public static int styleId = R.style.AppTheme;
    public static int colorPrimary = R.color.colorPrimary;
    public static int colorPrimaryDark = R.color.colorPrimaryDark;
    public static int colorAccent = R.color.colorAccent;
    public static int disabled = R.color.md_grey_400;

    public static void updateTheme(String code) {
        switch (code) {
            default:
                ThemeUtils.styleId = R.style.AppTheme;
                ThemeUtils.colorPrimary = R.color.colorPrimary;
                ThemeUtils.colorPrimaryDark = R.color.colorPrimaryDark;
                ThemeUtils.colorAccent = R.color.colorAccent;
                break;

        }
    }
}
