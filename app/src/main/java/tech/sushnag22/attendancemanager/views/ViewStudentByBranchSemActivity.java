package tech.sushnag22.attendancemanager.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import tech.sushnag22.attendancemanager.R;
import tech.sushnag22.attendancemanager.controllers.DbHandler;
import tech.sushnag22.attendancemanager.controllers.StudentListAdapter;
import tech.sushnag22.attendancemanager.models.Student;

public class ViewStudentByBranchSemActivity extends AppCompatActivity {

    ArrayList<Student> studentList;
    String branch;
    String semester;
    DbHandler dbHandler = new DbHandler(this);
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_layout);

        branch = getIntent().getExtras().getString("branch");
        semester = getIntent().getExtras().getString("sem");

        TextView titleTextView = findViewById(R.id.textView_title);
        titleTextView.setText(R.string.STUDENT_LIST);
        RecyclerView recyclerView = findViewById(R.id.main_recycler_view);
        this.studentList = dbHandler.getAllStudentByBranchSem(branch, semester);

        StudentListAdapter adapter = new StudentListAdapter(studentList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}