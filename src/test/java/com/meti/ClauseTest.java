package com.meti;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author SirMathhman
 * @version 0.0.0
 * @since 1/14/2019
 */
public class ClauseTest {

    @Test
    public void acceptNoThrows() {
        NoThrowsClause clause = new NoThrowsClause();
        String[] args = {"foo", "bar"};

        clause.accept(args);
        assertFalse(clause.callback.hasException());
        assertArrayEquals(args, clause.parameters);
    }

    @Test
    public void acceptThrows(){
        ThrowsClause clause = new ThrowsClause();

        clause.accept(new String[0]);
        assertTrue(clause.callback.hasException());
    }

    private static class NoThrowsClause extends Clause<String> {
        private String[] parameters;

        @Override
        protected void acceptThrows(String[] parameters) {
            this.parameters = parameters;
        }
    }

    private static class ThrowsClause extends Clause<String> {
        @Override
        protected void acceptThrows(String[] parameters) throws Exception {
            throw new Exception();
        }
    }
}