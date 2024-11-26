package umc.spring.apiPlayload.exception.handler;

import umc.spring.apiPlayload.code.BaseErrorCode;
import umc.spring.apiPlayload.exception.GeneralException;

public class RegionHandler extends GeneralException {

    public RegionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
