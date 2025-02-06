package com.yourgate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourgate.entity.Roles;

public interface RoleRepository  extends JpaRepository<Roles,Long>{

}
