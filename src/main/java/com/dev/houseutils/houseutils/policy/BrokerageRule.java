package com.dev.houseutils.houseutils.policy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

/**
 * 거래금액 특정 범위일 때, 상한요율과 힌도액을 가지는 클래
 */
@Getter
@AllArgsConstructor
public class BrokerageRule {

    private Long lessThan;
    private Double brokeragePercent; //상한요율
    private Long limitAmount; // 한도액

    public BrokerageRule(Long lessThan, Double brokeragePercent) {
        this(lessThan, brokeragePercent, Long.MAX_VALUE);
    }

    // 수수료를 계산
    public Long calcMaxBrokerage(Long price) {
        // 한도액이 있는 경우, 한도액과 (거래금액*상한요율) 중 적은 금액을 선택
        return Math.min(multiplyPercent(price), limitAmount);
    }

    private Long multiplyPercent(Long price) {
        return Double.valueOf(price * (brokeragePercent / 100)).longValue();
    }
}
