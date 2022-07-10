package tech.sushnag22.attendancemanager.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import tech.sushnag22.attendancemanager.R;
import tech.sushnag22.attendancemanager.context.AppContext;
import tech.sushnag22.attendancemanager.controllers.DbHandler;
import tech.sushnag22.attendancemanager.models.Attendance;

public class AdminDashboardActivity extends AppCompatActivity {

    Button addStudent;
    Button addFaculty;
    Button viewStudent;
    Button viewFaculty;
    Button logout;
//    Button attendancePerStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        addStudent = findViewById(R.id.add_student_btn);
        addFaculty = findViewById(R.id.add_faculty_btn);
//        attendancePerStudent = findViewById(R.id.manage_attendance_btn);
        viewStudent = findViewById(R.id.view_students_btn);
        viewFaculty = findViewById(R.id.view_faculty_btn);
        logout = findViewById(R.id.logout_btn);

        addStudent.setOnClickListener(v -> {
            Intent intent = new Intent(AdminDashboardActivity.this, AddStudentActivity.class);
            startActivity(intent);
        });

        addFaculty.setOnClickListener(v -> {
            Intent intent = new Intent(AdminDashboardActivity.this, AddFacultyActivity.class);
            startActivity(intent);
        });

        viewFaculty.setOnClickListener(v -> {
            Intent intent = new Intent(AdminDashboardActivity.this, ViewFacultyActivity.class);
            startActivity(intent);
        });

        viewStudent.setOnClickListener(v -> {
            Intent intent = new Intent(AdminDashboardActivity.this, SearchStudentActivity.class);
            startActivity(intent);
        });

        logout.setOnClickListener(v -> {
            Intent intent = new Intent(AdminDashboardActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            SharedPreferences prefs = getSharedPreferences("my-prefs", MODE_PRIVATE);
            SharedPreferences.Editor prefsEdit = prefs.edit();
            prefsEdit.clear();
            prefsEdit.apply();
            Toast.makeText(getApplicationContext(), "Logged out successfully.",
                    Toast.LENGTH_LONG).show();
            startActivity(intent);
        });

//        attendancePerStudent.setOnClickListener(v -> {
//
//            DbHandler dbHandler = new DbHandler(AdminDashboardActivity.this);
//            ArrayList<Attendance> attendanceBeanList = dbHandler.getAllAttendanceByStudent();
//            ((AppContext) this.getApplicationContext()).setAttendanceList(attendanceBeanList);
//
//            Intent intent = new Intent(AdminDashboardActivity.this,
//                    ViewAttendancePerStudentActivity.class);
//            startActivity(intent);
//
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        
    }

}