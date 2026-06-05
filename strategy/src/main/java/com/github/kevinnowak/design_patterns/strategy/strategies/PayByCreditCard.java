package com.github.kevinnowak.design_patterns.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PayByCreditCard implements PayStrategy {

    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;

    @Override
    public boolean pay(int paymentAmount) {
        if (cardIsPresent()) {
            IO.println("Paying " + paymentAmount + " using Credit Card.");
            card.setAmount(card.getAmount() - paymentAmount);

            return true;
        } else {
            return false;
        }
    }

    /**
     * Collect credit card data
     */
    @Override
    public void collectPaymentDetails() {
        try {
            IO.print("Enter the card number: ");
            String number = READER.readLine();
            IO.print("Enter the card expiration date 'mm/yy': ");
            String date = READER.readLine();
            IO.print("Enter the CVV code: ");
            String cvv = READER.readLine();
            card = new CreditCard(number, date, cvv);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean cardIsPresent() {
        return card != null;
    }
}
