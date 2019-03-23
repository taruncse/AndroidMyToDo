package com.tkb.mytodo.today.newc;


import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

public class TaskViewModel extends ViewModel {

    public LiveData<PagedList<TaskModel>> contactPagedList;
    LiveData<PageKeyedDataSource<Integer, TaskModel>> liveDataSource;

    public TaskViewModel() {

        TaskDataSourceFactory taskDataSourceFactory = new TaskDataSourceFactory();
        liveDataSource = taskDataSourceFactory.getContactLiveDataSource();

        PagedList.Config config =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(TaskDataSource.PAGE_SIZE)
                        .build();

        contactPagedList = (new LivePagedListBuilder(taskDataSourceFactory, config)).build();

    }

    public void replaceSubscription(LifecycleOwner lifecycleOwner, String userName) {
        contactPagedList.removeObservers(lifecycleOwner);
        contactPagedList = createFilteredUsers(userName);
    }

    private LiveData<PagedList<TaskModel>> createFilteredUsers(String userName) {
        // TODO: handle if `null` and load all data instead
        return new LivePagedListBuilder<>(userName,
                new PagedList.Config.Builder() //
                        .setPageSize(20) //
                        .setPrefetchDistance(20) //
                        .setEnablePlaceholders(true) //
                        .build())
                .setInitialLoadKey(0)
                .build();

    }

}
