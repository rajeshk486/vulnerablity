package com.sahaj.tambola.GameEnngine.GameProcessor;


import com.sahaj.tambola.GameEnngine.GameProcessor.Enum.SequenceName;
import com.sahaj.tambola.GameEnngine.Impl.GameImpl;

public class BottomLineGame extends GameImpl {
    @Override
    public String getName() {
        return SequenceName.BOTTOMLINE.getGameName();
    }
}
