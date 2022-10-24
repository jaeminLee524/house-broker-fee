package com.dev.houseutils.houseutils.controller;

import com.dev.houseutils.houseutils.constants.ActionType;
import com.dev.houseutils.houseutils.policy.BrokeragePolicy;
import com.dev.houseutils.houseutils.policy.BrokeragePolicyFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrokerageQueryController {

    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(
        @RequestParam("actionType") ActionType actionType,
        @RequestParam("price") Long price
    ) {
        // 중개수수료를 계산해서 반환
        BrokeragePolicy brokeragePolicy = BrokeragePolicyFactory.of(actionType);
        return brokeragePolicy.calculate(price);
    }
}
