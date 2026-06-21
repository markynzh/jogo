import javax.swing.*;
import java.awt.*;

public class Jogo {

    // ===== MAPA ATUAL =====
    private int mapaAtual = 1; // 1, 2 ou 3

    // ===== OBJETOS DO JOGO =====
    private Jogador jogador;
    private Obstaculos obstaculos;

    // ===== NPCS POR MAPA =====
    private NPC[] npcsMapa1;
    private NPC[] npcsMapa2;
    private NPC[] npcsMapa3;

    // ===== PONTUAÇÃO =====
    private int pontos;

    // ===== CONTROLE DE TECLAS =====
    private boolean wPressionado = false;
    private boolean sPressionado = false;
    private boolean aPressionado = false;
    private boolean dPressionado = false;

    // ===== TIMER =====
    private Timer timer;

    // ===== REFERÊNCIAS =====
    private JFrame janela;
    private JPanel painelJogo;

    // ===== CALLBACK PARA TROCAR MAPA =====
    private Runnable onTrocarMapa;

    public Jogo(JFrame janela, JPanel painelJogo, Runnable onTrocarMapa) {
        this.janela       = janela;
        this.painelJogo   = painelJogo;
        this.onTrocarMapa = onTrocarMapa;
        this.pontos       = 0;

        jogador    = new Jogador();
        obstaculos = new Obstaculos();

        // ===== NPCS MAPA 1 =====
        npcsMapa1 = new NPC[]{
            new NPC(0.22, 0.33, "img/npc1.png",
                "Quando eu fico com muita raiva da minha namorada, às vezes eu a empurro para que ela pare de discutir.",
                new String[]{"Se foi só um empurrão, não é tão grave.", "Todo casal briga às vezes.", "Empurrar alguém é agressão e não resolve problemas."},
                2, 0),
            new NPC(0.35, 0.60, "img/npc2.png",
                "Meu namorado me diz que ninguém vai me querer sem ele, me rebaixa e diz que se não fosse ele eu viveria sozinha.",
                new String[]{"Talvez ele só falou sem pensar.", "Isso é manipulação, você precisa terminar esse relacionamento.", "Ele só está sendo sincero."},
                1, 2),
            new NPC(0.55, 0.30, "img/npc3.png",
                "Na festa um menino me fez beijar ele à força, mesmo eu tendo falado que não queria muitas vezes.",
                new String[]{"Ele só estava tentando te conquistar.", "Isso é assédio, você não deu consentimento. Vamos denunciar.", "Isso acontece em festas, é bem normal."},
                1, 0),
            new NPC(0.78, 0.30, "img/npc4.png",
                "Eu discuti com uma menina da minha sala e fiquei espalhando mentiras sobre ela. Foi engraçado.",
                new String[]{"Espalhar mentiras prejudica a dignidade das pessoas.", "Isso acontece na escola, é normal.", "Era só fofoca, relaxa."},
                0, 2),
            new NPC(0.24, 0.82, "img/npc5.png",
                    "Meu namorado quebra minhas coisas quando fica nervoso. Ele já quebrou meu celular e muitas maquiagens minhas.",
                new String[]{"Isso é violência patrimonial e deve ser denunciado.", "Foi só um momento de raiva.", "Ele só estava estressado."},
                0, 2),
        };

        // ===== NPCS MAPA 2 =====
        npcsMapa2 = new NPC[]{
                new NPC(0.07, 0.20, "img/npc6.png",
                        "Eu faço minha namorada se sentir culpada quando sai com amigos, pois não gosto quando ela sai sem mim.",
                        new String[]{"Isso é controle emocional e violência psicológica.", "Ciúme é prova de amor.", "Você só está protegendo ela."},
                        0, 1),
                new NPC(0.47, 0.16, "img/npc7.png",
                        "Minha ex fica me mandando mensagem pedindo para eu parar de espalhar fofoca dela, mas eu continuo porque ela merece.",
                        new String[]{"Você precisa parar de fazer isso agora!", "Ela não sabe de nada, merece mesmo.", "Isso acontece às vezes, relaxa."},
                        0, 1),
                new NPC(0.85, 0.52, "img/npc8.png",
                        "Quando minha namorada me irrita, eu escondo o celular dela.",
                        new String[]{"Controlar ou esconder objetos pessoais é violência.", "Você só quer chamar atenção dela.", "Depois você devolve, tá de boa."},
                        0, 1),
                new NPC(0.30, 0.76, "img/npc9.png",
                        "Meu namorado me chama de inútil e me bate quando eu faço algo que ele não gosta.",
                        new String[]{"Você precisa denunciar ele, ele não pode te bater.", "Ele só fez sem pensar, além dele estar certo.", "Talvez ele já esteja acostumada."},
                        0, 1),
                new NPC(0.73, 0.82, "img/npc10.png",
                        "Ele insiste em manter contato físico mesmo quando eu não quero.",
                        new String[]{"Você não consentiu, isso é crime!", "Ele só tá demonstrando carinho.", "Você deve aceitar isso, ele te ama."},
                        0, 1),
        };

        // ===== NPCS MAPA 3 =====
        npcsMapa3 = new NPC[]{
                new NPC(0.23, 0.42, "img/npc11.png",
                        "Eu falei que não queria beijar ele, mas ele insistiu mesmo assim.",
                        new String[]{"Se você não queria, ele deveria respeitar. Vamos denunciar.", "Talvez ele só estivesse animado.", "Isso acontece às vezes."},
                        0, 1),
                new NPC(0.30, 0.13, "img/npc12.png",
                        "Eu compartilhei a senha do celular da minha namorada com meus amigos sem ela saber.",
                        new String[]{"Violar a privacidade de alguém é errado e pode ser crime.", "Entre casal não pode ter segredo.", "Depende do que tinha no celular."},
                        0, 1),
                new NPC(0.68, 0.67, "img/npc13.png",
                        "Meu namorado controla tudo: o que eu visto, com quem falo e onde vou.",
                        new String[]{"Isso é controle e isolamento, formas de violência.", "Ele só quer o melhor para você.", "Todo casal tem suas regras."},
                        0, 1),
                new NPC(0.57, 0.20, "img/npc14.png",
                        "Vi um colega humilhando a namorada dele na frente de todo mundo e todo mundo riu.",
                        new String[]{"Humilhar alguém em público é violência moral. Deveria intervir.", "Foi só uma brincadeira, não tem problema.", "Não é problema meu me meter."},
                        0, 1),
                new NPC(0.92, 0.32, "img/npc15.png",
                        "Vi um colega empurrando a namorada dele na minha frente.",
                        new String[]{"Isso é violência física e deve ser denunciado.", "Foi só discussão.", "Isso acontece em brigas."},
                        0, 1),
        };

        timer = new Timer(16, e -> atualizar());
    }

    // ===== NPCS DO MAPA ATUAL =====
    public NPC[] getNpcsAtuais() {
        switch (mapaAtual) {
            case 2:  return npcsMapa2;
            case 3:  return npcsMapa3;
            default: return npcsMapa1;
        }
    }

    // ===== ATUALIZAÇÃO DA LÓGICA =====
    private void atualizar() {
        int W = painelJogo.getWidth();
        int H = painelJogo.getHeight();

        jogador.mover(wPressionado, sPressionado, aPressionado, dPressionado);
        jogador.aplicarLimites(W, H);
        obstaculos.verificarColisao(jogador, W, H, wPressionado, sPressionado, aPressionado, dPressionado, mapaAtual);

        for (NPC npc : getNpcsAtuais()) {
            if (!npc.isPerguntaFeita() && jogador.getHitbox(W, H).intersects(npc.getHitbox(W, H))) {
                npc.setPerguntaFeita(true);
                pararTeclas();

                int escolha = DialogoPersonalizado.mostrarPergunta(janela, npc.getPergunta(), npc.getOpcoes());
                pontos += npc.calcularPontos(escolha);
                DialogoPersonalizado.mostrarMensagem(janela, "Pontuação atual: " + pontos);

                verificarFimDeMapa();
            }
        }

        painelJogo.repaint();
    }

    // ===== VERIFICAR FIM DO MAPA =====
    private void verificarFimDeMapa() {
        for (NPC npc : getNpcsAtuais()) {
            if (!npc.isPerguntaFeita()) return;
        }

        if (mapaAtual < 3) {
            // ===== TRANSIÇÃO PARA O PRÓXIMO MAPA =====
            String msg = mapaAtual == 1
                ? "Você ajudou todos aqui!\nVamos para o próximo lugar..."
                : "Incrível! Mais um lugar ajudado!\nVamos para o último lugar...";
            DialogoPersonalizado.mostrarMensagem(janela, msg);
            mapaAtual++;
            jogador.resetarPosicao();
            onTrocarMapa.run();
        } else {
            // ===== FIM DO JOGO =====
            String feedback;
            if (pontos < 80) {
                feedback = "Você precisa estudar mais sobre o assunto.";
            } else if (pontos <= 120) {
                feedback = "Você está no caminho certo!";
            } else {
                feedback = "Parabéns, você entende muito do assunto!";
            }
            DialogoPersonalizado.mostrarMensagem(janela,
                "FIM DE JOGO!\n\nPontuação final: " + pontos + "\n\n" + feedback);
            janela.dispose();
        }
    }

    // ===== PARAR TECLAS =====
    public void pararTeclas() {
        wPressionado = false;
        sPressionado = false;
        aPressionado = false;
        dPressionado = false;
    }

    // ===== INICIAR TIMER =====
    public void iniciar() { timer.start(); }

    // ===== GETTERS =====
    public Jogador getJogador()       { return jogador; }
    public NPC[] getNpcs()            { return getNpcsAtuais(); }
    public Obstaculos getObstaculos() { return obstaculos; }
    public int getPontos()            { return pontos; }
    public int getMapaAtual()         { return mapaAtual; }

    // ===== CONTROLE DE TECLAS =====
    public void setW(boolean v) { wPressionado = v; }
    public void setS(boolean v) { sPressionado = v; }
    public void setA(boolean v) { aPressionado = v; }
    public void setD(boolean v) { dPressionado = v; }

    public boolean isAndando() {
        return wPressionado || sPressionado || aPressionado || dPressionado;
    }
}
