package com.sahaj.tambola.GameEnngine.Impl;
import com.sahaj.tambola.GameEnngine.Game;
import com.sahaj.tambola.GameEnngine.GameProcessor.*;
import com.sahaj.tambola.GameEnngine.GameProcessor.Enum.SequenceName;
import com.sahaj.tambola.GameEnngine.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameImplTest {

    private Game game;
    private Ticket ticket;

    @BeforeEach
    public void setUp() {
        ticket = mock(Ticket.class);
    }

    @Test
    public void testValidateClaimAcceptedTopLine() {
        game = getGame(SequenceName.TOPLINE);
        List<Integer> line = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> ticketNumbers = Collections.singletonList(line);
        when(ticket.getNumbers()).thenReturn(ticketNumbers);
        List<Integer> announcedNumbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean result = game.validateClaim(ticket, announcedNumbers, SequenceName.TOPLINE.getSequence());
        assertTrue(result);
    }
    @Test
    public void testValidateClaimRejectedTopLine() {
        game = getGame(SequenceName.TOPLINE);
        List<Integer> line = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> ticketNumbers = Collections.singletonList(line);
        when(ticket.getNumbers()).thenReturn(ticketNumbers);
        List<Integer> announcedNumbers = Arrays.asList(8,9,10);
        boolean result = game.validateClaim(ticket, announcedNumbers, SequenceName.TOPLINE.getSequence());
        assertFalse(result);
    }

    @Test
    public void testValidateClaimAcceptedEarlyFive() {
        game = getGame(SequenceName.EARLYFIVE);
        List<Integer> line = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> ticketNumbers = Collections.singletonList(line);
        when(ticket.getNumbers()).thenReturn(ticketNumbers);
        List<Integer> announcedNumbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean result = game.validateClaim(ticket, announcedNumbers, SequenceName.EARLYFIVE.getSequence());
        assertTrue(result);
    }

    @Test
    public void testValidateClaimRejectedEarlyFive() {
        game = getGame(SequenceName.EARLYFIVE);
        List<Integer> line = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> ticketNumbers = Collections.singletonList(line);
        when(ticket.getNumbers()).thenReturn(ticketNumbers);
        List<Integer> announcedNumbers = Arrays.asList(8, 9, 10);
        boolean result = game.validateClaim(ticket, announcedNumbers, SequenceName.EARLYFIVE.getSequence());
        assertFalse(result);
    }

    @Test
    public void testValidateClaimAcceptedMiddleLine() {
        game = getGame(SequenceName.MIDDLELINE);
        List<Integer> line = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> line1 = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> ticketNumbers = List.of(line,line1);
        when(ticket.getNumbers()).thenReturn(ticketNumbers);
        List<Integer> announcedNumbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean result = game.validateClaim(ticket, announcedNumbers, SequenceName.MIDDLELINE.getSequence());
        assertTrue(result);
    }

    @Test
    public void testValidateClaimRejectedMiddleLine() {
        game = getGame(SequenceName.MIDDLELINE);
        List<Integer> line = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> line1 = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> ticketNumbers = List.of(line,line1);
        when(ticket.getNumbers()).thenReturn(ticketNumbers);
        List<Integer> announcedNumbers = Arrays.asList(8, 9, 10);
        boolean result = game.validateClaim(ticket, announcedNumbers, SequenceName.MIDDLELINE.getSequence());
        assertFalse(result);
    }

    @Test
    public void testValidateClaimAcceptedFullHouse() {
        game = getGame(SequenceName.FULLHOUSE);
        List<Integer> line1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> line2 = Arrays.asList(6, 7, 8, 9, 10);
        List<Integer> line3 = Arrays.asList(11, 12, 13, 14, 15);
        List<List<Integer>> ticketNumbers = Arrays.asList(line1, line2, line3);
        when(ticket.getNumbers()).thenReturn(ticketNumbers);
        List<Integer> announcedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        boolean result = game.validateClaim(ticket, announcedNumbers, SequenceName.FULLHOUSE.getSequence());
        assertTrue(result);
    }

    @Test
    public void testValidateClaimRejectedFullHouse() {
        game = getGame(SequenceName.FULLHOUSE);
        List<Integer> line1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> line2 = Arrays.asList(6, 7, 8, 9, 10);
        List<Integer> line3 = Arrays.asList(11, 12, 13, 14, 15);
        List<List<Integer>> ticketNumbers = Arrays.asList(line1, line2, line3);
        when(ticket.getNumbers()).thenReturn(ticketNumbers);
        List<Integer> announcedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        boolean result = game.validateClaim(ticket, announcedNumbers, SequenceName.FULLHOUSE.getSequence());
        assertFalse(result);
    }

    @Test
    public void testValidateClaimAcceptedBottomLine() {
        game = getGame(SequenceName.BOTTOMLINE);
        List<Integer> line = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> line1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> line2 = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> ticketNumbers = List.of(line,line1,line2);
        when(ticket.getNumbers()).thenReturn(ticketNumbers);
        List<Integer> announcedNumbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean result = game.validateClaim(ticket, announcedNumbers, SequenceName.BOTTOMLINE.getSequence());
        assertTrue(result);
    }

    @Test
    public void testValidateClaimRejectedBottomLine() {
        game = getGame(SequenceName.BOTTOMLINE);
        List<Integer> line = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> line1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> line2 = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> ticketNumbers = List.of(line,line1,line2);
        when(ticket.getNumbers()).thenReturn(ticketNumbers);
        List<Integer> announcedNumbers = Arrays.asList(8, 9, 10);
        boolean result = game.validateClaim(ticket, announcedNumbers, SequenceName.BOTTOMLINE.getSequence());
        assertFalse(result);
    }

    private Game getGame(SequenceName sequenceName) {
        switch (sequenceName)
        {
            case TOPLINE -> {
            return new TopLineGame();}
            case EARLYFIVE -> {
            return new EarlyFiveGame();}
            case MIDDLELINE -> {
                return new MiddleLineGame();}
            case FULLHOUSE -> {
                return new FullHouseGame();}
            case BOTTOMLINE -> {
                return new BottomLineGame();}
        }
        return  null;
        }
}
