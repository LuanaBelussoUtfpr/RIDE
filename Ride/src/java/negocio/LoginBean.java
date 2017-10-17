package negocio;

import entidade.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LoginBean{

    @PersistenceContext
    private EntityManager em;
    
    
    public int login(String usuario, String senha) {
        Usuario user = new Usuario();
        em.persist(user);
        
        List<Usuario> lt;
        lt = em.createQuery("SELECT u FROM Usuario u WHERE usuario = 'ju'", Usuario.class).getResultList();
     
        if(lt.size()>0){
           return 1;
        }else{
            return -1;
        }
    }
}
