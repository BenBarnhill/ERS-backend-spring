package com.expensereimbursementspring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expensereimbursementspring.entities.PendingExpensesEntity;
import com.expensereimbursementspring.pojo.ExpensePojo;


@Repository
public interface PendingExpensesDao extends JpaRepository<PendingExpensesEntity, Integer>{

	// SELECT * FROM reimbursements_pending WHERE pend_request=empId
	List<PendingExpensesEntity> findByEmpId(int empId);
}
