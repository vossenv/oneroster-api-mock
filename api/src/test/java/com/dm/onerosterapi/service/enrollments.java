package com.dm.onerosterapi.service;

import com.dm.onerosterapi.exceptions.ClassOfCourseNotFoundException;
import com.dm.onerosterapi.exceptions.EnrollmentNotFoundException;
import com.dm.onerosterapi.exceptions.SchoolNotFoundException;
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
    private static final String tstId = "650";

    @Test
    public void getEnrollmentBySourcedId() throws EnrollmentNotFoundException {
        assertTrue(checkValues(enrollmentService.getBySourcedId(tstSId)));
    }

	@Test
	public void getAllEnrollments() throws EnrollmentNotFoundException {
        List<Enrollment> enrollmentList = enrollmentService.getAllEnrollments();
        assertEquals(enrollmentList.size(),4200);
        assertTrue(checkValues(enrollmentList.get(649)));
	}

	@Test
    public void getEnrollmentsForSchool() throws EnrollmentNotFoundException, SchoolNotFoundException {
        List<Enrollment> enrollmentList = enrollmentService.getEnrollmentsForSchool("f9a75f84-130b-419e-bbe6-463585e930e9");
        assertEquals(enrollmentList.size(),2076);

        enrollmentList = enrollmentService.getEnrollmentsForSchool("f5897384-9488-466f-b049-1992f7a53f15");
        assertEquals(enrollmentList.size(),2124);

    }

    @Test
    public void getEnrollmentsForClassInSchool() throws
            EnrollmentNotFoundException,
            ClassOfCourseNotFoundException,
            SchoolNotFoundException {

        String schoolId = "f9a75f84-130b-419e-bbe6-463585e930e9";
        String classId = "2ba9f25c-ef54-4072-85ab-2db066988091";

        List<Enrollment> enrollmentList = enrollmentService.getEnrollmentsForClassInSchool(classId,schoolId);
        assertEquals(enrollmentList.size(),47);
    }


    @Test
    public void testFailedSearch(){
        try {
            Enrollment e = enrollmentService.getBySourcedId("-1");
            fail("NP Exception expected");
        } catch (EnrollmentNotFoundException e){
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
