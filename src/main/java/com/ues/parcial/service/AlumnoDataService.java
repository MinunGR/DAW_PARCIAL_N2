/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ues.parcial.service;

import com.ues.parcial.entity.Alumno;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Fernando
 */
@Stateless(name = "AlumnoService")
public class AlumnoDataService extends AbstractService<Alumno> {

    @PersistenceContext(unitName = "db_parcial")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlumnoDataService() {
        super(Alumno.class);
    }
}
