package com.sahaj.tambola.GameEnngine.GameProcessor;


import com.sahaj.tambola.GameEnngine.GameProcessor.Enum.SequenceName;
import com.sahaj.tambola.GameEnngine.Impl.GameImpl;
import com.sahaj.tambola.GameEnngine.Ticket;

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
