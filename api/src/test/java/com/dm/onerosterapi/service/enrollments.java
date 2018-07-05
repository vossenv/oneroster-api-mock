package com.dm.onerosterapi.service;

import com.dm.onerosterapi.model.Enrollment;
import com.dm.onerosterapi.service.interfaces.EnrollmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class enrollments {

	@Autowired
    EnrollmentService enrollmentService;

	@Test
	public void getAllEnrollments(){

        List<Enrollment> enrollmentList = enrollmentService.getAllEnrollments();
        assertEquals(enrollmentList.size(),4200);

	}

    @Test
    public void getEnrollmentById(){

        Enrollment e = enrollmentService.getEnrollmentById(650);

        assertEquals(e.getEnrollmentId(),650);
        assertEquals(e.getSourcedId(), "44e3d2cf-af91-4e2f-a5ec-5e304b5a66cb");

    }

}
