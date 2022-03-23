package com.expensereimbursementspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expensereimbursementspring.entities.AdminEntity;

@Repository
public interface AdminDao extends JpaRepository<AdminEntity, Integer> {

	// SELECT * FROM admin_details where admin_email=userEmail;
	AdminEntity findAdminByEmail(String userEmail);
}
