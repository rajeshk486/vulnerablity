package com.sahaj.tambola.GameEnngine.GameProcessor;
import com.sahaj.tambola.GameEnngine.GameProcessor.Enum.SequenceName;
import com.sahaj.tambola.GameEnngine.Impl.GameImpl;
import com.sahaj.tambola.GameEnngine.Ticket;
public class MiddleLineGame extends GameImpl {
    @Override
    public String getName() {
        return SequenceName.MIDDLELINE.getGameName();
    }
}
