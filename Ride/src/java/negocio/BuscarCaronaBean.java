package negocio;

import entidade.Carona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BuscarCaronaBean implements IBuscarCarona{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Carona> consultar() {
        return em.createQuery("SELECT c FROM Carona c", Carona.class).getResultList();
    }
    
}
