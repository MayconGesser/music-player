package br.ufsc.ine5633.controller;

import br.ufsc.ine5633.model.Musica;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    private List<Musica> musicas;
    private Musica musicaAtual;

    public Controller() {
        iniciaMusicas();
    }

    public Musica selecionaMusica(Integer idMusica) {
        musicaAtual = musicas.get(idMusica);
        return musicaAtual;
    }

    public Musica pularMusica(Musica musica) {
        ordenaMusicas(musica);
        musicaAtual = this.musicas.iterator().next();
        return musicaAtual;
    }

    public void recomendarMusica(Musica musica, boolean recomendar) {
        musica.setRecomendada(recomendar);
    }

    public String printaMusicas() {
        ordenaMusicas(null);
        return this.musicas.stream()
                .map(musica -> this.musicas.indexOf(musica) + ". " + musica.toString())
                .collect(Collectors.joining("\n"));
    }

    private void ordenaMusicas(Musica musica) {
        Comparator<Musica> myComparator = (o1, o2) -> {
            Integer o1QtdTocada = o1.getQtdTocada();
            Integer o2QtdTocada = o2.getQtdTocada();
            if (musica != null) {
                if (musica.getNome().equals(o1.getNome())) {
                    o1QtdTocada = -1;
                } else if (musica.getNome().equals(o2.getNome())) {
                    o2QtdTocada = -1;
                }
            }
            int result = o2QtdTocada.compareTo(o1QtdTocada);

            if (result == 0) {
                return o2.isRecomendada().compareTo(o1.isRecomendada());
            }
            return result;
        };

        Collections.sort(this.musicas, myComparator);
    }

    private void iniciaMusicas() {
        this.musicas = Arrays.asList(
                new Musica()
                        .setNome("Tempo Perdido")
                        .setBanda("Legião Urbana")
                        .setArtista("Legião Urbana")
                        .setCompositor("Renato Russo")
                        .setDuracaoSegundos(1)
                        .setRecomendada(false),
                new Musica()
                        .setNome("Pais e Filhos")
                        .setBanda("Legião Urbana")
                        .setArtista("Legião Urbana")
                        .setCompositor("Renato Russo")
                        .setDuracaoSegundos(1)
                        .setRecomendada(false),
                new Musica()
                        .setNome("Eduardo e Monica")
                        .setBanda("Legião Urbana")
                        .setArtista("Legião Urbana")
                        .setCompositor("Renato Russo")
                        .setDuracaoSegundos(1)
                        .setRecomendada(false)
        );

    }
}
