package racinggame;

public class Message {
    public static final String MESSAGE_ERROR = "[ERROR]";
    public static final String MESSAGE_VALIDATE_NAME = "5자 이하만 가능합니다.";
    public static final String MESSAGE_VALIDATE_MIN_LENGTH = "빈 문자열입니다!";

    public static String formatErrorMessage(String content){
        return String.format("%s %s",MESSAGE_ERROR,content);
    }
}
