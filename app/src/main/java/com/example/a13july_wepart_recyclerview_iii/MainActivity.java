package com.example.a13july_wepart_recyclerview_iii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private ArrayList<Employee> employeeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CardView mEtCardView;
    private EditText mEtName, mEtAge, mEtAddress;
    private Button mBtnDone;
    private EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildList();
        setRecycleView();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        mEtCardView = findViewById(R.id.editCardView);
        mEtName = findViewById(R.id.etName);
        mEtAddress = findViewById(R.id.etAddress);
        mEtAge = findViewById(R.id.etAge);
        mBtnDone = findViewById(R.id.btnDone);
    }

    private void buildList() {
        for (int i = 0; i < 50; i++) {
            Employee employee = new Employee("Amol Pardeshi", "At Post Bhadgaon Maharashtra - 4241" + i, i + 2);
            employeeList.add(employee);
        }

    }

    private void setRecycleView() {
        employeeAdapter = new EmployeeAdapter(employeeList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(employeeAdapter);

    }

    @Override
    public void onItemClicked(int position, Employee employee) {
        mEtCardView.setVisibility(View.VISIBLE);
        mEtName.setText(employee.getName());
        mEtAge.setText(employee.getAge() + "");
        mEtAddress.setText(employee.getAddress());

        mBtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEtCardView.setVisibility(View.GONE);
                //Edited details
                Employee new_employee = new Employee(mEtName.getText().toString()
                        , mEtAddress.getText().toString(), Integer.parseInt(mEtAge.getText().toString()));

                // employeeList.remove(employee);
                employeeAdapter.notifyItemChanged(position);
                //employeeAdapter.notifyDataSetChanged();
            }
        });


    }


}