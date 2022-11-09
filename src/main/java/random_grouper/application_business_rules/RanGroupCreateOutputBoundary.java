package random_grouper.application_business_rules;

public interface RanGroupCreateOutputBoundary {
    RanGroupCreateResponseModel prepareSuccessView(RanGroupCreateResponseModel group);

    RanGroupCreateResponseModel prepareFailView(String errorMessage);
}
