package de.my.tcg.game.rules.controller;

import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.domain.Player;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IndividualController {

    Player getPlayer();

    void showHandAndWaitForActiveAndBenchSelection();

    @Async
    CompletableFuture<PlayCard> selectActive();

    @Async
    CompletableFuture<List<PlayCard>> selectBench();
}
