/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author t. Andreta, Felipe_Flores
 */
public class JPAUtil {
    
    private static final String NOMEPU= "HelpDesk2PU";
    private static EntityManagerFactory factory = 
            Persistence.createEntityManagerFactory(NOMEPU);
    
    public static EntityManager createManager(){
        return factory.createEntityManager();
    }
    
}
