package profile_manager.interface_adapters;

public class ProfileCreationFailed extends RuntimeException {
    public ProfileCreationFailed(String error) {
        super(error);
    }
}
