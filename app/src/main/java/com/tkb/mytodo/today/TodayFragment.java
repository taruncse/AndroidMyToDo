package com.tkb.mytodo.today;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tkb.mytodo.R;
import com.tkb.mytodo.base.CoreActivity;
import com.tkb.mytodo.base.CoreFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import androidx.lifecycle.ViewModelProviders;

@EFragment(R.layout.fragment_today)
public class TodayFragment extends CoreFragment {

    @ViewById(R.id.increment_button)
    Button increment_button;

    ClickCounterViewModel viewModel;

    @ViewById(R.id.click_count_text)
    TextView clickCountText ;

    @Click(R.id.increment_button)
    public void incrementClickCount() {
        viewModel.setCount(viewModel.getCount() + 1);
        displayClickCount(viewModel.getCount());
    }

    private void displayClickCount(int clickCount) {
        clickCountText.setText(String.valueOf(clickCount));
    }


    @AfterViews
    void afterViews() {
        LoggingClickCounterViewModelFactory factory =
                new LoggingClickCounterViewModelFactory(new ClickLoggingInterceptor());

        viewModel = ViewModelProviders.of(getActivity(), factory).get(LoggingClickCounterViewModel.class);
        displayClickCount(viewModel.getCount());
    }

    @Override
    public void onResume() {
        super.onResume();
        setTitle(getString(R.string.drawer_item_today));
    }

    public TodayFragment() {
    }
}