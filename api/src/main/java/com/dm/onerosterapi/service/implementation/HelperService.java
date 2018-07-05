package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.model.User;
import com.dm.onerosterapi.service.interfaces.CourseService;
import com.dm.onerosterapi.service.interfaces.EnrollmentService;
import com.dm.onerosterapi.service.interfaces.SchoolService;
import com.dm.onerosterapi.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelperService {


    @Autowired SchoolService schoolService;
    @Autowired ClassServiceImpl classService;
    @Autowired UserService userService;
    @Autowired CourseService courseService;
    @Autowired EnrollmentService enrollmentService;



    public Object idFieldSwap(Object o){

        String [] temp = o.getClass().toString().split("[.]");

        switch (temp[temp.length - 1]){

            case "User":
                ((User) o).setSchoolId(schoolService.getSchoolById(Integer.parseInt(((User) o).getSchoolId())).getSourcedId());
                break;

        }

        return o;
    }



}
