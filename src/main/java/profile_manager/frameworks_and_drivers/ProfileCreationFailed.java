package profile_manager.frameworks_and_drivers;

public class ProfileCreationFailed extends RuntimeException {
    public ProfileCreationFailed(String error) {
        super(error);
    }
}
