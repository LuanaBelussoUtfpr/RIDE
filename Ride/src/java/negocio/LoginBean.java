package negocio;

import entidade.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class LoginBean implements ILogin{

    @PersistenceContext
    private EntityManager em;

    @Override
    public int login(String user, String senha) {
        List<Usuario> lista;     
        lista = this.consultar(user, senha);
              
        if(lista.isEmpty()){
            return -1;
        }else{
            return 1;
        }
       
    }
    
    @Override
    public List<Usuario> consultar(String user, String password) {
        try{
            return em.createQuery("SELECT u FROM Usuario u where u.usuario = :user and u.senha= :password", Usuario.class)
                .setParameter("user", user)
                .setParameter("password", password).getResultList();
            
        }catch (NoResultException e){
            return null;
        }
        
    }
    
}
