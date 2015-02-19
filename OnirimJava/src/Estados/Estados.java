
package Estados;

import Cartas.Carta;


public interface Estados {
    
    public void baralhar();
    public void descartar_carta(Carta c);
    public void comprar_carta();
    public void jogar_carta(Carta c);
    public void limpar_limbo();
    
    public void profecia(Carta c);
    
    public int verificar_estado_jogo(); //-1 perdeu, 0- continua a jogar, 1 ganhou
    
}
