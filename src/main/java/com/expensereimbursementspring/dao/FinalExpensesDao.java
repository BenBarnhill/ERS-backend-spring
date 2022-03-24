package com.expensereimbursementspring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expensereimbursementspring.entities.FinalExpensesEntity;

@Repository
public interface FinalExpensesDao extends JpaRepository<FinalExpensesEntity, Integer>{

	// SELECT * FROM reimbursements_final WHERE final_request=empId
	List<FinalExpensesEntity> findByEmpId(int empId);
}
