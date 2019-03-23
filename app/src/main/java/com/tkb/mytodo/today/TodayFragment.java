package com.tkb.mytodo.today;

import android.app.SearchManager;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.tkb.mytodo.MainActivity;
import com.tkb.mytodo.R;
import com.tkb.mytodo.base.CoreFragment;
import com.tkb.mytodo.today.newc.TaskAdapter;
import com.tkb.mytodo.today.newc.TaskViewModel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.ViewById;

import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

@EFragment(R.layout.fragment_today)
@OptionsMenu(R.menu.menu_main)

public class TodayFragment extends CoreFragment {

   @ViewById(R.id.taskRecyclerView)
   RecyclerView taskRecyclerView;
    TaskViewModel taskViewModel;
    @OptionsMenuItem
    MenuItem menuSearch;

   public TaskAdapter adapter;
    private void displayClickCount(int clickCount) {
       // clickCountText.setText(String.valueOf(clickCount));
    }


    @AfterViews
    void afterViews() {

        taskRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        taskRecyclerView.setHasFixedSize(true);

        taskViewModel = ViewModelProviders.of(getActivity()).get(TaskViewModel.class);
        adapter = new TaskAdapter(getActivity());

        taskViewModel.contactPagedList.observe(getActivity(), contacts -> adapter.submitList(contacts));

        taskRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        setTitle(getString(R.string.drawer_item_today));
    }

    public TodayFragment() {
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here
        super.onCreateOptionsMenu(menu, inflater);

        SearchManager searchManager =
                (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menuSearch.getActionView();

        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getActivity().getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //((TodayFragment)todayFragment).adapter.getFilter().filter(newText);
                replaceSubscription(newText);

                return true;
            }
        });
    }

    @OptionsItem
    void menuSearch() {
        Toast.makeText(getActivity(),"SearchCliked",Toast.LENGTH_LONG).show();
    }

    private void replaceSubscription(String userName) {
        taskViewModel.replaceSubscription(getActivity(), userName);
        startListening();
    }

    private void startListening() {
        taskViewModel.contactPagedList.observe(this, pagedList -> {
            //noinspection Convert2MethodRef
            adapter.submitList(pagedList); // used to be `setList`
        });
    }


}