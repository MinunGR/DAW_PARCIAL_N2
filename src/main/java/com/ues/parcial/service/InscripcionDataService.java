/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ues.parcial.service;

import entities.Inscripcion;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Fernando
 */
@Stateless(name = "InscripcionService")
public class InscripcionDataService extends AbstractService<Inscripcion> {

    @PersistenceContext(unitName = "db_parcial")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InscripcionDataService() {
        super(Inscripcion.class);
    }
}
