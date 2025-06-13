// Wyjątek obługiwania sytuacji gdzie mamy tylko jedną postać
// w drużynie, a użytkownik chce usunąć postać
public class LastCharacterException extends RuntimeException {
    public LastCharacterException(String message) {
        super(message);
    }
}
