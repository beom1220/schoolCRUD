package service;

import user.Student;
import user.Teacher;
import viewer.DefaultViewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListTeacherManagement {
    private List<Teacher> teacherList = new ArrayList<>();
    private DefaultViewer dv = new DefaultViewer();
    public boolean checkRedundancyId(String id) {
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getId().equals(id)) {
                dv.redundancyIdMessage();
                return true;
            }
        }
        return false;
    }
    public List<Teacher> getTeacherList() {
        return teacherList;
    }
    public void addTeacher(Teacher teacher) {
        teacherList.add(teacher);
    }
}
