
package negocio;

import entidade.Carona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CadastroCaronaBean implements ICarona{
    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean criar(String descricao, String localOrigem, String localDestino, 
            Long vagasDisponiveis, Long valorCarona, String cidade, String estado) {
        
        Carona c = new Carona();
        
        c.setDescricao(descricao);
        c.setLocalOrigem(localOrigem);
        c.setLocalDestino(localDestino);
        c.setVagasDisponiveis(vagasDisponiveis);
        c.setValorCarona(valorCarona);
        c.setCidade(cidade);
        c.setEstado(estado);
        
        System.out.println(descricao);
        
        try {
            em.persist(c);
            return true;
            
        } catch (Exception e) {
            System.out.println("ERRO");
        }
        
        return false;
    }
    
    
}
