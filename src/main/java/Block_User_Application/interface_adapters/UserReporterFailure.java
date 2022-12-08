package Block_User_Application.interface_adapters;

public class UserReporterFailure extends RuntimeException {
    public UserReporterFailure(String error) {
        super(error);
    }
}
