package com.rahulp.pagingdao.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.PagedList;

import com.rahulp.pagingdao.Employee;
import com.rahulp.pagingdao.db.dao.EmployeeDao;

/**
 * Created by warlord on 10/4/2017.
 */

public class EmployeeViewModel extends ViewModel {

    public LiveData<PagedList<Employee>> emploListLiveData;

    public EmployeeViewModel() {

    }

    public void init(EmployeeDao employeeDao) {
        emploListLiveData = employeeDao.employeesByFirstName().create(0,
                new PagedList.Config.Builder()
                        .setEnablePlaceholders(true)
                        .setPageSize(10)
                        .setPrefetchDistance(5)
                        .build());
    }
}
