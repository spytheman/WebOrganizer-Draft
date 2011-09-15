/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.admin.session;

import com.web.organizer.db.OrgBusiness;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author delian
 */
@Stateless
public class OrgBusinessFacade extends AbstractFacade<OrgBusiness> {
    @PersistenceContext(unitName = "WebOrganizerPersistencePU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public OrgBusinessFacade() {
        super(OrgBusiness.class);
    }
    
}
