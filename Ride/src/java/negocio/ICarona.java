package negocio;


public interface ICarona {
    boolean criar (String descricao, String localOrigem, String localDestino, 
            Long vagasDisponiveis, Long valorCarona,String dataCarona, String horarioCarona,
            String cidade, String estado);
}
