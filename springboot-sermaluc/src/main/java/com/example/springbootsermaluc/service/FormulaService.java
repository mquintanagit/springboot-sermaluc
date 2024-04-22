package com.example.springbootsermaluc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootsermaluc.models.FormulaClase;
import com.example.springbootsermaluc.models.VariablesClase;
import com.example.springbootsermaluc.repositories.FormulaRepository;
import com.example.springbootsermaluc.repositories.VariablesRepository;

import jakarta.transaction.Transactional;

import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

@Service
public class FormulaService {
    
    @Autowired
    private FormulaRepository formulaRepository;

    @Autowired
    private VariablesRepository variablesRepository;

    @Transactional
    public void calcularYGuardarResultados() {
        
        System.out.println("Método para calcular y guardar el resultado.");
        
        // OBTIENE LAS FORMULAS DE LA COLUMNA.
        List<FormulaClase> formulas = formulaRepository.findAll();
        for (FormulaClase formula : formulas) {
            String idcomuna = formula.getIdcomuna();

            List<VariablesClase> variables = variablesRepository.findByidcomuna(idcomuna);

            // OBTIENE LA FORMULA Y REEMPLAZA VARIABLES
            String formulaMatematica = formula.getFormula();
            for (VariablesClase variable : variables) {
                String nombreVariable = variable.getComponente();
                double valorVariable = variable.getValor();
                formulaMatematica = formulaMatematica.replaceAll(nombreVariable, Double.toString(valorVariable));
            }

            // REMPLAZAR ROUND POR MATHROUND.
            // formulaMatematica = formulaMatematica.replaceAll("\\bround\\(", "Math.round(");
            // formulaMatematica = formulaMatematica.replaceAll("bround\\", "");


            // Apache Commons Math
            try {
                double resultado = evaluarFormula(formulaMatematica);
                System.out.println("RESULTADO GUARDADO.");

                formula.setResultado(resultado);
                formulaRepository.save(formula);
            } catch (MathParseException | NumberIsTooLargeException | NoDataException | NotStrictlyPositiveException | OutOfRangeException | ZeroException e) {
                e.printStackTrace();
            }
        }
    }

    private double evaluarFormula(String formula) {
        try {

            formula = formula.replaceAll("\\bround\\(", "").replaceAll(";\\d+", "");
            
            List<VariablesClase> variables = variablesRepository.findAll();
            
            Map<String, Double> variableMap = new HashMap<>();
            for (VariablesClase variable : variables) {
                variableMap.put(variable.getComponente(), variable.getValor());
            }
            
            for (Map.Entry<String, Double> entry : variableMap.entrySet()) {
                String variableNombre = entry.getKey();
                Double variableValor = entry.getValue();

                System.out.println(variableNombre + " : "+ variableValor);

                formula = formula.replaceAll(variableNombre, variableValor.toString());
            }
            
            Expression expresion = new ExpressionBuilder(formula).build();
            double resultado = expresion.evaluate();
            
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
