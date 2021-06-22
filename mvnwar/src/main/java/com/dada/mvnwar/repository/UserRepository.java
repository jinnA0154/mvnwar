package com.dada.mvnwar.repository;

import com.dada.mvnwar.model.Board;
import com.dada.mvnwar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
