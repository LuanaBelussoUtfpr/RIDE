/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Carona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe Ribeiro
 */
public class BuscarCaronaBean implements ICarona{
    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean criar(String descricao, String localOrigem, String localDestino, Long vagasDisponiveis, Long valorCarona, String dataCarona, String horarioCarona, String cidade, String estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carona> consultar() {
        return em.createQuery("SELECT * FROM CARONA", Carona.class).getResultList();
    }
    
}
