package com.tkb.mytodo.today.newc;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<TaskModel> loadJSONFromAsset() {
        try {
            TaskModel aTask ;
            List<TaskModel> allTasks= new ArrayList<>();
            for (int i=0; i<=50; i++){
                aTask = new TaskModel();
                aTask.setTitle("Task"+i);
                aTask.setDescription("Description"+i);
                allTasks.add(aTask);
            }
            return allTasks;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}