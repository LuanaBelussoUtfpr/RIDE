package negocio;

import entidade.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CadastroUsuarioBean implements IUsuario {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public boolean criar (String nome, String sobrenome, String usuario, String senha, String cidade, String estado, String pais){
        
        Usuario u = new Usuario();
        
        u.setNome(nome);
        u.setSobrenome(sobrenome);
        u.setUsuario(usuario);
        u.setSenha(senha);
        u.setCidade(cidade);
        u.setEstado(estado);
        u.setPais(pais);
        
        try {
            em.persist(u);
            return true;
            
        } catch (Exception e) {
            System.out.println("");
        }
        
        return false;        
    }
}
