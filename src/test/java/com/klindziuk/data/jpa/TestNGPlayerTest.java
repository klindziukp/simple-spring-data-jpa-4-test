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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@ContextConfiguration(classes = JpaConfig.class)
public class TestNGPlayerTest extends AbstractTestNGSpringContextTests {

  public static final Logger LOGGER = LogManager.getLogger(TestNGPlayerTest.class);

  @Autowired  PlayerRepository playerRepository;

  @BeforeTest
  public void beforeTest() {
    LOGGER.info("Test script execution started with TestNG");
  }

  @AfterTest
  public void afterTest() {
    LOGGER.info("Test script execution finished with TestNG");
  }

  @Test
  public void testAllPlayersWithTestNG() {
    final Iterable<Player> allPlayers = playerRepository.findAll();
    LOGGER.info("List of players: {}", allPlayers);

    Assertions.assertThat(allPlayers)
        .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
        .isEqualTo(TestDataStorage.players());
  }

  @Test
  public void testPlayersByNationalityWithTestNG() {
    final String nationality = "England";
    final Iterable<Player> playersByNationality = playerRepository.findByNationality(nationality);
    LOGGER.info("List of players by nationality: {}", playersByNationality);

    Assertions.assertThat(playersByNationality)
        .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
        .isEqualTo(TestDataStorage.playersByNationality(nationality));
  }

  @Test
  public void testPlayersByClubWithTestNG() {
    final String club = "Tottenham Hotspur";
    final Iterable<Player> playersByNationality = playerRepository.findByClub(club);
    LOGGER.info("List of players by club: {}", playersByNationality);

    Assertions.assertThat(playersByNationality)
        .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
        .isEqualTo(TestDataStorage.playersByClub(club));
  }
}
