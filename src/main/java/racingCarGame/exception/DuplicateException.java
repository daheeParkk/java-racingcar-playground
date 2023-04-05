package racingCarGame.exception;

import static racingCarGame.utils.ErrorMessage.DUPLICATE_NAME;

public class DuplicateException extends RuntimeException {

    public DuplicateException() {
        super(DUPLICATE_NAME.getMessage());
    }
}
