package com.globant.bootcamp;

import java.sql.SQLException;
import java.sql.ResultSet;


public class HighSchoolService {
    
    public static final Course NULL_COURSE = new Course();
    
    public Course findCourse(String id) {
        Course course = NULL_COURSE;
        String query = String.format("select * from course join teacher on course.teacher_id = teacher.id where course.id = %s;", id);
        try {
            ResultSet rs = MySQLConnection.getInstance().run(query);
            course = new Course();
            course.setId(rs.getInt("id"));
            course.setName(rs.getString("course_name"));
            Teacher teacher = new Teacher();
            teacher.setFirstName(rs.getString("first_name"));
            teacher.setSecondName(rs.getString("last_name"));
            course.setTeacher(teacher);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return course;
    }
}
