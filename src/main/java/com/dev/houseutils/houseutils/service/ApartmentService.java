package com.dev.houseutils.houseutils.service;

import com.dev.houseutils.houseutils.exception.ErrorCode;
import com.dev.houseutils.houseutils.exception.HouseUtilsException;
import com.dev.houseutils.houseutils.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;

    @Transactional(readOnly = true)
    public Long getPriceOrThrow(Long apartmentId) {
        // 불필요한 지역변수를 사용하지 않고 getPrice 호출
        return apartmentRepository.findById(apartmentId)
            .orElseThrow(() -> new HouseUtilsException(ErrorCode.ENTITY_NOT_FOUND))
            .getPrice();
    }
}
