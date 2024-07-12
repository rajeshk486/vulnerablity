package Tamola.Game;

import Tamola.Ticket;

import java.util.List;

public interface Game {
    boolean validateClaim(Ticket ticket, List<Integer> announcedNumbers, int order);
    String getName();
}
