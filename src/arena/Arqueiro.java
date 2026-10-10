// Autor: Emanuel cicero moreira de lima - 2026006620

package arena;

public class Arqueiro extends Personagem {
     private int flechas;

    public Arqueiro(String nome, int vidaMaxima, int ataque, int defesa, int flechas){
        super(nome, vidaMaxima, ataque, defesa);
        this.flechas =  flechas;
    }

    public int getFlechas(){
        return flechas;
    }
}
