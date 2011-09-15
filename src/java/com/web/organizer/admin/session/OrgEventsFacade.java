/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.admin.session;

import com.web.organizer.db.OrgEvents;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author delian
 */
@Stateless
public class OrgEventsFacade extends AbstractFacade<OrgEvents> {
    @PersistenceContext(unitName = "WebOrganizerPersistencePU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public OrgEventsFacade() {
        super(OrgEvents.class);
    }
    
}
