/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ues.parcial.controller;

import com.ues.parcial.entity.Alumno;
import com.ues.parcial.service.InscripcionDataService;
import com.ues.parcial.entity.Inscripcion;
import com.ues.parcial.entity.Materia;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fernando
 */
@Named("cInscripcion")
@ViewScoped
public class InscripcionBean implements Serializable {

    // Acceso a datos
    @EJB(beanName = "InscripcionService")
    private InscripcionDataService daoInscripcion;

    // Listado de inscripciones
    private List<Inscripcion> inscripcionesList;
    // Entidades
    private Inscripcion inscripcion;
    private Alumno alumno;
    private Materia materia;

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public List<Inscripcion> getInscripcionesList() {
        this.inscripcionesList = this.daoInscripcion.findAll();
        return inscripcionesList;
    }

    public void setInscripcionesList(List<Inscripcion> inscripcionesList) {
        this.inscripcionesList = inscripcionesList;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @PostConstruct
    public void init() {
        this.inscripcion = new Inscripcion();
        this.inscripcion.setFechaInscripcion(new Date());
        this.alumno = new Alumno();
        this.materia = new Materia();
    }

    public void refresh() {
        this.inscripcionesList = this.daoInscripcion.findAll();
    }

    public void guardarInscripcion() {
        this.inscripcion.setAlumno(alumno);
        this.inscripcion.setMateria(materia);
        if (inscripcion.getId() != null) {
            this.daoInscripcion.edit(inscripcion);
        } else {
            this.daoInscripcion.create(inscripcion);
        }
        this.refresh();
        this.init();
    }

    public void cargarInscripcion(Inscripcion inscripcion) {
        this.setAlumno(inscripcion.getAlumno());
        this.setMateria(inscripcion.getMateria());
        this.inscripcion = inscripcion;
    }

    public void eliminarInscripcion(Inscripcion inscripcion) {
        this.daoInscripcion.remove(inscripcion);
        this.refresh();
    }

    public String irInscripcion() {
        return "/views/dt_inscripciones/dt_inscripciones.xhtml";
    }

}
