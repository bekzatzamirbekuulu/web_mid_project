package com.example.demo;

import com.example.demo.form.LoginForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repos extends JpaRepository<LoginForm, Integer> {
}
