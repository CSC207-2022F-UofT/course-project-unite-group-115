package add_blocked_Users.Interface;

import add_blocked_Users.application_business_rules.AddBlockedUserOutputBoundary;
import add_blocked_Users.application_business_rules.AddBlockedUserResponseModel;
import get_user_sensitiveWordList.application_business_rules.GetUserListResponseModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlockedPresenter implements AddBlockedUserOutputBoundary {
    @Override
    public AddBlockedUserResponseModel prepareSuccessView(AddBlockedUserResponseModel response) {
        /*List<String> list = new ArrayList<>(response.getBlockedList());
        Collections.sort(list);
        response.setBlockedList(list);
        return response;*/
        String blockList = response.getBlockedList();
        response.setBlockedList(blockList);
        return response;
    }
    @Override
    public AddBlockedUserResponseModel prepareFailView(String error) {
        throw new Failure(error);
    }
}
