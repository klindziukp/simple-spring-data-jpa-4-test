/*
 * Copyright (c) 2023. Dandelion tutorials
 */

package com.klindziuk.data.jpa.data;

import com.klindziuk.data.jpa.model.Player;
import java.util.List;
import java.util.stream.Collectors;

public final class TestDataStorage {

  public static List<Player> playersByNationality(String nationality) {
    return players().stream().filter(player -> nationality.equals(player.getNationality()))
        .collect(Collectors.toList());
  }

  public static List<Player> playersByClub(String nationality) {
    return players().stream().filter(player -> nationality.equals(player.getClub()))
        .collect(Collectors.toList());
  }

  public static List<Player> players() {
    return List.of(
        new Player().setId(1L).setName("Son Heung-Min").setAge(29).setClub("Tottenham Hotspur")
            .setNationality("South Korea"),
        new Player().setId(2L).setName("Mohamed Salah").setAge(29).setClub("Liverpool")
            .setNationality("Egypt"),
        new Player().setId(3L).setName("James Maddison").setAge(31).setClub("Tottenham Hotspur")
            .setNationality("England"),
        new Player().setId(4L).setName("Bernardo Silva").setAge(25).setClub("Manchester City")
            .setNationality("Portugal"),
        new Player().setId(5L).setName("Kieran Trippier").setAge(32).setClub("Newcastle United")
            .setNationality("England"),
        new Player().setId(6L).setName("Mason Mount").setAge(23).setClub("Manchester United")
            .setNationality("England")
    );
  }

}
