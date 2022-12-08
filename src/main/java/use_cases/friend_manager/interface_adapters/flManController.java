package use_cases.friend_manager.interface_adapters;

import use_cases.friend_manager.application_business_rules.flManInputBoundary;
import use_cases.friend_manager.application_business_rules.flManRequestModel;
import use_cases.friend_manager.application_business_rules.flManResponseModel;

import java.util.List;

public class flManController {
    final flManInputBoundary userInput;

    public flManController(flManInputBoundary userInput){
        this.userInput = userInput;
    }

    flManResponseModel create(String owner, List<String> friends) {
        flManRequestModel requestModel = new flManRequestModel(owner, friends);

        return userInput.create(requestModel);
    }

}
