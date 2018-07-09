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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class classes {

	@Autowired
    ClassService classService;

	private static final String tstSId = "dca81f5a-1d99-491a-85fb-ad9591d4b96d";
	private static final int tstId = 65;

	@Test
	public void getAllClassOfCourses(){
        List<ClassOfCourse> classList = classService.getAllClasses();
        assertEquals(classList.size(),84);
        assertTrue(checkValues(classList.get(tstId - 1)));
	}

    @Test
    public void getClassOfCourseById(){
        ClassOfCourse c = classService.getClassById(tstId);
        assertTrue(checkValues(c));
    }

    @Test
    public void getClassOfCourseBySourcedId(){
        ClassOfCourse c = classService.getBySourcedId(tstSId);
        assertTrue(checkValues(c));
    }

    @Test
    public void testFailedSearch(){
	    try {
            ClassOfCourse c = classService.getClassById(300);
            fail("NP Exception expected");
        } catch (Exception e){
	        // pass
        }
    }

    private static boolean checkValues(ClassOfCourse testObject){

	    ClassOfCourse refObject = new ClassOfCourse();
	    refObject.setClassId(tstId);
	    refObject.setCourseId("7975b9f6-2ba5-4d93-bcf6-57137edcff07");
	    refObject.setSchoolId("f9a75f84-130b-419e-bbe6-463585e930e9");
	    refObject.setClassCode("Physics II - Fall");
	    refObject.setClassType("scheduled");
	    refObject.setDateLastModified("2017-11-10 03:07:57");
	    refObject.setSourcedId(tstSId);
	    refObject.setStatus("active");
	    refObject.setLocation("212");
	    refObject.setPeriods("2");
	    refObject.setTerm("Fall");
	    refObject.setMetadata("");

	    return (testObject.equals(refObject));

    }

}
