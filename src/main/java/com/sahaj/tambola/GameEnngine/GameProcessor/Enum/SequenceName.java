package com.sahaj.tambola.GameEnngine.GameProcessor.Enum;

public enum SequenceName {
    TOPLINE("Top Line",0),
    BOTTOMLINE("Bottom Line",2),
    EARLYFIVE("Early Five",3),
    FULLHOUSE("Full House",4),
    MIDDLELINE("Middle Line",1);
    private String gameName;
    private int sequence;
    private SequenceName(String gameName, int sequence)
    {
        this.gameName = gameName;
        this.sequence = sequence;
    }
    public String getGameName(){
        return gameName;
    }
    public int getSequence() {
        return sequence;
    }

    public static int getSequence(String gameName){
        for (SequenceName sequenceName : SequenceName.values()) {
            if (sequenceName.getGameName().equalsIgnoreCase(gameName)) {
                return sequenceName.getSequence();
            }
        }
        throw new IllegalArgumentException("No such game: " + gameName);
    }
}
