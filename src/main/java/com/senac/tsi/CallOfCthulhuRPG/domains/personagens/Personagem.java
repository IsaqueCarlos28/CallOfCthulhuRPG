package com.senac.tsi.CallOfCthulhuRPG.domains.personagens;

import com.senac.tsi.CallOfCthulhuRPG.domains.compartilhado.Genero;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Personagem {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @NotBlank(message = "O Nome do Investigador não estar em branco")
    @Size(min = 1,max = 150)
    private String nomeInvestigador;

    @NotNull
    @NotBlank(message = "Ocupação é obrigatorio")
    @Size(min = 1,max = 150)
    private String ocupacao;

    @NotNull
    @NotBlank(message = "O nome do investigador não estar em branco")
    @Size(min = 1,max = 150)
    private String formacaoAcademica;

    @NotNull
    @NotBlank(message = "Local de nascimento não pode estar em branco")
    @Size(min = 1, max = 150)
    private String localNascimento;

    private List<String>transtornosMentais;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @NotNull(message = "")
    private int age;

    //GETTER AND SETTER
    public String getNomeInvestigador() {
        return nomeInvestigador;
    }
    public void setNomeInvestigador(String nomeInvestigador) {
        this.nomeInvestigador = nomeInvestigador;
    }

    public String getOcupacao() {
        return ocupacao;
    }
    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getFormacaoAcademica() {
        return formacaoAcademica;
    }
    public void setFormacaoAcademica(String formacaoAcademica) {
        this.formacaoAcademica = formacaoAcademica;
    }

    public String getLocalNascimento() {
        return localNascimento;
    }
    public void setLocalNascimento(String localNascimento) {
        this.localNascimento = localNascimento;
    }

    public List<String> getTranstornosMentais() {
        return transtornosMentais;
    }
    public void setTranstornosMentais(List<String> transtornosMentais) {
        this.transtornosMentais = transtornosMentais;
    }

    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
