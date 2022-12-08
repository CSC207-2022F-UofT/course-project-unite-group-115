package get_user_sensitiveWordList.interface_adapters;

public class GetUserSenListFailure extends RuntimeException {
    public GetUserSenListFailure(String errorMessage) {
        super(errorMessage);
    }
}