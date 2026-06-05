package com.github.kevinnowak.design_patterns.strategy.strategies;

import java.util.function.Supplier;

/**
 * Enum acting as a factory and registry for Payment Strategies.
 */
public enum PaymentMethod {
    PAYPAL(PayByPayPal::new),
    CREDIT_CARD(PayByCreditCard::new);

    private final Supplier<PayStrategy> strategySupplier;

    PaymentMethod(Supplier<PayStrategy> strategySupplier) {
        this.strategySupplier = strategySupplier;
    }

    public PayStrategy getStrategy() {
        return strategySupplier.get();
    }

    /**
     * Helper to map user input ("1" or "2") to the corresponding enum value.
     */
    public static PaymentMethod fromString(String input) {
        return switch (input) {
            case "1" -> PAYPAL;
            case "2" -> CREDIT_CARD;
            default -> throw new IllegalArgumentException("Unknown payment method: " + input);
        };
    }
}
