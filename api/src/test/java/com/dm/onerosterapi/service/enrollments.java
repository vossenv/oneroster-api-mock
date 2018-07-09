package com.dm.onerosterapi.service;

import com.dm.onerosterapi.model.ClassOfCourse;
import com.dm.onerosterapi.model.Course;
import com.dm.onerosterapi.model.Enrollment;
import com.dm.onerosterapi.service.interfaces.EnrollmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class enrollments {

	@Autowired
    EnrollmentService enrollmentService;

    private static final String tstSId = "44e3d2cf-af91-4e2f-a5ec-5e304b5a66cb";
    private static final int tstId = 650;

	@Test
	public void getAllEnrollments(){
        List<Enrollment> enrollmentList = enrollmentService.getAllEnrollments();
        assertEquals(enrollmentList.size(),4200);
        assertTrue(checkValues(enrollmentList.get(tstId - 1)));
	}

    @Test
    public void getEnrollmentById(){
        Enrollment e = enrollmentService.getEnrollmentById(tstId);
        assertTrue(checkValues(e));
    }

    @Test
    public void testFailedSearch(){
        try {
            Enrollment e = enrollmentService.getEnrollmentById(-1);
            fail("NP Exception expected");
        } catch (Exception e){
            // pass
        }
    }

    private static boolean checkValues(Enrollment testObject){

        Enrollment refObject = new Enrollment();

        refObject.setSourcedId(tstSId);
        refObject.setEnrollmentId(tstId);
        refObject.setDateLastModified("2018-03-14 13:09:21");
        refObject.setStatus("active");
        refObject.setMetadata("");
        refObject.setUserId("c02e2840-4c30-45cc-9731-49cad24a85eb");
        refObject.setClassId("85e59186-32d7-464e-8edb-c6149a54c068");
        refObject.setPrimary("FALSE");
        refObject.setBeginDate("2019-01-15 00:00:00");
        refObject.setEndDate("2019-06-30 00:00:00");


        return (testObject.equals(refObject));

    }

}
