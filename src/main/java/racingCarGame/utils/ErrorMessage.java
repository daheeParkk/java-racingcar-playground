package racingCarGame.utils;

public enum ErrorMessage {
    CHARACTER_LIMIT("글자 수 초과 오류"),
    DUPLICATE_NAME("이름 중복 오류");

    private final String message;

    ErrorMessage(String message) {

        this.message = message;
    }

    public String getMessage() {

        return message;
    }
}
