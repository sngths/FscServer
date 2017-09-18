package com.tianxing.webapi;

import com.tianxing.pojo.http.ResponseWrapper;
import com.tianxing.pojo.info.ClassInfo;
import com.tianxing.pojo.info.StudentInfo;
import com.tianxing.pojo.info.TeacherInfo;
import com.tianxing.webapi.controller.BaseController;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tianxing on 2017/4/26.
 * 提供各种信息查询
 */
@RestController
public class InfoController extends BaseController {


    /**
     * 查询一名老师的信息
     */
    @RequestMapping(value = "info/teacher", method = RequestMethod.GET)
    public ResponseWrapper teacherInfo(@RequestHeader(value = "token") String token,
                                       @RequestParam(value = "id") int id) throws Exception {
        TeacherInfo info = new TeacherInfo();


        return new ResponseWrapper(info);

    }


    /**
     * 查询一名学生的信息
     */
    @RequestMapping(value = "info/student", method = RequestMethod.GET)
    public ResponseWrapper studentInfo(@RequestHeader(value = "token") String token,
                                       @RequestParam(value = "id") int id) throws Exception {
        StudentInfo info = new StudentInfo();

        return new ResponseWrapper(info);

    }

    /**
     * 查询一个班级的信息
     */
    @RequestMapping(value = "info/class", method = RequestMethod.GET)
    public ResponseWrapper classInfo(@RequestHeader(value = "token") String token,
                                     @RequestParam(value = "id") int id) throws Exception {
        ClassInfo classInfo = new ClassInfo();

        return new ResponseWrapper(classInfo);

    }
}
