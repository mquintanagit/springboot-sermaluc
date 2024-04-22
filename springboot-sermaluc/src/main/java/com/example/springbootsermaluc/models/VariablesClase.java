package com.example.springbootsermaluc.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "variables")
public class VariablesClase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idunico;
    private String idcomuna;
    private String componente;
    private Double valor;
    
    // CONSTRUCTORES.
    public VariablesClase() {
    }

    public VariablesClase(int idunico, String idcomuna, String componente, Double valor) {
        this.idunico = idunico;
        this.idcomuna = idcomuna;
        this.componente = componente;
        this.valor = valor;
    }

    // GETTERS Y SETTERS.
    public String getIdcomuna() {
        return idcomuna;
    }

    public void setIdcomuna(String idcomuna) {
        this.idcomuna = idcomuna;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    

    public int getIdunico() {
        return idunico;
    }

    public void setIdunico(int idunico) {
        this.idunico = idunico;
    }
}


