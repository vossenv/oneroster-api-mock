package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.model.User;
import com.dm.onerosterapi.service.interfaces.CourseService;
import com.dm.onerosterapi.service.interfaces.EnrollmentService;
import com.dm.onerosterapi.service.interfaces.SchoolService;
import com.dm.onerosterapi.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HelperService {


    @Autowired SchoolService schoolService;
    @Autowired ClassServiceImpl classService;
    @Autowired UserService userService;
    @Autowired CourseService courseService;
    @Autowired EnrollmentService enrollmentService;


    public List<?> idFieldSwap(List<?> objectList){
        objectList.forEach(this::idFieldSwap);
        return objectList;
    }

    public Object idFieldSwap(Object o){

        switch (getClassName(o)){
            case "User":
                ((User) o).setSchoolId(schoolService.getSchoolById(Integer.parseInt(((User) o).getSchoolId())).getSourcedId());
                break;
        }

        return o;
    }

    private String getClassName(Object o){

        String [] temp = o.getClass().toString().split("[.]");
        return temp[temp.length - 1];

    }



}
