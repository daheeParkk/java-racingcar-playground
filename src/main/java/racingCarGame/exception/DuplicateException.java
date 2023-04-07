package racingCarGame.exception;

import static racingCarGame.message.ErrorMessage.DUPLICATE_NAME;

public class DuplicateException extends RuntimeException {

    public DuplicateException() {
        super(DUPLICATE_NAME.getMessage());
    }
}
