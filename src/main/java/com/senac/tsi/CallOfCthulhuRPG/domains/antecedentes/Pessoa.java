package com.senac.tsi.CallOfCthulhuRPG.domains.antecedentes;

import com.senac.tsi.CallOfCthulhuRPG.domains.compartilhado.Genero;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Pessoa {

    private String nome;
    private int idade;
    private Genero genero;
    private String relacao;

    //CONSTRUCTORS
    public Pessoa(){}
    public Pessoa(String nome, int idade, Genero genero, String relacao) {
        setNome(nome);
        setIdade(idade);
        setGenero(genero);
        setRelacao(relacao);
    }

    //GETTERs e SETTERs
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getRelacao() {
        return relacao;
    }
    public void setRelacao(String relacao) {
        this.relacao = relacao;
    }

    //METODOS

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return idade == pessoa.idade && Objects.equals(nome, pessoa.nome) && genero == pessoa.genero && Objects.equals(relacao, pessoa.relacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade, genero, relacao);
    }

    @Override
    public String toString() {
        return """
            Ferimento{ 
                Nome = %s 
                Idade = %s
                Genero = %s
                relação = %s  
            }""".formatted(nome,idade,genero,relacao);
    }
}
