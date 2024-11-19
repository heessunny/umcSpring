package umc.spring.apiPlayload.code;

public interface BaseErrorCode {
    ErrorReasonDTO getReason();

    ErrorReasonDTO getReasonHttpStatus();
}
