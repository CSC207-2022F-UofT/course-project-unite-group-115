package frameworks_and_drivers;

public class Failed extends RuntimeException {
    public Failed(String error) {
        super(error);
    }
}
