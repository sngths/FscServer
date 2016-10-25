package entity.info;

import java.util.ArrayList;

/**
 * Created by tianxing on 16/8/31.
 * 班级信息 其中包含学生信息列表
 */
public class ClassInfo {

    private String name = "";//班级名称
    private String title = "";//班级标题
    private ArrayList<StudentInfo> students = new ArrayList<>();


    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<StudentInfo> getStudents() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addStudentInfo(StudentInfo studentInfo){
        students.add(studentInfo);
    }
}
