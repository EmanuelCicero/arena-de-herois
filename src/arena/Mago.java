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

    @Override 
    public void atacar(Personagem alvo){
        if(estaVivo()){
            if(alvo.estaVivo()){
                if(mana >= 10){
                    mana -= 10;
                    System.out.println( getNome() + " lança uma bola de fogo em " + alvo.getNome() + " e causa " + alvo.receberDano(getAtaque()*2) + " de dano." + "( mana: " + mana + " )");
                }else{
                    System.out.println( getNome() + " ataca " + alvo.getNome() + " e causa " + alvo.receberDano(getAtaque())+ " de dano.");
                }
            }else{
                System.out.println(alvo.getNome() + " já está morto!");
            }
        }else{
            System.out.println(getNome() + " está morto!");
        }
    }
}
