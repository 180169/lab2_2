/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bottega.ecommerce.sharedkernel;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Godzio
 */
public class MoneyTest {

    private final Money first = new Money(20.00, "USD");
    private final Money second = new Money(20.00, "USD");
    private final Money third = new Money(10.00, "USD");
    private final Money fourth = new Money(20.00, "PLN");
    private final Money fifth = new Money(10.00, "PLN");

    @Test
    public void money_equals_twoElementsWithBothValuesDifferent_expectedFalse() {
        assertFalse(first.equals(fifth));
    }

    @Test
    public void money_equals_twoElementsWithDifferentValue_expectedFalse() {
        assertFalse(first.equals(third));
    }

    @Test
    public void money_equals_twoElementsWithDifferentCurrency_expectedFalse() {
        assertFalse(first.equals(fourth));
    }

    @Test
    public void money_equals_twoIdenticalElements_expectedTrue() {
        assertTrue(first.equals(second));
    }

    @Test
    public void money_lessOrEquals_thirdLessThanFirst_expectedTrue() {
        assertThat(third.lessOrEquals(first), is(true));
    }

    @Test
    public void money_lessOrEquals_firstLessThanThird_expectedFalse() {
        assertThat(first.lessOrEquals(third), is(false));
    }

    @Test
    public void money_lessOrEquals_firstEqualSecond_expectedTrue() {
        assertThat(first.lessOrEquals(second), is(true));
    }

    @Test
    public void money_lessThan_thirdLessThanFirst_expectedTrue() {
        assertThat(third.lessThan(first), is(true));
    }

    @Test
    public void money_lessThan_firstLessThanThird_expectedFalse() {
        assertThat(first.lessThan(third), is(false));
    }

    @Test
    public void money_lessThan_secondEqualToFirst_expectedFalse() {
        assertThat(second.lessThan(first), is(false));
    }
}
