package com.dev.houseutils.houseutils.policy;

import com.dev.houseutils.houseutils.constants.ActionType;
import com.dev.houseutils.houseutils.exception.ErrorCode;
import com.dev.houseutils.houseutils.exception.HouseUtilsException;

/**
 * 거래 타입에 따른 생성자 반환
 */
public class BrokeragePolicyFactory {

    private BrokeragePolicyFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static BrokeragePolicy of(ActionType type) {
        switch (type) {
            case PURCHASE:
                return new PurchaseBrokeragePolicy();
            case RENT:
                return new RentBrokeragePolicy();
            default:
                throw new HouseUtilsException(ErrorCode.INVALID_REQUEST, String.format("해당 %s에 대한 정책이 존재하지 않습니다.", type));
        }
    }
}
