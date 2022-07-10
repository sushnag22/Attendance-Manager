package tech.sushnag22.attendancemanager.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import tech.sushnag22.attendancemanager.R;
import tech.sushnag22.attendancemanager.controllers.DbHandler;
import tech.sushnag22.attendancemanager.models.Student;

public class ViewStudentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student_details);

        String Usn = getIntent().getExtras().getString("usn");

        TextView usnTextView = findViewById(R.id.lbl_stu_usn);
        TextView nameTextView = findViewById(R.id.lbl_stu_name);
        TextView branchTextView = findViewById(R.id.lbl_stu_branch);
        TextView semTextView = findViewById(R.id.lbl_stu_sem);
        TextView phoneTextView = findViewById(R.id.lbl_stu_mob_no);
        TextView emailTextView = findViewById(R.id.lbl_stu_email);

        DbHandler dbHandler = new DbHandler(this);

        try {
            Student student = dbHandler.getStudentByUsn(Usn);

            String usn = "USN : " + student.getStudent_usn();
            usnTextView.setText(Usn);

            String name = "NAME : " + student.getStudent_firstname() + " " + student.getStudent_lastname();
            nameTextView.setText(name);

            String branch = "BRANCH : " + student.getStudent_branch();
            branchTextView.setText(branch);

            String sem = "SEMESTER : " + student.getStudent_sem();
            semTextView.setText(sem);

            String phone = "PHONE : " + student.getStudent_mobile_number();
            phoneTextView.setText(phone);

            String email = "EMAIL : " + student.getStudent_email();
            emailTextView.setText(email);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

}