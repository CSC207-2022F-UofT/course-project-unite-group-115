package get_user_sensitiveWordList.interface_adapters;
import get_user_sensitiveWordList.application_business_rules.GetUserSensListResponseModel;
import get_user_sensitiveWordList.application_business_rules.GetUserSensitiveListOutputBoundary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetUserSenListPresenter implements GetUserSensitiveListOutputBoundary {
    @Override
    public GetUserSensListResponseModel prepareSuccessView(GetUserSensListResponseModel response) {
        List <String> list = new ArrayList<>(response.getSensList());
        Collections.sort(list);
        response.setSensList(list);
        return response;
    }
    @Override
    public GetUserSensListResponseModel prepareFailView(String error) {
        throw new GetUserSenListFailure(error);
    }

}
