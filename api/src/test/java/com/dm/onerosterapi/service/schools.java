package com.dm.onerosterapi.service;

import com.dm.onerosterapi.model.School;
import com.dm.onerosterapi.service.interfaces.SchoolService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class schools {

	@Autowired
    SchoolService schoolService;

	@Test
	public void getAllSchools(){

        List<School> schoolList = schoolService.getAllSchools();
        assertEquals(schoolList.size(),2);

	}

    @Test
    public void getSchoolById(){

        School o = schoolService.getSchoolById(1);
        assertEquals(o.getSchoolId(),1);
        assertEquals(o.getSourcedId(), "f9a75f84-130b-419e-bbe6-463585e930e9");

    }

}
