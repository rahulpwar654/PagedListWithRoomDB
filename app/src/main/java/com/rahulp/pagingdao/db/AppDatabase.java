package com.rahulp.pagingdao.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.rahulp.pagingdao.Employee;
import com.rahulp.pagingdao.User;
import com.rahulp.pagingdao.db.dao.EmployeeDao;
import com.rahulp.pagingdao.db.dao.UserDao;

/**
 * Created by warlord on 18/9/17.
 */

/**
 *
 */


@Database(entities = {User.class, Employee.class}, version = 1)
abstract public class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "UserDb";



    public abstract UserDao userDao();
    public abstract EmployeeDao empDao();
}
