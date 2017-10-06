package com.rahulp.pagingdao;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.rahulp.pagingdao.db.AppDatabase;
import com.rahulp.pagingdao.db.DatabaseCreator;
import com.rahulp.pagingdao.db.dao.EmployeeDao;
import com.rahulp.pagingdao.db.dao.UserDao;
import com.rahulp.pagingdao.model.EmployeeViewModel;
import com.rahulp.pagingdao.model.UserViewModel;

public class MainActivity extends AppCompatActivity {

    AppDatabase appDatabase;
    UserDao userDao;
    EmployeeDao EmpDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = Room.databaseBuilder(MainActivity.this, AppDatabase.class, AppDatabase.DATABASE_NAME).build();
        userDao = appDatabase.userDao();
        EmpDao = appDatabase.empDao();

        RecyclerView recyclerView = findViewById(R.id.userList);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        UserViewModel viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        viewModel.init(userDao);

        EmployeeViewModel employeeViewModel=ViewModelProviders.of(this).get(EmployeeViewModel.class);
        employeeViewModel.init(EmpDao);


        final UserAdapter userUserAdapter = new UserAdapter();
        final EmployeeAdapter employeeAdapter=new EmployeeAdapter();

        viewModel.userList.observe(this, pagedList -> {
            userUserAdapter.setList(pagedList);
        });

        employeeViewModel.emploListLiveData.observe(this,pagedList ->{
            employeeAdapter.setList(pagedList);
        });

        recyclerView.setAdapter(userUserAdapter);
        //recyclerView.setAdapter(employeeAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_insert:
                insertUser(appDatabase);
                break;
        }
        return true;
    }

    public void insertUser(final AppDatabase appDatabase) {
        final DatabaseCreator databaseCreator = new DatabaseCreator();
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase.userDao().insertAll(databaseCreator.getRandomUserList());
                return null;
            }
        }.execute();
    }
}
