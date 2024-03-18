package com.infenia.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infenia.oms.entity.Organization;

public interface OrganizationRepository extends JpaRepository< Organization, Long> {

}
