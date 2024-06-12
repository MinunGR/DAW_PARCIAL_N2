/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.ues.parcial.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "inscripcion")
public class Inscripcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripcion_id_seq")
    @SequenceGenerator(name = "inscripcion_id_seq", sequenceName = "inscripcion_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "alumno_id", referencedColumnName = "id")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "materia_id", referencedColumnName = "id")
    private Materia materia;

    @Column(name = "ciclo")
    private String ciclo;

    @Column(name = "año")
    private Integer año;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inscripcion")
    private Date fechaInscripcion;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Inscripcion that = (Inscripcion) obj;
        return Objects.equals(id, that.id);
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "id=" + id +
                ", alumno=" + alumno +
                ", materia=" + materia +
                ", ciclo='" + ciclo + '\'' +
                ", año=" + año +
                ", fechaInscripcion=" + fechaInscripcion +
                '}';
    }

    // Constructor vacío
    public Inscripcion() {
    }

    // Constructor con parámetros
    public Inscripcion(Alumno alumno, Materia materia, String ciclo, Integer año, Date fechaInscripcion) {
        this.alumno = alumno;
        this.materia = materia;
        this.ciclo = ciclo;
        this.año = año;
        this.fechaInscripcion = fechaInscripcion;
    }
}
