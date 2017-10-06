package com.rahulp.pagingdao;

import android.arch.paging.PagedListAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by warlord on 10/5/2017.
 */

public class EmployeeAdapter extends PagedListAdapter<Employee, EmployeeAdapter.EmployeeItemViewHolder> {

    protected EmployeeAdapter() {
        super(Employee.EMPDIFF_CALLBACK);
    }

    @Override
    public EmployeeAdapter.EmployeeItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_user_list, parent, false);
        return new EmployeeAdapter.EmployeeItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder( EmployeeAdapter.EmployeeItemViewHolder holder, int position) {
        Employee employee= getItem(position);
        if(employee!=null) {
            holder.bindTo(employee);
        }
    }

    static class EmployeeItemViewHolder extends RecyclerView.ViewHolder {
        TextView empName, empId;

        public EmployeeItemViewHolder(View itemView) {
            super(itemView);
            empId = itemView.findViewById(R.id.userId);
            empName = itemView.findViewById(R.id.userName);
        }

        public void bindTo(Employee employee) {
            empName.setText(employee.empName);
            empId.setText(String.valueOf(employee.empid));
        }
    }


}
