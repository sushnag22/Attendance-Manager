package tech.sushnag22.attendancemanager.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import tech.sushnag22.attendancemanager.R;
import tech.sushnag22.attendancemanager.controllers.DbHandler;
import tech.sushnag22.attendancemanager.models.Faculty;

public class ViewFacultyDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_faculty_details);

        int facultyId = getIntent().getExtras().getInt("faculty_id");

        TextView idTextView = findViewById(R.id.lbl_fac_id);
        TextView nameTextView = findViewById(R.id.lbl_fac_name);
        TextView phoneTextView = findViewById(R.id.lbl_fac_mob_no);
        TextView addressTextView = findViewById(R.id.lbl_fac_address);
        TextView usernameTextView = findViewById(R.id.lbl_fac_username);

        DbHandler dbHandler = new DbHandler(this);

        try {
            Faculty faculty = dbHandler.getFacultyById(facultyId);

            String id = "ID : " + String.valueOf(faculty.getFaculty_id());
            idTextView.setText(id);

            String name = "NAME : " + faculty.getFaculty_firstname() + " " + faculty.getFaculty_lastname();
            nameTextView.setText(name);

            String phone = "PHONE : " + faculty.getFaculty_mobile_number();
            phoneTextView.setText(phone);

            String address = "EMAIL : " + faculty.getFaculty_email();
            addressTextView.setText(address);

            String uname = "USERNAME : " + faculty.getFaculty_username();
            usernameTextView.setText(uname);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}