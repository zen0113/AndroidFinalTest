package com.example.finalexamproject;
import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable iconDrawable;
    private String titleStr;
    private String memoStr;
    private String dateStr;

    public void setIcon(Drawable icon) {
        iconDrawable = icon;
    }
    public void setTitle(String title) {
        titleStr = title;
    }
    public void setDate(String date) {
        dateStr = date;
    }
    public void setMemo(String memo)
    {
        memoStr = memo;
    }

    public Drawable getIcon() {
        return this.iconDrawable;
    }
    public String getTitle() {
        return this.titleStr;
    }
    public String getDate() {
        return this.dateStr;
    }
    public String getMemo() {
        return this.memoStr;
    }
}
