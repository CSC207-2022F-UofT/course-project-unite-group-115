package MessageUserCase;

public interface MessageDsGateway {
    boolean existsByName(String identifier); //?

    void save(MessageDsRequestModel requestModel);
}
