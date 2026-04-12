package com.senac.tsi.FichasRPG.repositories;

import com.senac.tsi.FichasRPG.domains.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepository extends JpaRepository<Tag,Long> {
}
