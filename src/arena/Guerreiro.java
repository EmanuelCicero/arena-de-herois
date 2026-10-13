// Autor: Emanuel cicero moreira de lima - 2026006620

package arena;

public class Guerreiro extends Personagem{
     private int armadura;
     private int bonusDeAtaque = 5;

    public Guerreiro(String nome, int vidaMaxima, int ataque, int defesa, int armadura){
        super(nome, vidaMaxima, ataque, defesa);
        this.armadura = armadura;
    }

    public int getArmadura(){
        return armadura;
    }

    void gritoDeGuerra(){
        this.ataque += bonusDeAtaque;
        System.out.println( getNome() + " solta um grito de guerra! Ataque agora: " + getAtaque());
    }

    @Override 
    public int receberDano(int dano){
        return super.receberDano(dano - armadura);
    }
}
