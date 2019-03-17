package com.tkb.mytodo.today.newc;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

public class TaskDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, TaskModel>> contactLiveDataSource = new MutableLiveData<>();


    @Override
    public DataSource create() {
        TaskDataSource taskDataSource = new TaskDataSource();
        contactLiveDataSource.postValue(taskDataSource);
        return taskDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, TaskModel>> getContactLiveDataSource() {
        return contactLiveDataSource;
    }
}
