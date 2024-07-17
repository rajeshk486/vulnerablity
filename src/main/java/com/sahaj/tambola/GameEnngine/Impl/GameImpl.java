package com.sahaj.tambola.GameEnngine.Impl;

import com.sahaj.tambola.GameEnngine.Game;
import com.sahaj.tambola.GameEnngine.Ticket;

import java.util.List;

public abstract class GameImpl implements Game {
    @Override
    public boolean validateClaim(Ticket ticket, List<Integer> announcedNumbers, int order) {
        List<Integer> line = ticket.getNumbers().get(order);
        for (Integer number : line) {
            if (number != null && !announcedNumbers.contains(number)) {
                return false;
            }
        }
        return true;
    }
}
