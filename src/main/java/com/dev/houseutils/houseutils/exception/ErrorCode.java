package com.dev.houseutils.houseutils.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    ENTITY_NOT_FOUND("데이터를 찾을 수 없습니다.");

    private String description;
}