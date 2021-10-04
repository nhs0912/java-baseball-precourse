package baseball.exception;

public enum MyErrorCode {
    INVALID_NUMBER("[ERROR] 숫자를 잘못 입력하였습니다. (1-9 숫자를 입력해야합니다.)");

    private String errorMessage;

    MyErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String errorMessage() {
        return this.errorMessage;
    }
}
