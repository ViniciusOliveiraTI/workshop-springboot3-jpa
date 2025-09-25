package com.viniciusdev.course.repositories;

import com.viniciusdev.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository (opcional)
public interface UserRepository extends JpaRepository<User, Long> {

}
