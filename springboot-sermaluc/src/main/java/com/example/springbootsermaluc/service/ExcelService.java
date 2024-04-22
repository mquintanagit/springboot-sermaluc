package com.example.springbootsermaluc.service;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.springbootsermaluc.models.FormulaClase;
import com.example.springbootsermaluc.models.VariablesClase;
import com.example.springbootsermaluc.repositories.FormulaRepository;
import com.example.springbootsermaluc.repositories.VariablesRepository;

@Service
public class ExcelService {

    @Autowired
    private FormulaRepository formulaRepository;

    @Autowired
    private VariablesRepository variablesRepository;

    public byte[] generateExcel() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet formulaSheet = workbook.createSheet("FORMULA");
        Sheet variablesSheet = workbook.createSheet("VARIABLES");

        List<FormulaClase> formulas = formulaRepository.findAll();
        List<VariablesClase> variables = variablesRepository.findAll();

        writeFormulaData(formulaSheet, formulas);
        writeVariablesData(variablesSheet, variables);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        return outputStream.toByteArray();
    }

    private void writeFormulaData(Sheet sheet, List<FormulaClase> formulas) {
        for (int i = 0; i < formulas.size(); i++) {
            Row row = sheet.createRow(i);
            FormulaClase formula = formulas.get(i);
            row.createCell(0).setCellValue(formula.getIdunico());
            row.createCell(1).setCellValue(formula.getIdcomuna());
            row.createCell(2).setCellValue(formula.getNombreempresa());
            row.createCell(3).setCellValue(formula.getNombrecomuna());
            row.createCell(4).setCellValue(formula.getSubnombre());
            row.createCell(5).setCellValue(formula.getIdtarifa());
            row.createCell(6).setCellValue(formula.getNombretarifa());
            row.createCell(7).setCellValue(formula.getFormula());
            row.createCell(8).setCellValue(formula.getDescripcion());
            row.createCell(9).setCellValue(formula.getResultado());


        }
    }

    private void writeVariablesData(Sheet sheet, List<VariablesClase> variables) {
        for (int i = 0; i < variables.size(); i++) {
            Row row = sheet.createRow(i);
            VariablesClase variable = variables.get(i);
            row.createCell(0).setCellValue(variable.getIdunico());
            row.createCell(1).setCellValue(variable.getIdcomuna());
            row.createCell(2).setCellValue(variable.getComponente());
            row.createCell(3).setCellValue(variable.getValor());
        }
    }
}
