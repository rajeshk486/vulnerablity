package com.sahaj.tambola.GameEnngine;

import java.util.List;

public interface Game {
    boolean validateClaim(Ticket ticket, List<Integer> announcedNumbers, int order);
    String getName();
}
