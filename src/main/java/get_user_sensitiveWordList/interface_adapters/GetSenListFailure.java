package get_user_sensitiveWordList.interface_adapters;

public class GetSenListFailure extends RuntimeException {
    public GetSenListFailure(String errorMessage) {
        super(errorMessage);
    }
}