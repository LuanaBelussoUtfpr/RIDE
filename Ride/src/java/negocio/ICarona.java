package negocio;

import java.sql.Time;
import java.util.Date;
import javax.ejb.Local;

@Local
public interface ICarona {
    public boolean criar(String descricao, String localOrigem, String localDestino, 
            Long vagasDisponiveis, double valorCarona, String dataCarona, String horarioCarona, 
            String cidadeOrigem, String estadoOrigem, String paisOrigem,
            String cidadeDestino, String estadoDestino, String paisDestino);
    
}
