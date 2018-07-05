package com.dm.onerosterapi.service.interfaces;

import com.dm.onerosterapi.model.*;

import java.util.List;

public interface OrgService {

    public Org getOrgById(int orgId);
    public List<Org> getAllOrgs();

}
