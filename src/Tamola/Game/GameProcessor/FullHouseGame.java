package Tamola.Game.GameProcessor;

import Tamola.Game.Impl.GameImpl;
import Tamola.Game.GameProcessor.Enum.SequenceName;
import Tamola.Ticket;

import java.util.List;

public class FullHouseGame extends GameImpl {
    @Override
    public boolean validateClaim(Ticket ticket, List<Integer> announcedNumbers, int order) {
        for (List<Integer> row : ticket.getNumbers()) {
            for (Integer number : row) {
                if (!announcedNumbers.contains(number)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String getName() {
        return SequenceName.FULLHOUSE.getGameName();
    }
}
