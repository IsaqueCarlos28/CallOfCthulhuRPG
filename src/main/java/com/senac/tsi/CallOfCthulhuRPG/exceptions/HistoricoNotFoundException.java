package com.senac.tsi.CallOfCthulhuRPG.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

public class HistoricoNotFoundException extends ChangeSetPersister.NotFoundException {
    public HistoricoNotFoundException(String message) {
        super();
    }
}
