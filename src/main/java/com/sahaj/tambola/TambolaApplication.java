package com.sahaj.tambola;

import com.sahaj.tambola.GameEnngine.Game;
import com.sahaj.tambola.GameEnngine.GameProcessor.*;
import com.sahaj.tambola.GameEnngine.Player;
import com.sahaj.tambola.GameEnngine.Ticket;
import com.sahaj.tambola.GameEnngine.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
import java.util.concurrent.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class TambolaApplication {
	private static final Logger logger = LogManager.getLogger(TambolaApplication.class);
	public static void main(String[] args) throws InterruptedException, ExecutionException {
//Tickets for player1
		List<List<Integer>> ticketNumbers1 = new ArrayList<>();
		ticketNumbers1.add(Arrays.asList(4, 16, null, null, 48, null, 63, 76, null));
		ticketNumbers1.add(Arrays.asList(7, null, 23, 38, null, 52, null, null, 80));
		ticketNumbers1.add(Arrays.asList(9, null, 25, null, null, 56, 64, null, 83));
		Ticket ticket1 = new Ticket(ticketNumbers1);
//Tickets for player2
		List<List<Integer>> ticketNumbers2 = new ArrayList<>();
		ticketNumbers2.add(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		ticketNumbers2.add(Arrays.asList(10, 11, 12, 13, 14, 15, 16, 17, 18));
		ticketNumbers2.add(Arrays.asList(19, 20, 21, 22, 23, 24, 25, 26, 27));
		Ticket ticket2 = new Ticket(ticketNumbers2);
//Adding players with their ticket
		Player player1 = new Player("Rajesh", ticket1);
		Player player2 = new Player("Ramya", ticket2);

// Initialize games
		List<Game> games = Arrays.asList(
				new TopLineGame(),
				new MiddleLineGame(),
				new BottomLineGame(),
				new FullHouseGame(),
				new EarlyFiveGame()
		);

// Announced numbers
		List<Integer> announcedNumbers = Arrays.asList(90, 4, 46, 63, 89, 16, 76, 48);

		/* GAME Engine */
		// 1. engine validates the player,input
		// 2. from validation it goes to game logic process
		// 3. as per the game logic, it ll go to iteration or decide the win/loss
// Validator
		Validator validator = new Validator(games);
		String claim = "Top Line";
//Logic processor to process synchronously
        /*System.out.println(player1.getName() + "'s claim: " + claim + " -> " + validator.validateClaim(player1, announcedNumbers, claim));
        System.out.println(player2.getName() + "'s claim: " + claim + " -> " + validator.validateClaim(player2, announcedNumbers, claim));*/
//Logic to process async, since tickets will be striked or verified all at a time.
// callable task set for each player
		Callable<String> player1Task = () -> player1.getName() + "'s claim: Top Line -> " + validator.validateClaim(player1, announcedNumbers, claim);
		Callable<String> player2Task = () -> player2.getName() + "'s claim: Top Line -> " + validator.validateClaim(player2, announcedNumbers, claim);
// Use ExecutorService to run tasks in parallel
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		List<Future<String>> results = executorService.invokeAll(Arrays.asList(player1Task, player2Task));
		for (Future<String> result : results) {
			System.out.println(result.get());
		}
		executorService.shutdown();
run();
		SpringApplication.run(TambolaApplication.class, args);
	}
	public static void run() {
		logger.debug("Debugging log");
		logger.info("Info log");
		logger.warn("Hey, This is a warning!");
		logger.error("Oops! We have an Error. OK");
		logger.fatal("Damn! Fatal error. Please fix me.");
	}
}


