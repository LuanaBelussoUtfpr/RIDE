package negocio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class LoginBean implements ILogin{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public int login(String usuario, String senha) {
        return 1;
    }
}
