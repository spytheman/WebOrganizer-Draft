/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.organizer.admin.session;

import com.web.organizer.db.OrgPayment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author delian
 */
@Stateless
public class OrgPaymentFacade extends AbstractFacade<OrgPayment> {
    @PersistenceContext(unitName = "WebOrganizerPersistencePU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public OrgPaymentFacade() {
        super(OrgPayment.class);
    }
    
}
