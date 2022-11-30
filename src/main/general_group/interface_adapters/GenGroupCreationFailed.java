package general_group.interface_adapters;

public class GenGroupCreationFailed extends RuntimeException{
    public GenGroupCreationFailed(String error) {
        super(error);
    }
}
