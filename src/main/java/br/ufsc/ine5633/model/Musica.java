package br.ufsc.ine5633.model;

public class Musica {
    private String nome;
    private String artista;
    private String compositor;
    private String banda;
    private Integer duracaoSegundos;
    private Boolean recomendada;
    private Integer qtdTocada;

    public String getNome() {
        return nome;
    }

    public Musica setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getArtista() {
        return artista;
    }

    public Musica setArtista(String artista) {
        this.artista = artista;
        return this;
    }

    public String getCompositor() {
        return compositor;
    }

    public Musica setCompositor(String compositor) {
        this.compositor = compositor;
        return this;
    }

    public String getBanda() {
        return banda;
    }

    public Musica setBanda(String banda) {
        this.banda = banda;
        return this;
    }

    public Integer getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public Musica setDuracaoSegundos(Integer duracaoSegundos) {
        this.duracaoSegundos = duracaoSegundos;
        return this;
    }

    public Boolean isRecomendada() {
        return recomendada;
    }

    public Musica setRecomendada(Boolean recomendada) {
        this.recomendada = recomendada;
        return this;
    }

    public Integer getQtdTocada() {
        if (qtdTocada == null) {
            qtdTocada = 0;
        }
        return qtdTocada;
    }

    public Musica tocaMusica() {
        if (qtdTocada == null) {
            qtdTocada = 1;
        } else {
            qtdTocada++;
        }
        return this;
    }

    @Override
    public String toString() {
        return nome + " - " + artista + " - " + getQtdTocada() + " - " + recomendada;
    }
}
