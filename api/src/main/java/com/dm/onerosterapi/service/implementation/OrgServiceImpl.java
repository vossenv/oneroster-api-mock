package com.dm.onerosterapi.service.implementation;

import com.dm.onerosterapi.model.Org;
import com.dm.onerosterapi.repository.dao.RosterDao;
import com.dm.onerosterapi.repository.jpa.OrgRepository;
import com.dm.onerosterapi.service.interfaces.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {

    @Autowired RosterDao rosterDao;
    @Autowired OrgRepository orgRepository;

    @Override
    public Org getOrgById(int orgId) {
        return orgRepository.findByOrgId(orgId);
    }

    @Override
    public List<Org> getAllOrgs() {
        return orgRepository.findAll();
    }

}
