package entity.info;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianxing on 16/8/31.
 * 班级信息 其中包含学生信息列表
 */
public class ClassInfo extends GroupInfo{

    private String id;//班级名称
    private String name;//班级标题
    private String icon;//图标地址
    private List<StudentInfo> students;//班级所学生列表
    private List<TeacherInfo> teachers;//班级老是列表

    public ClassInfo(){
        students = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    /**
     * 添加一个学生
     * */
    public void add(StudentInfo student){
        getStudents().add(student);
    }

    /**
     * 添加一个老师
     * */
    public void add(TeacherInfo teacher){
        getTeachers().add(teacher);
    }

    private GroupInfo group;//班级对应的群组信息

    public List<StudentInfo> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<StudentInfo> students) {
        this.students = students;
    }

    public List<TeacherInfo> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherInfo> teachers) {
        this.teachers = teachers;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }




}
