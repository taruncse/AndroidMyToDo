package com.tkb.mytodo.today.newc;


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
}
