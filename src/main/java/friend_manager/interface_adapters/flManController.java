package friend_manager.interface_adapters;

import friend_manager.application_business_rules.flManInputBoundary;
import friend_manager.application_business_rules.flManRequestModel;
import friend_manager.application_business_rules.flManResponseModel;

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
