package tech.sushnag22.attendancemanager.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import java.util.ArrayList;

import tech.sushnag22.attendancemanager.R;
import tech.sushnag22.attendancemanager.context.AppContext;
import tech.sushnag22.attendancemanager.controllers.StudentAttendanceAdapter;
import tech.sushnag22.attendancemanager.models.Student;

public class AddAttendanceActivity extends AppCompatActivity {

    ArrayList<Student> studentBeanList;
    int sessionId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_layout);

        sessionId = getIntent().getExtras().getInt("sessionId");

        TextView titleTextView = findViewById(R.id.textView_title);
        titleTextView.setText(R.string.ADD_ATTENDANCE);
        RecyclerView recyclerView = findViewById(R.id.main_recycler_view);
        studentBeanList = ((AppContext) AddAttendanceActivity.this
                .getApplicationContext()).getStudentList();

        StudentAttendanceAdapter adapter = new StudentAttendanceAdapter(studentBeanList, sessionId);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}