package com.senac.tsi.CallOfCthulhuRPG.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

public class HabilidadesNotFoundException extends ChangeSetPersister.NotFoundException {
    public HabilidadesNotFoundException(String message) {
        super();
    }
}
