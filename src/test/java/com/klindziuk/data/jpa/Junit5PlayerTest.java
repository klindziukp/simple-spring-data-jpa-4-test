/*
 * Copyright (c) 2023. Dandelion tutorials
 */

package com.klindziuk.data.jpa;

import com.klindziuk.data.jpa.config.JpaConfig;
import com.klindziuk.data.jpa.data.TestDataStorage;
import com.klindziuk.data.jpa.model.Player;
import com.klindziuk.data.jpa.repository.PlayerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = JpaConfig.class)
@ExtendWith(SpringExtension.class)
class Junit5PlayerTest {

  public static final Logger LOGGER = LogManager.getLogger(Junit5PlayerTest.class);

  @Autowired  PlayerRepository playerRepository;

  @BeforeEach
  public void beforeEach() {
    LOGGER.info("Test script execution started with Junit 5");
  }

  @AfterEach
  public void afterEach() {
    LOGGER.info("Test script execution finished with Junit 5");
  }

  @Test
  public void testAllPlayersWithJunit5() {
    final Iterable<Player> allPlayers = playerRepository.findAll();
    LOGGER.info("List of players: {}", allPlayers);

    Assertions.assertThat(allPlayers)
        .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
        .isEqualTo(TestDataStorage.players());
  }

  @Test
  public void testPlayersByNationalityWithJunit5() {
    final String nationality = "England";
    final Iterable<Player> playersByNationality = playerRepository.findByNationality(nationality);
    LOGGER.info("List of players by nationality: {}", playersByNationality);

    Assertions.assertThat(playersByNationality)
        .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
        .isEqualTo(TestDataStorage.playersByNationality(nationality));
  }

  @Test
  public void testPlayersByClubWithJunit5() {
    final String club = "Tottenham Hotspur";
    final Iterable<Player> playersByNationality = playerRepository.findByClub(club);
    LOGGER.info("List of players by club: {}", playersByNationality);

    Assertions.assertThat(playersByNationality)
        .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
        .isEqualTo(TestDataStorage.playersByClub(club));
  }
}
