package tech.sushnag22.attendancemanager.controllers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import tech.sushnag22.attendancemanager.R;
import tech.sushnag22.attendancemanager.models.Student;
import tech.sushnag22.attendancemanager.views.ViewStudentDetailsActivity;

public class StudentListAdapter extends RecyclerView.Adapter
        <StudentListAdapter.ViewHolder> {

    private final List<Student> studentList;

    public StudentListAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View customView = inflater.inflate(R.layout.view_student_list,
                parent, false);
        return new ViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StudentListAdapter.ViewHolder holder,
                                 int position) {
        Student student = studentList.get(position);

        TextView roll_no = holder.rollTextView;
        TextView name = holder.nameTextView;

        roll_no.setText(student.getStudent_usn());
        String fullName = student.getStudent_firstname() + " " + student.getStudent_lastname();
        name.setText(fullName);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(),
                    ViewStudentDetailsActivity.class);
            intent.putExtra("usn", student.getStudent_usn());
            holder.itemView.getContext().startActivity(intent);
        });

        holder.itemView.setOnLongClickListener(v -> {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog
                    .Builder(holder.itemView.getContext());

            alertDialogBuilder.setTitle("Delete Student");
            alertDialogBuilder.setMessage("Are you sure want to delete?");

            alertDialogBuilder.setPositiveButton("Yes", (dialog, id) -> {

                studentList.remove(position);
                notifyDataSetChanged();

                DbHandler dbHandler = new DbHandler(holder.itemView.getContext());
                dbHandler.deleteStudent(student.getStudent_usn());
            });

            alertDialogBuilder.setNegativeButton("No", (dialog, id) -> dialog.cancel());

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            return false;
        });

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public TextView rollTextView;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            rollTextView = itemView.findViewById(R.id.label_stu_usn);
            nameTextView = itemView.findViewById(R.id.label_stu_name);

        }

    }

}
