package tech.sushnag22.attendancemanager.models;

public class Attendance {

    private int attendance_session_id;
    private String attendance_student_usn;
    private String attendance_status;
    private String attendance_date;

    public int getAttendance_session_id() {
        return attendance_session_id;
    }

    public void setAttendance_session_id(int attendance_session_id) {
        this.attendance_session_id = attendance_session_id;
    }

    public String getAttendance_student_usn() {
        return attendance_student_usn;
    }

    public void setAttendance_student_usn(String attendance_student_usn) {
        this.attendance_student_usn = attendance_student_usn;
    }

    public String getAttendance_status() {
        return attendance_status;
    }

    public void setAttendance_status(String attendance_status) {
        this.attendance_status = attendance_status;
    }

    public String getAttendance_date() {
        return attendance_date;
    }

    public void setAttendance_date(String attendance_date) {
        this.attendance_date = attendance_date;
    }
}
