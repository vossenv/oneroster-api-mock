package com.dm.onerosterapi.service;

import com.dm.onerosterapi.model.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class courses {

	@Autowired
	RosterService rosterService;

	@Test
	public void getAllCourses(){

        List<Course> courseList = rosterService.getAllCourses();
        assertEquals(courseList.size(),42);

	}

    @Test
    public void getCourseById(){

        Course c = rosterService.getCourseById(11);
        assertEquals(c.getCourseId(),11);
        assertEquals(c.getSourcedId(), "2441eeb2-4df0-4726-a882-f0e722d129c6");

    }

}
