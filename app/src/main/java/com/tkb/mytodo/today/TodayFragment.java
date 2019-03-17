package com.tkb.mytodo.today;

import com.tkb.mytodo.R;
import com.tkb.mytodo.base.CoreFragment;
import com.tkb.mytodo.today.newc.TaskAdapter;
import com.tkb.mytodo.today.newc.TaskViewModel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

@EFragment(R.layout.fragment_today)
public class TodayFragment extends CoreFragment {

   @ViewById(R.id.taskRecyclerView)
   RecyclerView taskRecyclerView;

    private void displayClickCount(int clickCount) {
       // clickCountText.setText(String.valueOf(clickCount));
    }


    @AfterViews
    void afterViews() {

        taskRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        taskRecyclerView.setHasFixedSize(true);

        TaskViewModel taskViewModel = ViewModelProviders.of(getActivity()).get(TaskViewModel.class);
        final TaskAdapter adapter = new TaskAdapter(getActivity());

        taskViewModel.contactPagedList.observe(getActivity(), contacts -> adapter.submitList(contacts));

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