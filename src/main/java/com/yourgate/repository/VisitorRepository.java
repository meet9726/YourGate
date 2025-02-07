package com.yourgate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourgate.entity.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {

}
