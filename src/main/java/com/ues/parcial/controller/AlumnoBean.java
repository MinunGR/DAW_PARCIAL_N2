/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ues.parcial.controller;

import com.ues.parcial.service.AlumnoDataService;
import com.ues.parcial.entity.Alumno;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Carlos
 */
@Named("cAlumno")
@ViewScoped
public class AlumnoBean implements Serializable {

    // Acceso a datos
    @EJB(beanName = "AlumnoService")
    private AlumnoDataService daoAlumno;

    // Listado de alumnos
    private List<Alumno> alumnosList;
    // Entidades
    private Alumno alumno;

    public List<Alumno> getAlumnosList() {
        this.alumnosList = this.daoAlumno.findAll();
        return alumnosList;
    }

    public void setAlumnosList(List<Alumno> alumnosList) {
        this.alumnosList = alumnosList;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @PostConstruct
    public void init() {
        this.alumno = new Alumno();
    }

    public void refresh() {
        this.alumnosList = this.daoAlumno.findAll();
    }

    public void guardarAlumno() {
        if (alumno.getId() != null) {
            this.daoAlumno.edit(alumno);
        } else {
            this.daoAlumno.create(alumno);
        }
        this.refresh();
        this.init();
    }

    public void cargarAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void eliminarAlumno(Alumno alumno) {
        this.daoAlumno.remove(alumno);
        this.refresh();
    }

    public String irAlumno() {
        return "/views/dt_alumnos/dt_alumnos.xhtml";
    }

}
