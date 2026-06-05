package com.github.kevinnowak.design_patterns.strategy;

import com.github.kevinnowak.design_patterns.strategy.orders.Order;
import com.github.kevinnowak.design_patterns.strategy.strategies.PayStrategy;
import com.github.kevinnowak.design_patterns.strategy.strategies.PaymentMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Demo {

    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2_200);
        priceOnProducts.put(2, 1_850);
        priceOnProducts.put(3, 1_100);
        priceOnProducts.put(4, 890);
    }

    static void main() throws IOException {
        while (!order.isClosed()) {
            int cost;
            String continueChoice;

            do {
                IO.print(
                        """
                                Please, select a product:
                                    1 - Motherboard
                                    2 - CPU
                                    3 - HDD
                                    4 - Memory
                                """
                );

                int choice = Integer.parseInt(reader.readLine());
                cost = priceOnProducts.get(choice);
                IO.print("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                IO.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null) {
                IO.println(
                        """
                                Please, select a payment method:
                                    1 - PayPal
                                    2 - Credit Card
                                """
                );

                String paymentMethod = reader.readLine();
                strategy = PaymentMethod.fromString(paymentMethod).getStrategy();
                order.setStrategy(strategy);
            }

            order.processOrder();

            IO.print("Pay " + order.getTotalCost() + " units or continue shopping? P/C: ");
            String proceed = reader.readLine();

            if (proceed.equalsIgnoreCase("P")) {
                if (order.pay()) {
                    IO.println("Payment has been successful.");
                } else {
                    IO.println("Payment failed");
                }

                order.setClosed();
            }

        }
    }
}
