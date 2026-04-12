package com.senac.tsi.FichasRPG.services;

import com.senac.tsi.FichasRPG.domains.modeloFicha.ModeloFicha;
import com.senac.tsi.FichasRPG.domains.modeloFicha.Recursos.RecursosFicha;
import com.senac.tsi.FichasRPG.domains.modeloFicha.atributos.AtributosFicha;
import com.senac.tsi.FichasRPG.domains.modeloFicha.habilidades.HabilidadesFicha;
import com.senac.tsi.FichasRPG.domains.modeloFicha.historico.HistoricoFicha;
import com.senac.tsi.FichasRPG.domains.modeloFicha.personagens.Personagem;

public class FichasService {

    public ModeloFicha criarFichaVazia(){
        AtributosFicha atributos = new AtributosFicha();
        HabilidadesFicha habilidades = new HabilidadesFicha();
        HistoricoFicha historico = new HistoricoFicha();
        Personagem investigador = new Personagem();
        RecursosFicha recursos = new RecursosFicha();

        return new ModeloFicha();

    }

}
