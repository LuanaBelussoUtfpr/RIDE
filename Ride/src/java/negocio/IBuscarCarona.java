/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Carona;
import java.util.List;

/**
 *
 * @author Felipe Ribeiro
 */
public interface IBuscarCarona {
    public List<Carona> consultar();
}
