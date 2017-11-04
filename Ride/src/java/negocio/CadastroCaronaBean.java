
package negocio;

import entidade.Carona;
import java.sql.Time;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CadastroCaronaBean implements ICarona{
    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean criar(String descricao, String localOrigem, String localDestino, 
            Long vagasDisponiveis, double valorCarona, String dataCarona, String horarioCarona, 
            String cidadeOrigem, String estadoOrigem, String paisOrigem,
            String cidadeDestino, String estadoDestino, String paisDestino) {
        
        Carona c = new Carona();
        
        c.setDescricao(descricao);
        c.setLocalOrigem(localOrigem);
        c.setLocalDestino(localDestino);
        c.setVagasDisponiveis(vagasDisponiveis);
        c.setValorCarona(valorCarona);
        c.setDataCarona(dataCarona);
        c.setHorarioCarona(horarioCarona);
        c.setCidadeOrigem(cidadeOrigem);
        c.setEstadoOrigem(estadoOrigem);
        c.setPaisOrigem(paisOrigem);
        c.setCidadeDestino(cidadeDestino);
        c.setEstadoDestino(estadoDestino);
        c.setPaisDestino(paisDestino);
        
        try {
            em.persist(c);
            return true;
        } catch (Exception e) {
            System.out.println("ERRO");
        }
        
        return false;
    }  
}
