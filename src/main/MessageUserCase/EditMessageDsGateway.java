package MessageUserCase;

public interface EditMesssageDsGateway {
    boolean existsByName(String identifier); //?

    void save(EditMesssageDsRequestModel requestModel);
}
