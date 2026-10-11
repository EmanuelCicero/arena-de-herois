// Autor: Emanuel cicero moreira de lima - 2026006620

package arena;

public class Guerreiro extends Personagem{
     private int armadura;

    public Guerreiro(String nome, int vidaMaxima, int ataque, int defesa, int armadura){
        super(nome, vidaMaxima, ataque, defesa);
        this.armadura = armadura;
    }

    public int getArmadura(){
        return armadura;
    }

    @Override 
    public int receberDano(int dano){
        return super.receberDano(dano - armadura);
    }
}
