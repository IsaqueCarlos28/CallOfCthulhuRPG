package com.senac.tsi.FichasRPG.domains.modeloFicha;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Embeddable
public class CompanheiroCampanha {

    @NotBlank
    @Size(min = 1,max = 255,message = "numero de caracteres invalidos")
    private String nomeTag;

    @NotBlank
    @Size(min = 1,max = 255,message = "numero de caracteres invalidos")
    private String personagem;

    //CONSTRUCTORs
    public CompanheiroCampanha(){}
    public CompanheiroCampanha(String nomeTag,String personagem) {
        setNome(nomeTag);
        setPersonagem(personagem);
    }

    //GETTERs e SETTERs
    public String getPersonagem() {
        return personagem;
    }
    public void setPersonagem(String personagem) {
        this.personagem = personagem;
    }

    public String getNome() {
        return nomeTag;
    }
    public void setNome(String nomeTag) {
        this.nomeTag = nomeTag;
    }

    //METODOS

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CompanheiroCampanha that = (CompanheiroCampanha) o;
        return Objects.equals(nomeTag, that.nomeTag) &&
                Objects.equals(personagem, that.personagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeTag, personagem);
    }

    @Override
    public String toString() {
        return """
                CompanheiroCampanha{
                    Nome= %s,
                    Personagem= %s
                }""".formatted(nomeTag,personagem);
    }
}
