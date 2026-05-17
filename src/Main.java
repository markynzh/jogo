import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        // CRIANDO A PRIMEIRA TELA
        JFrame telaInicial = new JFrame("O Peso das Escolhas");
        telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaInicial.setLocationRelativeTo(null);

        // PAINEL COM IMAGEM DE FUNDO
        JPanel painel = new JPanel() {

            Image fundo = new ImageIcon(
                    "img/background.jpeg"
            ).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // desenha a imagem ocupando a tela inteira
                g.drawImage(fundo, 0, 0, getWidth(), getHeight(), this);
            }
        };

        painel.setLayout(null);

        // BOTÃO COMEÇAR JOGO
        JButton botaoComecar = new JButton("COMEÇAR O JOGO");
        botaoComecar.setBounds(855, 788, 220, 40);

        // ESTILO DO BOTÃO
        botaoComecar.setFont(new Font("Montserrat", Font.BOLD, 15));

        painel.add(botaoComecar);

        // AÇÃO DO BOTÃO
        botaoComecar.addActionListener(e -> {

            // FECHA A PRIMEIRA TELA
            telaInicial.dispose();

            // NOVA TELA
            JFrame telaApresentacao = new JFrame("O Peso das Escolhas");
            telaApresentacao.setSize(800, 500);
            telaApresentacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            telaApresentacao.setLocationRelativeTo(null);

            JPanel painel2 = new JPanel() {

                Image fundo = new ImageIcon(
                        "img/apresentacao.jpeg"
                ).getImage();

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

                    // desenha a imagem ocupando a tela inteira
                    g.drawImage(fundo, 0, 0, getWidth(), getHeight(), this);
                }
            };

            painel.setLayout(null);

            JButton proximoBotao = new JButton("PRÓXIMA TELA");
            proximoBotao.setBounds(300, 250, 200, 50);

            painel2.add(proximoBotao);

            // AÇÃO DO SEGUNDO BOTÃO
            proximoBotao.addActionListener(a -> {
                JOptionPane.showMessageDialog(null,
                        "Aqui você pode abrir outra fase!");
            });

            telaApresentacao.add(painel2);
            telaApresentacao.setExtendedState(JFrame.MAXIMIZED_BOTH);
            telaApresentacao.setVisible(true);
        });

        telaInicial.add(painel);
        telaInicial.setExtendedState(JFrame.MAXIMIZED_BOTH);
        telaInicial.setVisible(true);
    }
}