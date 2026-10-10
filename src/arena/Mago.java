// Autor: Emanuel cicero moreira de lima - 2026006620

package arena;

public class Mago extends Personagem {
    private int mana;

    public Mago(String nome, int vidaMaxima, int ataque, int defesa, int mana){
        super(nome, vidaMaxima, ataque, defesa);
        this.mana = mana;
    }

    public int getMana(){
        return mana;
    }
}
