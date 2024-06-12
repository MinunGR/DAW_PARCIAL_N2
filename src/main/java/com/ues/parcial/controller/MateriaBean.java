/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ues.parcial.controller;

import com.ues.parcial.service.MateriaDataService;
import com.ues.parcial.entity.Materia;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando
 */
@Named("cMateria")
@ViewScoped
public class MateriaBean implements Serializable{

    // Acceso a datos
    @EJB(beanName = "MateriaService")
    private MateriaDataService daoMateria;

    // Listado de materias
    private List<Materia> materiasList;
    // Entidades
    private Materia materia;

    public List<Materia> getMateriasList() {
        this.materiasList = this.daoMateria.findAll();
        return materiasList;
    }

    public void setMateriasList(List<Materia> materiasList) {
        this.materiasList = materiasList;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @PostConstruct
    public void init() {
        this.materia = new Materia();
    }

    public void refresh() {
        this.materiasList = this.daoMateria.findAll();
        System.out.println("LLEGOO");
    }

    public void guardarMateria() {
        if (materia.getId() != null) {
            this.daoMateria.edit(materia);
        } else {
            this.daoMateria.create(materia);
        }
        this.refresh();
        this.init();
    }

    public void cargarMateria(Materia materia) {
        this.materia = materia;
    }

    public void eliminarMateria(Materia materia) {
        this.daoMateria.remove(materia);
        this.refresh();
    }

}
