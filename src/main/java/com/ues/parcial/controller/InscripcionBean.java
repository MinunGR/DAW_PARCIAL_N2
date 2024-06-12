/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ues.parcial.controller;

import com.ues.parcial.service.InscripcionDataService;
import com.ues.parcial.entity.Inscripcion;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Fernando
 */
@Named("cInscripcion")
@ViewScoped
public class InscripcionBean implements Serializable{

    // Acceso a datos
    @EJB(beanName = "InscripcionService")
    private InscripcionDataService daoInscripcion;

    // Listado de inscripciones
    private List<Inscripcion> inscripcionesList;
    // Entidades
    private Inscripcion inscripcion;

    public List<Inscripcion> getInscripcionsList() {
        this.inscripcionesList = this.daoInscripcion.findAll();
        return inscripcionesList;
    }

    public void setInscripcionsList(List<Inscripcion> inscripcionesList) {
        this.inscripcionesList = inscripcionesList;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    @PostConstruct
    public void init() {
        this.inscripcion = new Inscripcion();
    }

    public void refresh() {
        this.inscripcionesList = this.daoInscripcion.findAll();
    }

    public void guardarInscripcion() {
        if (inscripcion.getId() != null) {
            this.daoInscripcion.edit(inscripcion);
        } else {
            this.daoInscripcion.create(inscripcion);
        }
        this.refresh();
        this.init();
    }

    public void cargarInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public void eliminarInscripcion(Inscripcion inscripcion) {
        this.daoInscripcion.remove(inscripcion);
        this.refresh();
    }

}
