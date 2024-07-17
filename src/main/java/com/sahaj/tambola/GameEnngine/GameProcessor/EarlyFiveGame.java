package com.sahaj.tambola.GameEnngine.GameProcessor;


import com.sahaj.tambola.GameEnngine.Impl.GameImpl;
import com.sahaj.tambola.GameEnngine.Ticket;
import com.sahaj.tambola.GameEnngine.GameProcessor.Enum.SequenceName;

import java.util.List;

public class EarlyFiveGame extends GameImpl {
    @Override
    public boolean validateClaim(Ticket ticket, List<Integer> announcedNumbers, int order) {
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
