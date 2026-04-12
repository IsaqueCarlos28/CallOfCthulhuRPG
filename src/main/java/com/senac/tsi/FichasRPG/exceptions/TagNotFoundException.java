package com.senac.tsi.FichasRPG.exceptions;

public class TagNotFoundException extends RuntimeException {
    public TagNotFoundException(Long id) {
        super("Não foi possivel encontrar uma tag com o Id: " + id);
    }
}
