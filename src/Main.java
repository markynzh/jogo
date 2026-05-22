import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    // ===== PERSONAGEM PRINCIPAL =====
    static int playerX = 100;
    static int playerY = 370;
    static int velocidade = 15;

    // ===== POSIÇÕES DOS NPCS =====
    static int[] npcX = {250, 500, 750, 1000, 1250};
    static int[] npcY = {370, 370, 370, 370, 370};

    // ===== CONTROLE DAS PERGUNTAS =====
    static boolean[] perguntaFeita = {
            false, false, false, false, false
    };

    // ===== PONTUAÇÃO =====
    static int pontos = 0;

    public static void main(String[] args) {

        // ===== PRIMEIRA TELA =====
        JFrame telaInicial =
                new JFrame("O Peso das Escolhas");

        telaInicial.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        JPanel painel1 = new JPanel() {

            Image fundo =
                    new ImageIcon(
                            "img/background.jpeg"
                    ).getImage();

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                g.drawImage(
                        fundo,
                        0,
                        0,
                        getWidth(),
                        getHeight(),
                        this
                );
            }
        };

        painel1.setLayout(null);

        JButton botaoComecar =
                new JButton("COMEÇAR O JOGO");

        botaoComecar.setBounds(670, 620, 220, 30);

        painel1.add(botaoComecar);

        // ===== BOTÃO DA PRIMEIRA TELA =====
        botaoComecar.addActionListener(e -> {

            telaInicial.dispose();

            // ===== SEGUNDA TELA =====
            JFrame tela2 =
                    new JFrame("O Peso das Escolhas");

            tela2.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
            );

            JPanel painel2 = new JPanel() {

                Image fundo =
                        new ImageIcon(
                                "img/apresentacao.jpeg"
                        ).getImage();

                @Override
                protected void paintComponent(Graphics g) {

                    super.paintComponent(g);

                    g.drawImage(
                            fundo,
                            0,
                            0,
                            getWidth(),
                            getHeight(),
                            this
                    );
                }
            };

            painel2.setLayout(null);

            JButton botaoTela3 =
                    new JButton(
                            "VOU TE AJUDAR COM CERTEZA!"
                    );

            botaoTela3.setBounds(780, 690, 260, 30);

            painel2.add(botaoTela3);

            // ===== BOTÃO DA SEGUNDA TELA =====
            botaoTela3.addActionListener(a -> {

                tela2.dispose();

                // ===== TERCEIRA TELA =====
                JFrame tela3 =
                        new JFrame("O Peso das Escolhas");

                tela3.setDefaultCloseOperation(
                        JFrame.EXIT_ON_CLOSE
                );

                JPanel painel3 = new JPanel() {

                    Image fundo =
                            new ImageIcon(
                                    "img/dicas.png"
                            ).getImage();

                    @Override
                    protected void paintComponent(Graphics g) {

                        super.paintComponent(g);

                        g.drawImage(
                                fundo,
                                0,
                                0,
                                getWidth(),
                                getHeight(),
                                this
                        );
                    }
                };

                painel3.setLayout(null);

                JButton finalizar =
                        new JButton(
                                "VAMOS PARA O JOGO!"
                        );

                finalizar.setBounds(195, 610, 220, 30);

                painel3.add(finalizar);

                // ===== BOTÃO DA TERCEIRA TELA =====
                finalizar.addActionListener(x -> {

                    tela3.dispose();

                    // ===== QUARTA TELA =====
                    JFrame tela4 =
                            new JFrame(
                                    "O Peso das Escolhas"
                            );

                    tela4.setDefaultCloseOperation(
                            JFrame.EXIT_ON_CLOSE
                    );

                    JPanel painel4 = new JPanel() {

                        // ===== FUNDO =====
                        Image fundo =
                                new ImageIcon(
                                        "img/fundoPrincipal.jpeg"
                                ).getImage();

                        // ===== PERSONAGEM =====
                        Image jogador =
                                new ImageIcon(
                                        "img/personagem.png"
                                ).getImage();

                        // ===== NPCS DIFERENTES =====
                        Image npc1 =
                                new ImageIcon(
                                        "img/npc1.png"
                                ).getImage();

                        Image npc2 =
                                new ImageIcon(
                                        "img/npc2.png"
                                ).getImage();

                        Image npc3 =
                                new ImageIcon(
                                        "img/npc3.png"
                                ).getImage();

                        Image npc4 =
                                new ImageIcon(
                                        "img/npc4.png"
                                ).getImage();

                        Image npc5 =
                                new ImageIcon(
                                        "img/npc5.png"
                                ).getImage();

                        @Override
                        protected void paintComponent(Graphics g) {

                            super.paintComponent(g);

                            g.drawImage(
                                    fundo,
                                    0,
                                    0,
                                    getWidth(),
                                    getHeight(),
                                    this
                            );

                            // ===== TAMANHO PADRÃO =====
                            int largura = 100;
                            int altura = 180;

                            // ===== JOGADOR =====
                            g.drawImage(
                                    jogador,
                                    playerX,
                                    playerY,
                                    65,
                                    altura,
                                    this
                            );

                            // ===== NPC 1 =====
                            g.drawImage(
                                    npc1,
                                    npcX[0],
                                    npcY[0],
                                    largura,
                                    altura,
                                    this
                            );

                            // ===== NPC 2 =====
                            g.drawImage(
                                    npc2,
                                    npcX[1],
                                    npcY[1],
                                    largura,
                                    altura,
                                    this
                            );

                            // ===== NPC 3 =====
                            g.drawImage(
                                    npc3,
                                    npcX[2],
                                    npcY[2],
                                    largura,
                                    altura,
                                    this
                            );

                            // ===== NPC 4 =====
                            g.drawImage(
                                    npc4,
                                    npcX[3],
                                    npcY[3],
                                    largura,
                                    altura,
                                    this
                            );

                            // ===== NPC 5 =====
                            g.drawImage(
                                    npc5,
                                    npcX[4],
                                    npcY[4],
                                    largura,
                                    altura,
                                    this
                            );

                            // ===== PONTUAÇÃO =====
                            g.setColor(Color.WHITE);

                            g.setFont(
                                    new Font(
                                            "Arial",
                                            Font.BOLD,
                                            30
                                    )
                            );

                            g.drawString(
                                    "Pontos: " + pontos,
                                    30,
                                    50
                            );
                        }
                    };

                    painel4.setLayout(null);

                    // ===== MOVIMENTAÇÃO =====
                    tela4.addKeyListener(new KeyAdapter() {

                        @Override
                        public void keyPressed(KeyEvent e) {

                            int tecla = e.getKeyCode();

                            // ===== DIREITA =====
                            if (tecla == KeyEvent.VK_RIGHT) {
                                playerX += velocidade;
                            }

                            // ===== ESQUERDA =====
                            if (tecla == KeyEvent.VK_LEFT) {
                                playerX -= velocidade;
                            }

                            // ===== NÃO SAIR DA TELA =====
                            if (playerX < 0) {
                                playerX = 0;
                            }

                            // ===== VERIFICAR COLISÕES =====
                            for (int i = 0;
                                 i < npcX.length;
                                 i++) {

                                Rectangle player =
                                        new Rectangle(
                                                playerX,
                                                playerY,
                                                50,
                                                180
                                        );

                                Rectangle npcAtual =
                                        new Rectangle(
                                                npcX[i],
                                                npcY[i],
                                                50,
                                                180
                                        );

                                // ===== COLISÃO =====
                                if (player.intersects(npcAtual)
                                        && !perguntaFeita[i]) {

                                    perguntaFeita[i] = true;

                                    String pergunta = "";

                                    String[] opcoes = {};

                                    // ===== NPC 1 =====
                                    if (i == 0) {

                                        pergunta =
                                                "Você ouviu um amigo fazendo uma piada machista.\nO que você faz?";

                                        opcoes = new String[]{
                                                "Dou risada junto",
                                                "Ignoro",
                                                "Peço para ele parar"
                                        };
                                    }

                                    // ===== NPC 2 =====
                                    if (i == 1) {

                                        pergunta =
                                                "Uma mulher está sendo assediada no ônibus.\nO que você faz?";

                                        opcoes = new String[]{
                                                "Finjo que não vi",
                                                "Ajudo a vítima",
                                                "Filmo a situação"
                                        };
                                    }

                                    // ===== NPC 3 =====
                                    if (i == 2) {

                                        pergunta =
                                                "Seu amigo compartilhou fotos íntimas de uma garota.\nO que você faz?";

                                        opcoes = new String[]{
                                                "Compartilho também",
                                                "Peço para apagar",
                                                "Mando para outras pessoas"
                                        };
                                    }

                                    // ===== NPC 4 =====
                                    if (i == 3) {

                                        pergunta =
                                                "Você presenciou violência verbal.\nO que você faz?";

                                        opcoes = new String[]{
                                                "Defendo a vítima",
                                                "Ignoro",
                                                "Incentivo a discussão"
                                        };
                                    }

                                    // ===== NPC 5 =====
                                    if (i == 4) {

                                        pergunta =
                                                "Uma colega pediu ajuda após sofrer ameaça.\nO que você faz?";

                                        opcoes = new String[]{
                                                "Ajudo e procuro apoio",
                                                "Digo que não é problema meu",
                                                "Faço piada da situação"
                                        };
                                    }

                                    // ===== MOSTRAR DIALOG =====
                                    int escolha =
                                            JOptionPane.showOptionDialog(
                                                    null,
                                                    pergunta,
                                                    "Escolha",
                                                    JOptionPane.DEFAULT_OPTION,
                                                    JOptionPane.INFORMATION_MESSAGE,
                                                    null,
                                                    opcoes,
                                                    opcoes[0]
                                            );

                                    // ===== PONTUAÇÃO NPC 1 =====
                                    if (i == 0) {

                                        if (escolha == 2) {
                                            pontos += 10;
                                        }

                                        else if (escolha == 1) {
                                            pontos += 0;
                                        }

                                        else {
                                            pontos -= 10;
                                        }
                                    }

                                    // ===== PONTUAÇÃO NPC 2 =====
                                    if (i == 1) {

                                        if (escolha == 1) {
                                            pontos += 10;
                                        }

                                        else if (escolha == 0) {
                                            pontos += 0;
                                        }

                                        else {
                                            pontos -= 10;
                                        }
                                    }

                                    // ===== PONTUAÇÃO NPC 3 =====
                                    if (i == 2) {

                                        if (escolha == 1) {
                                            pontos += 10;
                                        }

                                        else {
                                            pontos -= 10;
                                        }
                                    }

                                    // ===== PONTUAÇÃO NPC 4 =====
                                    if (i == 3) {

                                        if (escolha == 0) {
                                            pontos += 10;
                                        }

                                        else if (escolha == 1) {
                                            pontos += 0;
                                        }

                                        else {
                                            pontos -= 10;
                                        }
                                    }

                                    // ===== PONTUAÇÃO NPC 5 =====
                                    if (i == 4) {

                                        if (escolha == 0) {
                                            pontos += 10;
                                        }

                                        else if (escolha == 1) {
                                            pontos += 0;
                                        }

                                        else {
                                            pontos -= 10;
                                        }
                                    }

                                    JOptionPane.showMessageDialog(
                                            null,
                                            "Pontuação atual: "
                                                    + pontos
                                    );
                                }
                            }

                            painel4.repaint();
                        }
                    });

                    tela4.add(painel4);

                    tela4.setExtendedState(
                            JFrame.MAXIMIZED_BOTH
                    );

                    tela4.setVisible(true);

                    tela4.setFocusable(true);
                    tela4.requestFocus();
                });

                tela3.add(painel3);

                tela3.setExtendedState(
                        JFrame.MAXIMIZED_BOTH
                );

                tela3.setVisible(true);
            });

            tela2.add(painel2);

            tela2.setExtendedState(
                    JFrame.MAXIMIZED_BOTH
            );

            tela2.setVisible(true);
        });

        telaInicial.add(painel1);

        telaInicial.setExtendedState(
                JFrame.MAXIMIZED_BOTH
        );

        telaInicial.setVisible(true);
    }
}