/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.bottega.ecommerce.sharedkernel;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Godzio
 */
public class MoneyTest {

    private Money first;
    private Money second;
    private Money third;
    private Money fourth;
    private Money fifth;
    private Money sixth;
    private Money minus;

    @Before
    public void onStart() {
        first = new Money(20.00, "USD");
        second = new Money(20.00, "USD");
        third = new Money(10.00, "USD");
        fourth = new Money(20.00, "PLN");
        fifth = new Money(10.00, "PLN");
        sixth = new Money(0.00, "USD");
        minus = new Money(-10.00, "USD");
    }

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

    @Test
    public void money_greaterThan_firstGreaterThenThird_expectedTrue() {
        assertThat(first.greaterThan(third), is(true));
    }

    @Test
    public void money_greaterThan_secondGreaterThenFirst_expectedFalse() {
        assertThat(second.greaterThan(first), is(false));
    }

    @Test
    public void money_greaterThan_thirdGreaterThenfirst_expectedFalse() {
        assertThat(third.greaterThan(first), is(false));
    }

    @Test
    public void money_subtract_firstSubtractByThird_expectedTrue() {
        assertThat(first.subtract(third), is(third));
    }

    @Test
    public void money_subtract_sixthEqualZeroSubtractThird_expectedException() {
        assertThat(sixth.subtract(third), is(minus));
    }

    @Test
    public void money_subtract_thirdSubtractSixthThatEqualsZero_expectedException() {
        assertThat(third.subtract(sixth), is(third));
    }

    @Test(expected = IllegalArgumentException.class)
    public void money_subtract_missmatchedCurrency_expectedException() {
        third.subtract(fourth);
    }

    @Test
    public void money_add_thirdAddThirdEqualsFirst_expectedTrue() {
        assertThat(third.add(third), is(first));
    }

    @Test
    public void money_add_sixthEqualZeroAddThird_expectedTrue() {
        assertThat(sixth.add(third), is(third));
    }

    @Test
    public void money_add_thirdAddSixthThatEqualsZero_expectedTrue() {
        assertThat(third.add(sixth), is(third));
    }

    @Test(expected = IllegalArgumentException.class)
    public void money_add_missmatchedCurrency_expectedException() {
        third.add(fourth);
    }

}
