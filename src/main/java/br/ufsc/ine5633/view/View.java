package br.ufsc.ine5633.view;

import br.ufsc.ine5633.controller.Controller;
import br.ufsc.ine5633.model.Musica;
import br.ufsc.ine5633.util.Properties;

import java.util.Scanner;

import static br.ufsc.ine5633.util.Properties.MSG_INICIO;

public class View {

    private static Scanner SCAN = new Scanner(System.in);
    private static Controller CONTROLLER = new Controller();

    public static void main(String[] args) {
        System.out.println(MSG_INICIO);
        selecionaMusica();
    }

    private static void selecionaMusica() {
        printaMusicas();

        String input = null;
        Integer idMusica = null;

        while (input == null || idMusica == null) {
            System.out.print(Properties.MSG_SELECAO_MUSICA);
            input = SCAN.next();

            boolean isIdMusica = input.matches("([0-9])");

            if (isIdMusica) {
                idMusica = Integer.valueOf(input);
                Musica musica = CONTROLLER.selecionaMusica(idMusica);
                if (musica != null) {
                    tocaMusica(musica);
                } else {
                    System.out.println(Properties.MSG_MUSICA_NAO_EXISTE);
                }
            }
        }
    }

    private static void tocaMusica(Musica musica) {
        musica.tocaMusica();
        System.out.println(Properties.MSG_TOCANDO_MUSICA + musica.toString());
        menuOpcoes(musica);
    }

    private static void menuOpcoes(Musica musica) {
        if (musica.isRecomendada()) {
            System.out.println(Properties.MSG_MENU_NAO_RECOMENDAR);
            opcaoMenu(musica, false);
        } else {
            System.out.println(Properties.MSG_MENU_RECOMENDAR);
            opcaoMenu(musica, true);
        }
    }

    private static void opcaoMenu(Musica musica, boolean recomendar) {
        String input = null;
        while (input == null) {
            input = SCAN.next();

            boolean opcaoMenu = input.matches("([1-3])");
            if (opcaoMenu) {
                switch (input) {
                    case "1":
                        recomendarMusica(musica, recomendar);
                        break;
                    case "2":
                        selecionaMusica();
                        break;
                    case "3":
                        pularMusica(musica);
                        break;
                    case "4":
                        SCAN.close();
                        break;
                }
            }
        }

    }

    private static void recomendarMusica(Musica musica, boolean recomendar) {
        CONTROLLER.recomendarMusica(musica, recomendar);
        System.out.println(String.format(Properties.MSG_RECOMENDAR_MUSICA, musica.toString()));
        menuOpcoes(musica);
    }

    private static void pularMusica(Musica musica) {
        Musica musicaAtual = CONTROLLER.pularMusica(musica);
        tocaMusica(musicaAtual);
    }

    private static void printaMusicas() {
        System.out.println(Properties.MSG_LISTA_MUSICAS);
        String printaMusicas = CONTROLLER.printaMusicas();
        System.out.println("\n" + printaMusicas);
    }
}
