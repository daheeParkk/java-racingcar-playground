package racingCarGame.exception;

import static racingCarGame.message.ErrorMessage.CHARACTER_LIMIT;

public class CharacterLimitException extends RuntimeException {

    public CharacterLimitException() {
        super(CHARACTER_LIMIT.getMessage());
    }
}
