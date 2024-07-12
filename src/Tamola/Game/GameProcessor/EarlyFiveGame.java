package Tamola.Game.GameProcessor;

import Tamola.Game.Impl.GameImpl;
import Tamola.Game.GameProcessor.Enum.SequenceName;
import Tamola.Ticket;
import java.util.List;

public class EarlyFiveGame extends GameImpl {
    @Override
    public boolean validateClaim(Ticket ticket, List<Integer> announcedNumbers,int order) {
        int count = 0;
        for (List<Integer> row : ticket.getNumbers()) {
            for (Integer number : row) {
                if (announcedNumbers.contains(number)) {
                    count++;
                }
                if (count == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getName() {
        return SequenceName.EARLYFIVE.getGameName();
    }
}
