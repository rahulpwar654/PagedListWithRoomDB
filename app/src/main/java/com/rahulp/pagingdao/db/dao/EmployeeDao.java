package com.rahulp.pagingdao.db.dao;

import android.arch.paging.LivePagedListProvider;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.rahulp.pagingdao.Employee;

import java.util.List;

/**
 * Created by warlord on 10/4/2017.
 */

@Dao
public interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAll(List<Employee> employees);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Employee... employees);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public void updateUser(Employee... employees);

    @Delete
    public void deleteUser(Employee... employees);

    /*@Query("SELECT * FROM Employee ")
    public abstract LivePagedListProvider<Integer,Employee> usersByFirstNameRahul();*/

    @Query("SELECT * FROM Employee")
    public abstract LivePagedListProvider<Integer,Employee> employeesByFirstName();



}
