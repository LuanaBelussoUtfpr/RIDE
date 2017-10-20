package negocio;

import entidade.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LoginBean implements ILogin{

    @PersistenceContext
    private EntityManager em;

    @Override
    public int login(String user, String senha) {
        List<Usuario> lista;        
       lista = this.consultar();
       
       
        if (lista.stream().anyMatch(e -> e.getUsuario().equalsIgnoreCase(user))) {
            if (lista.stream().anyMatch(e -> e.getUsuario().equalsIgnoreCase(senha))){
                return 1;
            }
        }
        return -1;
    }
    
    @Override
    public List<Usuario> consultar() {
        return em.createQuery("SELECT e FROM Usuario e WHERE e.usuario = :user and e.senha = :senha", Usuario.class).getResultList();
    }
    
}
