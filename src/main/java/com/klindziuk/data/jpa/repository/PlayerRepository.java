/*
 * Copyright (c) 2023. Dandelion tutorials
 */

package com.klindziuk.data.jpa.repository;

import com.klindziuk.data.jpa.model.Player;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

  List<Player> findByClub(String club);
  List<Player> findByNationality(String nationality);

}
