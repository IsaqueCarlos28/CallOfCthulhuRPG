package com.senac.tsi.CallOfCthulhuRPG.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;

public class FichaNotFoundException extends ChangeSetPersister.NotFoundException {
    public FichaNotFoundException(String message) {
        super();
    }
}
