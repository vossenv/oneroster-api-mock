package com.dm.onerosterapi.service;

import com.dm.onerosterapi.exceptions1.SchoolNotFoundException;
import com.dm.onerosterapi.model.School;
import com.dm.onerosterapi.service.interfaces.SchoolService;
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
public class schools {

	@Autowired
    SchoolService schoolService;

    private static final String tstSId = "f9a75f84-130b-419e-bbe6-463585e930e9";
    private static final String tstId = "1";

    @Test
    public void getSchoolBySourcedId() throws SchoolNotFoundException {
        assertTrue(checkValues(schoolService.getBySourcedId(tstSId)));
    }

    @Test
	public void getAllSchools() throws SchoolNotFoundException {
        List<School> schoolList = schoolService.getAllSchools();
        assertEquals(schoolList.size(),2);
        assertTrue(checkValues(schoolList.get(0)));
	}

    @Test
    public void testFailedSearch(){
        try {
            School o = schoolService.getBySourcedId("12");
            fail("NP Exception expected");
        } catch (SchoolNotFoundException e){
            // pass
        }
    }

    private static boolean checkValues(School testObject){

        School refObject = new School();

        refObject.setSourcedId(tstSId);
        refObject.setSchoolId(tstId);
        refObject.setDateLastModified("2018-03-28 13:06:43");
        refObject.setStatus("active");
        refObject.setMetadata("");
        refObject.setName("Spring Valley Elementary School");
        refObject.setIdentifier("LwX0-f4Zc-O393");
        refObject.setType("school");

        return (testObject.equals(refObject));

    }

}
