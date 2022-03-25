package com.expensereimbursementspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expensereimbursementspring.entities.FileEntity;


@Repository
public interface FileDao extends JpaRepository<FileEntity, Integer> {

}
