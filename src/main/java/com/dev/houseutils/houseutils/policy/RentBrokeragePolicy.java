package com.dev.houseutils.houseutils.policy;

/**
 * 임대차일 때 중개수수료 계산
 */
public class RentBrokeragePolicy implements BrokeragePolicy {

    @Override
    public BrokerageRule createBrokerageRule(Long price) {
        BrokerageRule rule;
        if (price < 50_000_000) {
            rule = new BrokerageRule(0.5, 200_000L);
        } else if (price < 100_000_000) {
            rule = new BrokerageRule(0.4, 300_000L);
        } else if (price < 600_000_000) {
            rule = new BrokerageRule(0.3, null);
        } else if (price < 1200_000_000) {
            rule = new BrokerageRule(0.4, null);
        } else if (price < 1500_000_000) {
            rule = new BrokerageRule(0.5, null);
        } else {
            rule = new BrokerageRule(0.6, null);
        }
        return rule;
    }
}