package com.itp.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itp.springboot.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>{

}
