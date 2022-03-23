package com.expensereimbursementspring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensereimbursementspring.dao.AdminDao;
import com.expensereimbursementspring.entities.AdminEntity;
import com.expensereimbursementspring.pojo.UserPojo;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adminDao;

	@Override
	public UserPojo fetchAdmin(int adminId) {
		Optional<AdminEntity> optional = adminDao.findById(adminId);
		UserPojo userPojo = null;
		if(optional.isPresent()) {
			AdminEntity adminEntity = optional.get();
			userPojo = new UserPojo(adminEntity.getAdminId(), adminEntity.getAdminPassword(), adminEntity.getAdminFirstName(), adminEntity.getAdminLastName(), adminEntity.getAdminContact(), adminEntity.getAdminEmail(), adminEntity.getAdminAddress(), adminEntity.getAdminRole());
		}
		return userPojo;
		
	}

	@Override
	public UserPojo loginAdmin(UserPojo userIn) {
		UserPojo loginPojo = new UserPojo(0, "","","",0,"","","");
		AdminEntity adminEntity = adminDao.findAdminByEmail(userIn.getUserEmail());
		UserPojo fetchedPojo = new UserPojo(adminEntity.getAdminId(), adminEntity.getAdminPassword(), adminEntity.getAdminFirstName(), adminEntity.getAdminLastName(), adminEntity.getAdminContact(), adminEntity.getAdminEmail(), adminEntity.getAdminAddress(), adminEntity.getAdminRole());
		if(fetchedPojo.getUserPassword().equals(userIn.getUserPassword())) {
			loginPojo = fetchedPojo;
		}
		return loginPojo;
	}

}
