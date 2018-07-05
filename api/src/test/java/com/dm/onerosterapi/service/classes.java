package com.dm.onerosterapi.service;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.service.interfaces.ClassService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class classes {

	@Autowired
    ClassService classService;

	@Test
	public void getAllClassOfCourses(){

        List<ClassOfCourse> classList = classService.getAllClasses();
        assertEquals(classList.size(),84);

	}

    @Test
    public void getClassOfCourseById(){

        ClassOfCourse c = classService.getClassById(65);
        assertEquals(c.getClassId(),65);
        assertEquals(c.getSourcedId(), "dca81f5a-1d99-491a-85fb-ad9591d4b96d");

    }

}
