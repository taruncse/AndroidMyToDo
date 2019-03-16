/*
package com.tkb.mytodo.today;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tkb.mytodo.base.CoreActivity;
import com.tkb.mytodo.R;

import org.androidannotations.annotations.ViewById;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

public class TodayActivity extends CoreActivity {

   */
/* protected TextView clickCountText;
    protected Button increment_button;*//*

    private ClickCounterViewModel viewModel;
    @ViewById(R.id.taskRecyclerView)
    RecyclerView taskRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        //clickCountText = findViewById(R.id.click_count_text);

        LoggingClickCounterViewModelFactory factory =
                new LoggingClickCounterViewModelFactory(new ClickLoggingInterceptor());

        viewModel = ViewModelProviders.of(this, factory).get(LoggingClickCounterViewModel.class);
        displayClickCount(viewModel.getCount());
    }

    public void incrementClickCount(View button) {
        viewModel.setCount(viewModel.getCount() + 1);
        displayClickCount(viewModel.getCount());
    }

    private void displayClickCount(int clickCount) {
       // clickCountText.setText(String.valueOf(clickCount));
    }
}*/
