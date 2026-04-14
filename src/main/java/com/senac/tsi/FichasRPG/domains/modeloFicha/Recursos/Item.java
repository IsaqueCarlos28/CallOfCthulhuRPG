package com.senac.tsi.FichasRPG.domains.modeloFicha.Recursos;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Embeddable
public class Item {

    @NotBlank(message = "Nome do item é obrigatorio")
    @Size(min = 1, max = 255)
    private String nomeTag;

    @NotNull
    @PositiveOrZero(message = "Preço do item não pode ser negativo")
    private float preco;

    //CONSTRUCTORs

    public Item(){}
    public Item(String nomeTag,float preco){
     setNome(nomeTag);
     setPreco(preco);
    }

    //GETTERs e SETTERs
    public String getNome() {
        return nomeTag;
    }
    public void setNome(String nomeTag) {
        this.nomeTag = nomeTag;
    }

    public Float getPreco() {
        return preco;
    }
    public void setPreco(Float preco) {
        this.preco = preco;
    }

    //METODOS;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Float.compare(preco, item.preco) == 0 &&
                Objects.equals(nomeTag, item.nomeTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeTag, preco);
    }

    @Override
    public String toString() {
        return """
                Item{
                    nomeTag='%s',
                    preco=%f
                }""".formatted(nomeTag, preco);
    }
}
