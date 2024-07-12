package Tamola.Game.GameProcessor;

import Tamola.Game.Impl.GameImpl;
import Tamola.Game.GameProcessor.Enum.SequenceName;

public class BottomLineGame extends GameImpl {
    @Override
    public String getName() {
        return SequenceName.BOTTOMLINE.getGameName();
    }
}
