package com.dev.houseutils.houseutils.policy;

public interface BrokeragePolicy {

    BrokerageRule createBrokerageRule(Long price);

    // 가격을 받아서 중개수수료를 계산한다.
    default Long calculate(Long price) {
        BrokerageRule rule = createBrokerageRule(price);
        rule.calcMaxBrokerage(price);

        return rule.calcMaxBrokerage(price);
    }
}
