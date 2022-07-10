package tech.sushnag22.attendancemanager.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tech.sushnag22.attendancemanager.R;
import tech.sushnag22.attendancemanager.controllers.DbHandler;
import tech.sushnag22.attendancemanager.models.Faculty;

public class AddFacultyActivity extends AppCompatActivity {

    Button saveFacultyBtn;
    EditText facultyFirstName;
    EditText facultyLastName;
    EditText facultyPhone;
    EditText facultyEmail;
    EditText facultyUsername;
    EditText facultyPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_faculty);

        facultyFirstName = findViewById(R.id.ed_faculty_fName);
        facultyLastName = findViewById(R.id.ed_faculty_lName);
        facultyPhone = findViewById(R.id.ed_faculty_phone);
        facultyEmail = findViewById(R.id.ed_faculty_email);
        facultyUsername = findViewById(R.id.ed_faculty_uname);
        facultyPassword = findViewById(R.id.edt_faculty_pass);
        saveFacultyBtn = findViewById(R.id.save_faculty_btn);

        saveFacultyBtn.setOnClickListener(v -> {

            String first_name = facultyFirstName.getText().toString();
            String last_name = facultyLastName.getText().toString();
            String phone_no = facultyPhone.getText().toString();
            String email = facultyEmail.getText().toString();
            String userName = facultyUsername.getText().toString();
            String passWord = facultyPassword.getText().toString();

            if (TextUtils.isEmpty(first_name)) {
                facultyFirstName.setError("Please enter firstname");
            } else if (TextUtils.isEmpty(last_name)) {
                facultyLastName.setError("Please enter lastname");
            } else if (TextUtils.isEmpty(phone_no)) {
                facultyPhone.setError("Please enter phone number");
            } else if (TextUtils.isEmpty(email)) {
                facultyEmail.setError("Please enter email");
            } else if (TextUtils.isEmpty(userName)) {
                facultyPhone.setError("Please enter username");
            } else if (TextUtils.isEmpty(passWord)) {
                facultyEmail.setError("Please enter password");
            } else {

                Faculty facultyBean = new Faculty();
                facultyBean.setFaculty_firstname(first_name);
                facultyBean.setFaculty_lastname(last_name);
                facultyBean.setFaculty_mobile_number(phone_no);
                facultyBean.setFaculty_email(email);
                facultyBean.setFaculty_username(userName);
                facultyBean.setFaculty_password(passWord);

                DbHandler dbHandler = new DbHandler(AddFacultyActivity.this);

                try {
                    dbHandler.addFaculty(facultyBean);
                    Intent intent = new Intent(AddFacultyActivity.this, AdminDashboardActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Faculty added successfully", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
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