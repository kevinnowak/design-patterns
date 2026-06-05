package com.github.kevinnowak.design_patterns.strategy.orders;

import com.github.kevinnowak.design_patterns.strategy.strategies.PayStrategy;

public class Order {

    private int totalCost = 0;
    private boolean isClosed = false;
    private PayStrategy strategy;

    public void setStrategy(PayStrategy strategy) {
        this.strategy = strategy;
    }

    public void processOrder() {
        if (strategy != null) {
            strategy.collectPaymentDetails();
        }
    }

    public boolean pay() {
        if (strategy != null) {
            return strategy.pay(totalCost);
        }
        return false;
    }

    public void setTotalCost(int cost) {
        this.totalCost += cost;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
    }
}
