package com.expensereimbursementspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expensereimbursementspring.entities.FinalExpensesEntity;

public interface FinalExpensesDao extends JpaRepository<FinalExpensesEntity, Integer>{

}
