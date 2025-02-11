package com.yourgate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourgate.entity.Complaint;

public interface ComplaintRepository  extends JpaRepository<Complaint, Long>{

}
