package use_cases.block_user_application.interface_adapters;

public class UserReporterFailure extends RuntimeException {
    public UserReporterFailure(String error) {
        super(error);
    }
}
