package umc.spring.apiPlayload.exception.handler;

import umc.spring.apiPlayload.code.BaseErrorCode;
import umc.spring.apiPlayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}