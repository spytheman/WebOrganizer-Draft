/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.admin.session;

import com.web.organizer.db.OrgNotes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author delian
 */
@Stateless
public class OrgNotesFacade extends AbstractFacade<OrgNotes> {
    @PersistenceContext(unitName = "WebOrganizerPersistencePU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public OrgNotesFacade() {
        super(OrgNotes.class);
    }
    
}
