package com.senac.tsi.FichasRPG.repositories;

import com.senac.tsi.FichasRPG.domains.usuario.FichaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichaUsuarioRepository extends JpaRepository<FichaUsuario,Long> {
}
