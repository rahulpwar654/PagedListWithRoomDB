package com.rahulp.pagingdao;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.DiffCallback;

/**
 * Created by warlord on 10/4/2017.
 */


@Entity
public class Employee {



    public static DiffCallback<Employee> EMPDIFF_CALLBACK = new DiffCallback<Employee>() {
        @Override
        public boolean areItemsTheSame(@NonNull Employee oldItem, @NonNull Employee newItem) {
            return oldItem.empid == newItem.empid;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Employee oldItem, @NonNull Employee newItem) {
            return oldItem.equals(newItem);
        }
    };
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "emp_id")
    public long empid;
    @ColumnInfo(name = "emp_name")
    public String empName;
    @ColumnInfo(name = "emp_desg")
    public String empDesignation;
    public String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (empid != employee.empid) return false;
        if (empName != null ? !empName.equals(employee.empName) : employee.empName != null)
            return false;
        return empDesignation != null ? empDesignation.equals(employee.empDesignation) : employee.empDesignation == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (empid ^ (empid >>> 32));
        result = 31 * result + (empName != null ? empName.hashCode() : 0);
        result = 31 * result + (empDesignation != null ? empDesignation.hashCode() : 0);
        return result;
    }
}
