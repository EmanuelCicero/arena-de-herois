// Autor: Emanuel cicero moreira de lima - 2026006620

package arena;

public class Personagem {
    private  String nome;
    private  int vidaMaxima;
    protected int vida;
    protected   int ataque;
    private  int defesa;

    public Personagem(String nome, int vidaMaxima, int ataque, int defesa){
        this.nome =  nome;
        this.vidaMaxima = vidaMaxima;
        vida = vidaMaxima;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public String getNome(){
        return nome;
    }

    public int getVidaMaxima(){
        return vidaMaxima;
    }

    public int getVida(){
        return vida;
    }

    public int getAtaque(){
        return ataque;
    }

    public int getDefesa(){
        return defesa;
    }

    public boolean estaVivo(){
        if (vida > 0) {
            return true;
        }else{
            return false;
        }
    }

    public int receberDano(int dano){
        int danoReal = dano - defesa;

        if(danoReal < 1){
            danoReal = 1;
        }

        
        if(vida - danoReal <= 0){
            vida = 0;
        }else{
            vida -= danoReal;
        }
        
        return danoReal;
    }

    public void curar(int pontos){
        
        if(estaVivo()){
            vida += pontos;  
            if( vida > vidaMaxima){
                vida = vidaMaxima;
            }
        }
    }

    public void atacar(Personagem alvo){
        if(estaVivo()){
            if(alvo.estaVivo()){
                System.out.println( nome + " ataca " + alvo.nome + " e causa " + alvo.receberDano(ataque) + " de dano.");
            }else{
                System.out.println(alvo.nome + " já está morto!");
            }
        }else{
            System.out.println(nome + " está morto!");
        }
    }

    public String status(){
        return nome + " [HP " + vida + "/" + vidaMaxima + "]";
    }
}
