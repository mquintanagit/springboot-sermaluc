package com.example.springbootsermaluc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springbootsermaluc.models.FormulaClase;

@Repository
public interface FormulaRepository extends JpaRepository<FormulaClase, Integer> {

}

