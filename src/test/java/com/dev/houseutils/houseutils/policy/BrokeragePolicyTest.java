package com.dev.houseutils.houseutils.policy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BrokeragePolicyTest {

    PurchaseBrokeragePolicy purchaseBrokeragePolicy;
    RentBrokeragePolicy rentBrokeragePolicy;

    @BeforeEach
    public void beforeAll() {
        purchaseBrokeragePolicy = new PurchaseBrokeragePolicy();
        rentBrokeragePolicy = new RentBrokeragePolicy();
    }

    @Test
    void testPurchaseBrokeragePolicy() {
        Assertions.assertEquals(purchaseBrokeragePolicy.calculate(30_000_000L), 180_000L);
        Assertions.assertEquals(purchaseBrokeragePolicy.calculate(100_000_000L), 500_000L);
        Assertions.assertEquals(purchaseBrokeragePolicy.calculate(500_000_000L), 2_000_000L);
        Assertions.assertEquals(purchaseBrokeragePolicy.calculate(800_000_000L), 4_000_000L);
        Assertions.assertEquals(purchaseBrokeragePolicy.calculate(1_000_000_000L), 9_000_000L);
    }

    @Test
    void testRendBrokeragePolicy() {
        Assertions.assertEquals(rentBrokeragePolicy.calculate(30_000_000L), 180_000L);
        Assertions.assertEquals(rentBrokeragePolicy.calculate(30_000_000L), 180_000L);
        Assertions.assertEquals(rentBrokeragePolicy.calculate(30_000_000L), 180_000L);
        Assertions.assertEquals(rentBrokeragePolicy.calculate(30_000_000L), 180_000L);
        Assertions.assertEquals(rentBrokeragePolicy.calculate(30_000_000L), 180_000L);
        Assertions.assertEquals(rentBrokeragePolicy.calculate(30_000_000L), 180_000L);
    }

}
