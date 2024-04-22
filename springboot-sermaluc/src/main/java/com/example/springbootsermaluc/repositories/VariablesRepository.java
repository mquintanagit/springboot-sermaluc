package com.example.springbootsermaluc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootsermaluc.models.VariablesClase;

@Repository
public interface VariablesRepository extends JpaRepository<VariablesClase, Integer> {
    List<VariablesClase> findByidcomuna(String idcomuna);
}
