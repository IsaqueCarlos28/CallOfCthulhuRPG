package com.senac.tsi.FichasRPG.domains.tags;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
public class Tag {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(min = 2,max = 30,message = "Numero de caracteres Invalidos")
    @Column(length = 30,nullable = false)
    private String nome;

    //CONSTRUCTORs
    public Tag(){}
    public Tag(String tagName){
        setNome(tagName);
    }

    //GETTER e SETTER


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //METODOS

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return """
                id: %d
                tag: %s
                """.formatted(id,nome);
    }
}
