package com.dm.onerosterapi.service;

import com.dm.onerosterapi.model.Org;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class orgs {

	@Autowired
	RosterService rosterService;

	@Test
	public void getAllOrgs(){

        List<Org> orgList = rosterService.getAllOrgs();
        assertEquals(orgList.size(),2);

	}

    @Test
    public void getOrgById(){

        Org o = rosterService.getOrgById(1);
        assertEquals(o.getOrgId(),1);
        assertEquals(o.getSourcedId(), "f9a75f84-130b-419e-bbe6-463585e930e9");

    }

}
