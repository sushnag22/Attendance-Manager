package tech.sushnag22.attendancemanager.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import tech.sushnag22.attendancemanager.R;
import tech.sushnag22.attendancemanager.controllers.DbHandler;
import tech.sushnag22.attendancemanager.models.Student;

public class AddStudentActivity extends AppCompatActivity {


    private final String[] branchString = new String[]{"ISE"};
    private final String[] SemString = new String[]{"6th"};
    Button saveBtn;
    EditText studentUsn;
    EditText studentFirstName;
    EditText studentLastName;
    EditText studentPhone;
    EditText studentEmail;
    Spinner spinnerBranch, spinnerSem;
    String branch;
    String semester;
    View contextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        contextView = findViewById(android.R.id.content).getRootView();
        spinnerBranch = findViewById(R.id.spinner_stu_branch);
        spinnerSem = findViewById(R.id.spinner_stu_sem);
        studentUsn = findViewById(R.id.ed_stu_usn);
        studentFirstName = findViewById(R.id.ed_stu_first_name);
        studentLastName = findViewById(R.id.ed_stu_last_name);
        studentPhone = findViewById(R.id.ed_stu_mob_no);
        studentEmail = findViewById(R.id.ed_stu_email);
        saveBtn = findViewById(R.id.save_student_btn);

        spinnerBranch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {
                branch = (String) spinnerBranch.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        ArrayAdapter<String> adapter_branch = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, branchString);
        adapter_branch
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBranch.setAdapter(adapter_branch);

        spinnerSem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {
                semester = (String) spinnerSem.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        ArrayAdapter<String> adapter_year = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, SemString);
        adapter_year
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSem.setAdapter(adapter_year);

        saveBtn.setOnClickListener(v -> {
            String usn = studentUsn.getText().toString();
            String first_name = studentFirstName.getText().toString();
            String last_name = studentLastName.getText().toString();
            String phone_no = studentPhone.getText().toString();
            String email = studentEmail.getText().toString();

            if (TextUtils.isEmpty(usn)) {
                studentEmail.setError("Please enter usn");
            } else if (TextUtils.isEmpty(first_name)) {
                studentFirstName.setError("Please enter firstname");
            } else if (TextUtils.isEmpty(last_name)) {
                studentLastName.setError("Please enter lastname");
            } else if (TextUtils.isEmpty(phone_no)) {
                studentPhone.setError("Please enter phone number");
            } else if (TextUtils.isEmpty(email)) {
                studentEmail.setError("Please enter email id");
            } else {

                Student student = new Student();

                student.setStudent_usn(usn);
                student.setStudent_firstname(first_name);
                student.setStudent_lastname(last_name);
                student.setStudent_mobile_number(phone_no);
                student.setStudent_email(email);
                student.setStudent_branch(branch);
                student.setStudent_sem(semester);

                DbHandler dbHandler = new DbHandler(AddStudentActivity.this);

                try {
                    dbHandler.addStudent(student);
                    Intent intent = new Intent(AddStudentActivity.this, AdminDashboardActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Student added successfully",
                            Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }
}