package com.github.kevinnowak.design_patterns.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete strategy. Implements PayPal payment method
 */
public class PayByPayPal  implements PayStrategy {

    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    static {
        DATA_BASE.put("amanda1985", "amanda@ya.com");
        DATA_BASE.put("qwerty", "john@amazon.eu");
    }

    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            IO.println("Paying " + paymentAmount + " using PayPal.");

            return true;
        } else {
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {
        try {
            while (!signedIn) {
                IO.print("Enter a user's email: ");
                email = READER.readLine();
                IO.print("Enter the password: ");
                password = READER.readLine();

                if (verify()) {
                    IO.println("Data verification has been successful.");
                } else {
                    IO.println("Wrong email or password!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean verify() {
        setSignedIn(email.equals(DATA_BASE.get(password)));

        return signedIn;
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
