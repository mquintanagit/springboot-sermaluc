package com.example.springbootsermaluc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootsermaluc.models.FormulaClase;
import com.example.springbootsermaluc.models.VariablesClase;
import com.example.springbootsermaluc.repositories.FormulaRepository;
import com.example.springbootsermaluc.repositories.VariablesRepository;
import com.example.springbootsermaluc.service.ExcelService;
import com.example.springbootsermaluc.service.FormulaService;

@RestController
@RequestMapping("/api")
public class ExcelController {
    @Autowired
    private FormulaRepository formulaRepository;

    @Autowired
    private VariablesRepository variablesRepository;

    @Autowired
    private FormulaService formulaService;

    @Autowired
    private ExcelService excelService;

    @GetMapping("/formula")
    public List<FormulaClase> getFormulas() {
        return formulaRepository.findAll();
    }

    @GetMapping("/variables")
    public List<VariablesClase> getVariables() {
        return variablesRepository.findAll();
    }

    @GetMapping("/calcular")
    public String calcularYGuardarResultados() {
        formulaService.calcularYGuardarResultados();
        return "Resultados calculados y guardados correctamente.";
    }

    
}
