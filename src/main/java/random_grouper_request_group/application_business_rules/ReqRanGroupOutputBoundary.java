package random_grouper_request_group.application_business_rules;

public interface ReqRanGroupOutputBoundary {
    ReqRanGroupResponseModel prepareSuccessView(ReqRanGroupResponseModel group);

    ReqRanGroupResponseModel prepareFailView(String errorMessage);

    String getSuccessMessage (ReqRanGroupResponseModel group);
}
