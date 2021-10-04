package baseball.exception;

public enum MyErrorCode {
    INVALID_NUMBER("[ERROR] 숫자를 잘못 입력하였습니다. (1-9 숫자를 입력해야합니다.)"),
    INVALID_THREE_COUNT_OF_BALL("[ERROR] 볼의 개수는 3개를 입력해야합니다."),
    BALL_HAS_DUPLICATE_NUMBER("[ERROR] 중복된 숫자를 입력하였습니다.");

    private String errorMessage;

    MyErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String errorMessage() {
        return this.errorMessage;
    }
}
