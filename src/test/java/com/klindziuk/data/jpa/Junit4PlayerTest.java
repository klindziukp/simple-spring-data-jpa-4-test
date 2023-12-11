/*
 * Copyright (c) 2023. Dandelion tutorials
 */

package com.klindziuk.data.jpa;

import com.klindziuk.data.jpa.config.RepositoryConfig;
import com.klindziuk.data.jpa.data.TestDataStorage;
import com.klindziuk.data.jpa.model.Player;
import com.klindziuk.data.jpa.repository.PlayerRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = RepositoryConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class Junit4PlayerTest {

  public static final Logger LOGGER = LogManager.getLogger(Junit4PlayerTest.class);

  @Autowired PlayerRepository playerRepository;

  @Before
  public void before() {
    LOGGER.info("Test script execution started with Junit 4");
  }

  @After
  public void after() {
    LOGGER.info("Test script execution finished with Junit 4");
  }

  @Test
  public void testAllPlayersWithJunit4() {
    final Iterable<Player> allPlayers = playerRepository.findAll();
    LOGGER.info("List of players: {}", allPlayers);

    Assertions.assertThat(allPlayers)
        .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
        .isEqualTo(TestDataStorage.players());
  }

  @Test
  public void testPlayersByNationalityWithJunit4() {
    final String nationality = "England";
    final Iterable<Player> playersByNationality = playerRepository.findByNationality(nationality);
    LOGGER.info("List of players by nationality: {}", playersByNationality);

    Assertions.assertThat(playersByNationality)
        .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
        .isEqualTo(TestDataStorage.playersByNationality(nationality));
  }

  @Test
  public void testPlayersByClubWithJunit4() {
    final String club = "Tottenham Hotspur";
    final Iterable<Player> playersByNationality = playerRepository.findByClub(club);
    LOGGER.info("List of players by club: {}", playersByNationality);

    Assertions.assertThat(playersByNationality)
        .usingRecursiveFieldByFieldElementComparatorIgnoringFields("id")
        .isEqualTo(TestDataStorage.playersByClub(club));
  }
}
