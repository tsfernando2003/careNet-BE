package com.careNet.carenet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.careNet.carenet.demo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
