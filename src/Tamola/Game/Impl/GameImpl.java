package Tamola.Game.Impl;

import Tamola.Game.Game;
import Tamola.Ticket;
import java.util.List;

public abstract class GameImpl implements Game {
    @Override
    public boolean validateClaim(Ticket ticket, List<Integer> announcedNumbers,int order) {
        List<Integer> line = ticket.getNumbers().get(order);
        for (Integer number : line) {
            if (number != null && !announcedNumbers.contains(number)) {
                return false;
            }
        }
        return true;
    }
}
