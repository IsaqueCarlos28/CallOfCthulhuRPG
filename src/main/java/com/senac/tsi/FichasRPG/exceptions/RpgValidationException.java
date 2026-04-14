package com.senac.tsi.FichasRPG.exceptions;

public class RpgValidationException extends RuntimeException {
    private final String processo;
    private final String parametroErrado;
    private final String parametroEsperado;
    public RpgValidationException(String processo,String parametroErrado,String parametroEsperado) {
        super("Parametro invalido");
        this.processo = processo;
        this.parametroErrado = parametroErrado;
        this.parametroEsperado = parametroEsperado;
    }
    public String getProcesso(){return this.processo;}
    public String getParametroErrado(){return this.parametroErrado;}
    public String getParametroEsperado(){return this.parametroEsperado;}
}
