package com.senac.tsi.FichasRPG.repositories;

import com.senac.tsi.FichasRPG.domains.campanhas.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador,Long> {
}
