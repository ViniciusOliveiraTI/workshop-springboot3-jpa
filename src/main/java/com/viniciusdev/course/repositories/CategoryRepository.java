package com.viniciusdev.course.repositories;

import com.viniciusdev.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
