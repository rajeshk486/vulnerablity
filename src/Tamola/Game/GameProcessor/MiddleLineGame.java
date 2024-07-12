package Tamola.Game.GameProcessor;

import Tamola.Game.Impl.GameImpl;
import Tamola.Game.GameProcessor.Enum.SequenceName;

public class MiddleLineGame extends GameImpl {
    @Override
    public String getName() {
        return SequenceName.MIDDLELINE.getGameName();
    }
}
