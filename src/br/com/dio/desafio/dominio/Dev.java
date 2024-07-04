package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {

    private String nome;
    // utilizando set e linkedhashset para garantir a ordem de inserção
    // além de evitar duplicidade
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        // adiciona todos os conteúdos do bootcamp na lista de inscritos
        conteudosInscritos.addAll(bootcamp.getConteudos());
        // adiciona o dev na lista de inscritos do bootcamp
        bootcamp.getDevsInscritos().add(this);
    }

    // A regra de negócio para progredir é adicionar o primeiro conteúdo na lista de concluídos
    public void progredir() {
        // utilizando optional para evitar nullpointer
        Optional<Conteudo> primeiroConteudo = conteudosInscritos.stream().findFirst();
        // tratando exceção caso não haja conteúdos para progredir
        try {
            // se houver conteúdo, adiciona na lista de concluídos e remove da lista de inscritos
            if (primeiroConteudo.isPresent()) {
                conteudosConcluidos.add(primeiroConteudo.get());
                conteudosInscritos.remove(primeiroConteudo.get());
            } else {
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e) {
            System.err.println("Erro: não há conteúdos para progredir");
        }
    }

    public double calcularTotalXP() {
        // somando o xp de todos os conteúdos concluídos
        return conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(getNome(), dev.getNome()) && Objects.equals(getConteudosInscritos(), dev.getConteudosInscritos()) && Objects.equals(getConteudosConcluidos(), dev.getConteudosConcluidos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getConteudosInscritos(), getConteudosConcluidos());
    }
}
