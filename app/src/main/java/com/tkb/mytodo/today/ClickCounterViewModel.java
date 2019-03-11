package com.tkb.mytodo.today;

import androidx.lifecycle.ViewModel;

public class ClickCounterViewModel extends ViewModel {
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}