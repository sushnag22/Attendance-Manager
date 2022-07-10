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
import tech.sushnag22.attendancemanager.controllers.AttendanceCountAdapter;
import tech.sushnag22.attendancemanager.models.Attendance;

public class ViewAttendancePerStudentActivity extends AppCompatActivity {

    ArrayList<Attendance> attendanceBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_layout);

        TextView titleTextView = findViewById(R.id.textView_title);
        titleTextView.setText(R.string.ATTENDANCE_REPORT);
        RecyclerView recyclerView = findViewById(R.id.main_recycler_view);

        attendanceBeanList = ((AppContext) this.getApplicationContext()).getAttendanceList();

        AttendanceCountAdapter adapter = new AttendanceCountAdapter(attendanceBeanList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }
}