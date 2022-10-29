package com.dev.houseutils.houseutils.controller;

import com.dev.houseutils.houseutils.constants.ActionType;
import com.dev.houseutils.houseutils.policy.BrokeragePolicy;
import com.dev.houseutils.houseutils.policy.BrokeragePolicyFactory;
import com.dev.houseutils.houseutils.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BrokerageQueryController {

    private final ApartmentService apartmentService;

    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(
        @RequestParam("actionType") ActionType actionType,
        @RequestParam("price") Long price
    ) {
        // 중개수수료를 계산해서 반환
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }

    @GetMapping("/api/calc/apartment/{apartmentId}")
    public Long calcBrokerageByApartmentId(
        @PathVariable("apartmentId") Long apartmentId,
        @RequestParam("actionType") ActionType actionType
    ) {
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);

        return policy.calculate(apartmentService.getPriceOrThrow(apartmentId));
    }
}
