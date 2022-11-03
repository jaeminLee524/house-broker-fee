package com.dev.houseutils.houseutils.policy;

import com.dev.houseutils.houseutils.exception.ErrorCode;
import com.dev.houseutils.houseutils.exception.HouseUtilsException;
import java.util.List;

public interface BrokeragePolicy {

    List<BrokerageRule> getRules(Long price);

    // 가격을 받아서 중개수수료를 계산한다.
    default Long calculate(Long price) {
        List<BrokerageRule> rules = getRules(price);
        BrokerageRule brokerageRule = rules.stream()
            .filter(rule -> price < rule.getLessThan())
            .findFirst()
            .orElseThrow(() -> new HouseUtilsException(ErrorCode.INTERNAL_ERROR));

        return brokerageRule.calcMaxBrokerage(price);
    }

}
