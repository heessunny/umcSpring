package umc.spring.apiPlayload.exception.handler;

import umc.spring.apiPlayload.code.BaseErrorCode;
import umc.spring.apiPlayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}