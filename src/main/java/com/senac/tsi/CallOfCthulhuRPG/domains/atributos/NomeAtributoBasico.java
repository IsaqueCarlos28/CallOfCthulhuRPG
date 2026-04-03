package com.senac.tsi.CallOfCthulhuRPG.domains.atributos;

public enum NomeAtributoBasico {
    FOR("Força"),DES("Destreza"),INT("Inteligência"),
    CON("Constituição"),APA("Aparência"),POD("Poder"),
    TAM("Tamanho"),SAN("Sanidade"),EDU("Educação");

    private String atributo;

    NomeAtributoBasico(String atributo){
        this.atributo = atributo;
    }
}
