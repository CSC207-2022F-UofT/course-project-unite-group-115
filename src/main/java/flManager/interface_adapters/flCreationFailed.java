package flManager.interface_adapters;

public class flCreationFailed extends RuntimeException  {
    public flCreationFailed(String error) {
        super(error);
    }
}
