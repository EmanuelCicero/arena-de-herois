// Autor: Emanuel cicero moreira de lima - 2026006620

package arena;
import java.util.Scanner;

public class Arena{
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        
        Personagem[] herois = new Personagem[3];
        Personagem[] monstros = new Personagem[3];

        herois[0] = new Guerreiro("Thorin", 120, 15, 5, 3);
        herois[1] = new Mago("Merlin", 70, 12, 2, 40);
        herois[2] = new Arqueiro("Legolas", 85, 13, 3, 5);
        
        monstros[0] = new Personagem("Goblin", 40, 12, 2);
        monstros[1] = new Personagem("Orc", 80, 18, 4);
        monstros[2] = new Personagem("Troll", 140, 22, 6);

        int turno = 1;
        while (algumVivo(herois) && algumVivo(monstros)) {
            System.out.println("");
            System.out.println(" ===== TURNO " + turno + " ===== ");
            mostrarTimes(herois,monstros);

            for(Personagem p : herois){
                if(p.vida > 0){
                    System.out.println("");
                    System.out.print("Vez de " + p.status() + ": ");
                    System.out.print("1) Atacar ou 2) Habilidade especial: ");
                    int opcaoJogador = sc.nextInt();
                    while (opcaoJogador != 1 && opcaoJogador != 2) {
                        System.out.print("Digite apenas: 1) Atacar ou 2) Habilidade especial: ");
                        opcaoJogador = sc.nextInt();
                    }
                    
                    if(opcaoJogador == 1){
                        System.out.print("Escolha o alvo (número): ");
                        p.atacar(escolherAlvo(monstros, sc));
                        if(!algumVivo(monstros)){
                            break;
                        }
                    }else{
                        usarHabilidade(p, herois, sc);
                    }
                }
            }

            System.out.println("");
            for(Personagem p : monstros){
                p.atacar(maisFraco(herois));
            }

            turno++;
        }

        System.out.println("");
        if(algumVivo(monstros)){
            System.out.println("Sua visão escurece enquanto suas últimas forças se esvaem... O mal triunfou desta vez, e o seu nome se torna apenas uma lenda. Fim de jogo.");
            System.out.println("DERROTA... os monstros dominaram a arena.");
        }else{
            System.out.println("A poeira do campo de batalha finalmente baixa e você permanece de pé. O inimigo foi aniquilado e a glória desta conquista é sua. Você venceu!");
            System.out.println("VITÓRIA! Os heróis venceram em " + (turno - 1) + " turnos.");
        }

    }

    public static boolean algumVivo(Personagem[] time) {
        for(int i = 0; i < time.length; i++){
            if(time[i].vida > 0 ){
                return true;
            }
        }

        return false;
    }

    public static void mostrarTimes(Personagem[] herois, Personagem[] monstros){
        System.out.println("Heróis: ");
        for(int i = 0; i < herois.length; i++){
            System.out.println(i + ") " + herois[i].status());
        }

        System.out.println("Monstros: ");
        for(int i = 0; i < monstros.length; i++){
            System.out.println(i + ") " + monstros[i].status());
        }
    }

    public static Personagem escolherAlvo(Personagem[] time, Scanner sc ) { 
        int indiceAlvo = sc.nextInt();
        while (indiceAlvo < 0 || indiceAlvo >= time.length || !time[indiceAlvo].estaVivo()) {
            System.out.print("Monstro não existe ou já esta morto! Tente novamente: ");
            indiceAlvo = sc.nextInt();
        }
        return time[indiceAlvo];
    }

    public static void usarHabilidade ( Personagem p , Personagem [] herois , Scanner sc ) {
        if (p instanceof Guerreiro) {
            Guerreiro thorin = (Guerreiro) p;
            thorin.gritoDeGuerra();
        } else if (p instanceof Mago) {
            Mago merlin = (Mago) p;
            System.out.print("Escolha quem você quer curar (número): ");
            int indiceAliado = sc.nextInt();
            merlin.curarAliado(herois[indiceAliado]);
        } else if(p instanceof Arqueiro){
            Arqueiro legolas = (Arqueiro) p;
            legolas.recarregar();
        }
    }

    public static Personagem maisFraco (Personagem[] time) { 
        int maisFraco = 0;
        for(int i = 0; i < time.length; i++){
            if(time[i].getVida() < time[maisFraco].getVida()){
                if(time[i].estaVivo()){
                    maisFraco = i;
                }
            }
        }
        return time[maisFraco];
    }
}