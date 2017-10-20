
package modelo;

import entidade.Carona;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import negocio.BuscarCaronaBean;
import negocio.IBuscarCarona;

@ManagedBean
@ViewScoped
public class BuscarCaronaMB{
    private IBuscarCarona BuscarCaronaBean;
    private List<Carona> caronas;
    
    public List<Carona> consultar(){
        return BuscarCaronaBean.consultar();
    }
}
