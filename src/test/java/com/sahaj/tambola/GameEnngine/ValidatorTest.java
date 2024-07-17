package com.sahaj.tambola.GameEnngine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class ValidatorTest {
    private Validator validator;
    private Game game;
    private Player player;

    @BeforeEach
    public void setUp() {
        game = mock(Game.class);
        player = mock(Player.class);
        validator = new Validator(Arrays.asList(game));
    }

    @Test
    public void testValidateClaimAccepted() {
        when(game.getName()).thenReturn("Top Line");
        List<List<Integer>> ticketNumbers = new ArrayList<>();
        ticketNumbers.add(Arrays.asList(4, 16, null, null, 48, null, 63, 76, null));
        when(player.getTicket()).thenReturn(new Ticket(ticketNumbers));
        when(game.validateClaim(any(), anyList(), anyInt())).thenReturn(true);
        List<Integer> announcedNumbers = Arrays.asList(90, 4, 46, 63, 89, 16, 76, 48);
        String result = validator.validateClaim(player, announcedNumbers, "Top Line");
        assertEquals("Accepted", result);
    }
    @Test
    public void testValidateClaimRejected() {
        when(game.getName()).thenReturn("Top Line");
        List<List<Integer>> ticketNumbers = new ArrayList<>();
        ticketNumbers.add(Arrays.asList(4, 16, null, null, 48, null, 63, 76, null));
        when(player.getTicket()).thenReturn(new Ticket(ticketNumbers));
        when(game.validateClaim(any(), anyList(), anyInt())).thenReturn(false);
        List<Integer> announcedNumbers = Arrays.asList(90, 4, 46, 63, 89, 16, 76);
        String result = validator.validateClaim(player, announcedNumbers, "Top Line");
        assertEquals("Rejected", result);
    }
}
