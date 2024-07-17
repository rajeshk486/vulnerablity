package com.sahaj.tambola.GameEnngine;


import com.sahaj.tambola.GameEnngine.GameProcessor.Enum.SequenceName;

import java.util.List;

public class Validator {
    private List<Game> games;

    //constructor
    public Validator(List<Game> games) {
        this.games = games;
    }
    public String validateClaim(Player player, List<Integer> announcedNumbers, String claimedGame) {
        for (Game game : games) {
            if (game.getName().equalsIgnoreCase(claimedGame)) {
                int order = SequenceName.getSequence(game.getName());
                return game.validateClaim(player.getTicket(), announcedNumbers, order) ? "Accepted" : "Rejected";
            }
        }
        return "Rejected";
    }
}
