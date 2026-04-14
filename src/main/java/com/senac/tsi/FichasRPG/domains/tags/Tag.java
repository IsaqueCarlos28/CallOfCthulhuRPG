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
    private String nomeTag;

    //CONSTRUCTORs
    public Tag(){}
    public Tag(String tagName){
        setNomeTag(tagName);
    }

    //GETTER e SETTER


    public Long getId() {
        return id;
    }

    public String getNomeTag() {
        return nomeTag;
    }

    public void setNomeTag(String nomeTag) {
        this.nomeTag = nomeTag;
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
                """.formatted(id, nomeTag);
    }
}
