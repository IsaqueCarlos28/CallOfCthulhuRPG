package com.senac.tsi.CallOfCthulhuRPG.domains.atributos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

import java.util.Objects;

@Entity
public class AtributoBasico {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private NomeAtributoBasico nome;

    @NotNull
    @Range(min = 1,max = 100,message = "O valor de atributo deve ser entre 1 e 100")
    private int valor;

    //CONSTRUCTORS

    public AtributoBasico(){}
    public AtributoBasico(NomeAtributoBasico nome, int valor){
        setNome(nome);
        setValor(valor);
    }

    //GETTER AND SETTER

    public Long getId() {
        return id;
    }

    public NomeAtributoBasico getNome() {
        return nome;
    }
    public void setNome(NomeAtributoBasico nome) {
        if (valor < 1 || valor > 100) {
            throw new RuntimeException("Valor deve estar entre 1 e 100");
        }
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }


    //METODOS

    public void addAtributo(int valorAdicionado){
        int novoValor = this.valor + valorAdicionado;

        if (novoValor > 100) {
            throw new RuntimeException("Valor do atributo não pode ser maior que 100");
        }

        this.valor = novoValor;
    }

    public int getMetade() {

        return valor / 2;
    }
    public int getQuinto() {
        return valor / 5;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AtributoBasico)) return false;
        AtributoBasico that = (AtributoBasico) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return """
                Atributo{ +
                Id = %s;
                Nome = %s;
                Valor = %s;
                Metade = %s;
                Quinto = %s;
                """.formatted(id,nome,valor,getMetade(),getQuinto());
    }
}
