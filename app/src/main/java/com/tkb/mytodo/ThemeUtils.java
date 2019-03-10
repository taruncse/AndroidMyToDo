package com.tkb.mytodo;

/**
 * Created by itc on 11/28/17.
 */

public class ThemeUtils {
    public static int styleId = R.style.AppTheme;
    public static int colorPrimary = R.color.colorPrimary;
    public static int colorPrimaryDark = R.color.colorPrimaryDark;
    public static int colorAccent = R.color.colorAccent;
    public static int disabled = R.color.md_grey_400;

    public static void updateTheme(String code) {
        switch (code) {
            /*case "33seven":
                ThemeUtils.styleId = R.style.AppTheme_TTS;
                ThemeUtils.colorPrimary = R.color.tts_colorPrimary;
                ThemeUtils.colorPrimaryDark = R.color.tts_colorPrimaryDark;
                ThemeUtils.colorAccent = R.color.tts_colorAccent;
                break;
            case "c-suite":
                ThemeUtils.styleId = R.style.AppTheme_CS;
                ThemeUtils.colorPrimary = R.color.cs_colorPrimary;
                ThemeUtils.colorPrimaryDark = R.color.cs_colorPrimaryDark;
                ThemeUtils.colorAccent = R.color.cs_colorAccent;
                break;
            case "aligned360vault":
            case "alignedCapital":
                ThemeUtils.styleId = R.style.AppTheme_AC;
                ThemeUtils.colorPrimary = R.color.ac_colorPrimary;
                ThemeUtils.colorPrimaryDark = R.color.ac_colorPrimaryDark;
                ThemeUtils.colorAccent = R.color.ac_colorAccent;
                break;
            case "tmfd":
                ThemeUtils.styleId = R.style.AppTheme_TMFD;
                ThemeUtils.colorPrimary = R.color.tmfd_colorPrimary;
                ThemeUtils.colorPrimaryDark = R.color.tmfd_colorPrimaryDark;
                ThemeUtils.colorAccent = R.color.tmfd_colorAccent;
                break;
            case "cx08":
                ThemeUtils.styleId = R.style.AppTheme_TTS;
                ThemeUtils.colorPrimary = R.color.tts_colorPrimary;
                ThemeUtils.colorPrimaryDark = R.color.tts_colorPrimaryDark;
                ThemeUtils.colorAccent = R.color.tts_colorAccent;
                break;*/
            default:
                ThemeUtils.styleId = R.style.AppTheme;
                ThemeUtils.colorPrimary = R.color.colorPrimary;
                ThemeUtils.colorPrimaryDark = R.color.colorPrimaryDark;
                ThemeUtils.colorAccent = R.color.colorAccent;
                break;

        }
    }
}
