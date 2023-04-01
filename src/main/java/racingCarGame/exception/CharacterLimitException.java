package racingCarGame.exception;

import static racingCarGame.utils.ErrorMessage.CHARACTER_LIMIT;

public class CharacterLimitException extends RuntimeException {

    public CharacterLimitException() {

        super(CHARACTER_LIMIT.getMessage());
    }
}
