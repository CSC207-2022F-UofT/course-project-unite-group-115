package flManager.application_business_rules;

public interface flManOutputBoundary {
    flManResponseModel prepareSuccessView(flManResponseModel user);
    flManResponseModel prepareFailView(String error);
}
