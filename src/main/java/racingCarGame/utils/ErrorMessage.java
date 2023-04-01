package racingCarGame.utils;

public enum ErrorMessage {
    CHARACTER_LIMIT("글자 수 초과 오류");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
