package com.dm.onerosterapi.service;

import com.dm.onerosterapi.exceptions.*;
import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.service.interfaces.ClassService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class exceptions {

    @Autowired
    ClassService classService;

    @Autowired
    private static final String classId = "dca81f5a-1d99-491a-85fb-ad9591d4b96d";
    private static final String studentId = "8057df9d-72a3-419a-98b5-6eab87ec0a6d";
    private static final String teacherId = "f1e4b385-b0c9-4054-ad08-95c580ac715d";
    private static final String courseId = "2441eeb2-4df0-4726-a882-f0e722d129c6";
    private static final String enrollmentId = "44e3d2cf-af91-4e2f-a5ec-5e304b5a66cb";
    private static final String school = "f9a75f84-130b-419e-bbe6-463585e930e9";

    @Test
    public void UserExceptions() {

        //try {





    }


}
