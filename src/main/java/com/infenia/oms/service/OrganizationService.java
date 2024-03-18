package com.infenia.oms.service;

import java.util.List;

import com.infenia.oms.entity.Organization;

public interface OrganizationService {

	Organization addOrganization(Organization organization);

	List<Organization> getAllOrg();

	void deleteOrg(Long id);

	
}
