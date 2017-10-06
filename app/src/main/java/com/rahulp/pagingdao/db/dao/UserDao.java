package com.rahulp.pagingdao.db.dao;

import android.arch.paging.LivePagedListProvider;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.rahulp.pagingdao.User;

import java.util.List;



@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAll(List<User> users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(User... user);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public void updateUser(User... user);

    @Delete
    public void deleteUser(User... user);

    @Query("SELECT * FROM User ")
    public abstract LivePagedListProvider<Integer,User> usersByFirstNameRahul();

    @Query("SELECT * FROM User")
    public abstract LivePagedListProvider<Integer,User> usersByFirstName();

}
