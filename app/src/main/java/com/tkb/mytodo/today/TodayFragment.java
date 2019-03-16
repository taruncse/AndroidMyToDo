package com.tkb.mytodo.today;

import com.tkb.mytodo.R;
import com.tkb.mytodo.base.CoreFragment;
import com.tkb.mytodo.today.newc.TaskAdapter;
import com.tkb.mytodo.today.newc.TaskViewModel;
import com.tkb.mytodo.today.newc.TaskModel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;

@EFragment(R.layout.fragment_today)
public class TodayFragment extends CoreFragment {

   /* @ViewById(R.id.increment_button)
    Button increment_button;*/

   // ClickCounterViewModel viewModel;

   /* @ViewById(R.id.click_count_text)
    TextView clickCountText ;

    @Click(R.id.increment_button)*/
   @ViewById(R.id.taskRecyclerView)
   RecyclerView taskRecyclerView;

   /* public void incrementClickCount() {
        viewModel.setCount(viewModel.getCount() + 1);
        displayClickCount(viewModel.getCount());
    }*/

    private void displayClickCount(int clickCount) {
       // clickCountText.setText(String.valueOf(clickCount));
    }


    @AfterViews
    void afterViews() {
       /* LoggingClickCounterViewModelFactory factory =
                new LoggingClickCounterViewModelFactory(new ClickLoggingInterceptor());

        viewModel = ViewModelProviders.of(getActivity(), factory).get(LoggingClickCounterViewModel.class);
        displayClickCount(viewModel.getCount());*/

        TaskViewModel taskViewModel = ViewModelProviders.of(this).get(TaskViewModel.class);
        final TaskAdapter adapter = new TaskAdapter(getActivity());

        taskViewModel.contactPagedList.observe(this, new Observer<PagedList<TaskModel>>() {
            @Override
            public void onChanged(@Nullable PagedList<TaskModel> contacts) {
                adapter.submitList(contacts);
            }
        });

        taskRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
       // setTitle(getString(R.string.drawer_item_today));
    }

    public TodayFragment() {
    }
}