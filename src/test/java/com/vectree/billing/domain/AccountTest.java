package com.vectree.billing.domain;

import lombok.val;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

/**
 * Account unit test check that all works fine.
 *
 * @author Egor Voronyansky
 * @version 0.1
 */
public class AccountTest {

    /**
     * System under test.
     */
    private Account account = new Account(1L, new BigDecimal(100), new BigDecimal(100));


    /**
     * When try get id from account should check that id is correct.
     */
    @Test
    public void whenTryGetIdFromAccountShouldCheckThatIdCorrect() {
        assertThat(account.getId(), is(1L));
    }

    /**
     * When try get debit account of the account should check that return true value.
     */
    @Test
    public void whenTryGetDebitAccountShouldCheckThatAccountReturnTrueValue() {
        assertThat(account.getDebit(), is(new BigDecimal(100)));
    }

    /**
     * When try get credit account of the account should check that return true value.
     */
    @Test
    public void getCredit() {
        assertThat(account.getCredit(), is(new BigDecimal(100)));
    }

    /**
     * Test toString() is not null
     */
    @Test
    public void testToString() {
        assertThat(account.toString(), instanceOf(String.class));
    }

    @Test
    public void testEqualsSymmetric() {
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            Long value = random.nextLong();

            val x = new Account(value, new BigDecimal(value), new BigDecimal(value));
            val y = new Account(value, new BigDecimal(value), new BigDecimal(value));
            Assert.assertTrue(x.equals(y) && y.equals(x));
            Assert.assertTrue(x.hashCode() == y.hashCode());
        }
    }
}