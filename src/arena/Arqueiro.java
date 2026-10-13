// Autor: Emanuel cicero moreira de lima - 2026006620

package arena;

public class Arqueiro extends Personagem {
     private int flechas;
     private int recarregarFlechas = 3;

    public Arqueiro(String nome, int vidaMaxima, int ataque, int defesa, int flechas){
        super(nome, vidaMaxima, ataque, defesa);
        this.flechas =  flechas;
    }

    public int getFlechas(){
        return flechas;
    }

    void recarregar(){
        flechas =+ recarregarFlechas;
        System.out.println(getNome() + " recolhe flechas no chão. " + " (flechas: " + flechas + ")");
    }

    @Override 
    public void atacar(Personagem alvo){
        if(estaVivo()){
            if(alvo.estaVivo()){
                if(flechas > 0){
                    flechas--;
                    System.out.println( getNome() + " lança uma flecha em " + alvo.getNome() + " e causa " + alvo.receberDano(getAtaque()+5) + " de dano. " + "( flechas: " + flechas + " )");
                }else{
                    System.out.println( getNome() + " esta sem flechas e dá um soco em " + alvo.getNome() + ": " + alvo.receberDano(getAtaque()/2) + " de dano. ");
                }
            }else{
                System.out.println(alvo.getNome() + " já está morto! ");
            }
        }else{
            System.out.println(getNome() + " está morto! ");
        }
    }
}
