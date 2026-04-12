package com.senac.tsi.FichasRPG.domains.usuario;

import com.senac.tsi.FichasRPG.domains.campanhas.Jogador;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(min = 1,max = 150,message = "numero de caracteres invalido")
    private String nome;

    @NotBlank
    @Size(min = 1,max = 150,message = "numero de caracteres invalido")
    private String email;

    @OneToMany
    @NotNull
    private Set<Ficha> fichasUsuario = new HashSet<>();

    @OneToMany
    @NotNull
    private Set<Jogador> mesasParticipadas = new HashSet<>();

    //CONSTRUCTORS
    private

    //GETTERs e SETTERs

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Ficha> getFichasUsuario() {
        return fichasUsuario;
    }

    public void setFichasUsuario(Set<Ficha> fichasUsuario) {
        this.fichasUsuario = fichasUsuario;
    }

    public Set<Jogador> getMesasParticipadas() {
        return mesasParticipadas;
    }

    public void setMesasParticipadas(Set<Jogador> mesasParticipadas) {
        this.mesasParticipadas = mesasParticipadas;
    }
}
