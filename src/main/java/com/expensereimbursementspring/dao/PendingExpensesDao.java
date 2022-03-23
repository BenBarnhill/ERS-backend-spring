package com.expensereimbursementspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expensereimbursementspring.entities.PendingExpensesEntity;

public interface PendingExpensesDao extends JpaRepository<PendingExpensesEntity, Integer>{

}
