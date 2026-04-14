package com.senac.tsi.FichasRPG.repositories;

import com.senac.tsi.FichasRPG.domains.modeloFicha.ModeloFicha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloFichaRepository extends JpaRepository<ModeloFicha,Long> {
}
