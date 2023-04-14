package de.my.tcg.game.rules.controller;

import de.my.tcg.game.BasicGame;
import de.my.tcg.game.domain.PlayCard;
import de.my.tcg.game.rules.formatsettings.StandardFormat;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;

//https://spring.io/guides/gs/async-method/
@Component
public class GeneralGameController implements CommandLineRunner {
    IndividualController controller1;
    IndividualController controller2;
    BasicGame basicGame;

    public GeneralGameController(IndividualController controller1, IndividualController controller2) {
        this.controller1 = controller1;
        this.controller2 = controller2;
    }

    public void startGame() {
        basicGame = new BasicGame(controller1.getPlayer(), controller2.getPlayer(), new StandardFormat());
        basicGame.startOfGame();
        controller1.showHandAndWaitForActiveAndBenchSelection();
        controller2.showHandAndWaitForActiveAndBenchSelection();
    }


    @Override
    public void run(String... args) throws Exception {
        startGame();
        CompletableFuture<PlayCard> active1 = controller1.selectActive();
        CompletableFuture<PlayCard> active2 = controller2.selectActive();
        CompletableFuture<List<PlayCard>> bench1 = controller1.selectBench();
        CompletableFuture<List<PlayCard>> bench2 = controller2.selectBench();


        CompletableFuture.allOf(active1, active2, bench1, bench2);
        basicGame.addActiveToPlayMate(controller1.getPlayer(), active1.get());

    }
}
