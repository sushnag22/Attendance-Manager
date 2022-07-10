package tech.sushnag22.attendancemanager.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import java.util.ArrayList;

import tech.sushnag22.attendancemanager.R;
import tech.sushnag22.attendancemanager.controllers.DbHandler;
import tech.sushnag22.attendancemanager.controllers.FacultyListAdapter;
import tech.sushnag22.attendancemanager.models.Faculty;

public class ViewFacultyActivity extends AppCompatActivity {

    ArrayList<Faculty> facultyBeanList;
    DbHandler dbHandler = new DbHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_layout);

        TextView titleTextView = findViewById(R.id.textView_title);
        titleTextView.setText(R.string.FACULTY_LIST);
        RecyclerView recyclerView = findViewById(R.id.main_recycler_view);
        this.facultyBeanList = dbHandler.getAllFaculty();

        FacultyListAdapter adapter = new FacultyListAdapter(facultyBeanList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}