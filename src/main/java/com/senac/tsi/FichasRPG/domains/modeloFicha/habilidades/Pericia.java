package com.senac.tsi.FichasRPG.domains.modeloFicha.habilidades;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.*;

import java.util.Objects;

@Embeddable
public class Pericia {
    @NotBlank(message = "Nome da Pericia é obrigatório")
    @Size(min = 1,max = 255,message = "numero de caracteres invalidos")
    private String nomeTag;

    @PositiveOrZero
    @Min(0)
    @Max(100)
    private int valor;

    //CONSTRUCTORs
    public Pericia(){}

    public Pericia(String nomeTag, int valor) {
        setNome(nomeTag);
        setValor(valor);
    }

    //GETTERs e SETTERs
    public String getNome() {
        return nomeTag;
    }
    public void setNome(String nomeTag) {
        this.nomeTag = nomeTag;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }

    //METODOS

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pericia pericia = (Pericia) o;
        return valor == pericia.valor && Objects.equals(nomeTag, pericia.nomeTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeTag, valor);
    }

    @Override
    public String toString() {
        return """
            Pericia{
                nomeTag='%s',
                valor=%d
            }
            """.formatted(nomeTag, valor);
    }
}
