package Tamola.Game.GameProcessor;

import Tamola.Game.Impl.GameImpl;
import Tamola.Game.GameProcessor.Enum.SequenceName;

public class TopLineGame extends GameImpl {

    @Override
    public String getName() {
        return SequenceName.TOPLINE.getGameName();
    }
}
