package com.senac.tsi.FichasRPG.repositories;

import com.senac.tsi.FichasRPG.domains.modeloFicha.personagens.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloFichaRepository extends JpaRepository<Personagem,Long> {
}
