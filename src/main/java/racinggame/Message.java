package racinggame;

public class Message {
    public static final String MESSAGE_ERROR = "[ERROR]";
    public static final String MESSAGE_VALIDATE_NAME = "5자 이하만 가능합니다.";
    public static final String MESSAGE_VALIDATE_MIN_LENGTH = "빈 문자열입니다!";
    public static final String MESSAGE_INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String MESSAGE_INPUT_TIME = "시도할 회수는 몇회인가요?";

    public static String formatErrorMessage(String content){
        return String.format("%s %s",MESSAGE_ERROR,content);
    }
}
