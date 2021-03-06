package com.expensereimbursementspring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensereimbursementspring.dao.AdminDao;
import com.expensereimbursementspring.entities.AdminEntity;
import com.expensereimbursementspring.exceptions.SystemException;
import com.expensereimbursementspring.pojo.AdminPojo;
import com.expensereimbursementspring.pojo.UserPojo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adminDao;

	@Override
	public AdminPojo fetchAdmin(int adminId) throws SystemException {
		log.info("Entered in fetchAdmin of AdminService");
		Optional<AdminEntity> optional = adminDao.findById(adminId);
		AdminPojo adminPojo = null;
		if(optional.isPresent()) {
			AdminEntity adminEntity = optional.get();
			adminPojo = new AdminPojo(adminEntity.getAdminId(), adminEntity.getAdminPassword(), adminEntity.getAdminFirstName(), adminEntity.getAdminLastName(), adminEntity.getAdminContact(), adminEntity.getAdminEmail(), adminEntity.getAdminAddress(), adminEntity.getAdminRole());
		}
		log.info("Exited fetchAdmin of AdminService");
		return adminPojo;
		
	}

	@Override
	public AdminPojo loginAdmin(AdminPojo pojoIn) throws SystemException {
		log.info("Entered in loginAdmin of AdminService");
		AdminPojo loginPojo = new AdminPojo(0, "","","",0,"","","");
		AdminEntity adminEntity = adminDao.findByAdminEmail(pojoIn.getAdminEmail());
		AdminPojo fetchedPojo = new AdminPojo(adminEntity.getAdminId(), adminEntity.getAdminPassword(), adminEntity.getAdminFirstName(), adminEntity.getAdminLastName(), adminEntity.getAdminContact(), adminEntity.getAdminEmail(), adminEntity.getAdminAddress(), adminEntity.getAdminRole());
		if(fetchedPojo.getAdminPassword().equals(pojoIn.getAdminPassword())) {
			loginPojo = fetchedPojo;
		}
		log.info("Exited loginAdmin of AdminService");
		return loginPojo;
	}

}
