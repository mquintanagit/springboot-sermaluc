package com.example.springbootsermaluc.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "formula")
public class FormulaClase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idunico;
    private String idcomuna;
    private String nombreempresa;
    private String nombrecomuna;
    private String subnombre;
    private Integer idtarifa;
    private String nombretarifa;
    private String formula;
    private String descripcion;
    private Double resultado;
    

    // CONSTRUCTORES.
    public FormulaClase() {
    }

    public FormulaClase(int idunico, String idcomuna, String nombreempresa, String nombrecomuna, String subnombre, Integer idtarifa,
            String nombretarifa, String formula, String descripcion, Double resultado) {
        this.idunico = idunico;
        this.idcomuna = idcomuna;
        this.nombreempresa = nombreempresa;
        this.nombrecomuna = nombrecomuna;
        this.subnombre = subnombre;
        this.idtarifa = idtarifa;
        this.nombretarifa = nombretarifa;
        this.formula = formula;
        this.descripcion = descripcion;
        this.resultado = resultado;
    }

    // GETTERS Y SETTERS.
    
    public int getIdunico() {
        return idunico;
    }

    public void setIdunico(int idunico) {
        this.idunico = idunico;
    }
    
    public String getIdcomuna() {
        return idcomuna;
    }

    public void setIdcomuna(String idcomuna) {
        this.idcomuna = idcomuna;
    }

    public String getNombreempresa() {
        return nombreempresa;
    }

    public void setNombreempresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
    }

    public String getNombrecomuna() {
        return nombrecomuna;
    }

    public void setNombrecomuna(String nombrecomuna) {
        this.nombrecomuna = nombrecomuna;
    }

    public String getSubnombre() {
        return subnombre;
    }

    public void setSubnombre(String subnombre) {
        this.subnombre = subnombre;
    }

    public Integer getIdtarifa() {
        return idtarifa;
    }

    public void setIdtarifa(Integer idtarifa) {
        this.idtarifa = idtarifa;
    }

    public String getNombretarifa() {
        return nombretarifa;
    }

    public void setNombretarifa(String nombretarifa) {
        this.nombretarifa = nombretarifa;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    
}
