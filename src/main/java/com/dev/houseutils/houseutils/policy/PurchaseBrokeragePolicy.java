package com.dev.houseutils.houseutils.policy;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;

/**
 * 매매일 때 중개수수료 계산
 */
@Getter
public class PurchaseBrokeragePolicy implements BrokeragePolicy {

    private final List<BrokerageRule> rules;

    public PurchaseBrokeragePolicy() {
        rules = Arrays.asList(
            new BrokerageRule(50_000_000L, 0.6, 250_000L),
            new BrokerageRule(200_000_000L, 0.5, 800_000L),
            new BrokerageRule(900_000_000L, 0.4),
            new BrokerageRule(1200_000_000L, 0.5),
            new BrokerageRule(1500_000_000L, 0.6),
            new BrokerageRule(Long.MAX_VALUE, 0.7)
        );
    }

    @Override
    public List<BrokerageRule> getRules(Long price) {
        return rules;
    }
}
