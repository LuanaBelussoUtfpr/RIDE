package negocio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LoginBean implements ILogin{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public int login(String usuario, String senha) {
        int teste;
        teste = em.createQuery("SELECT 1 FROM usuario where usuario=" + usuario + " and senha=" + senha).getFirstResult();
        System.out.println("luana " + teste);
        return teste;
    }
}
