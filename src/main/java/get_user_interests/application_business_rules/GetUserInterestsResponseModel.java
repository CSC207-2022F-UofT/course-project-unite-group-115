package get_user_interests.application_business_rules;

import java.util.List;

public class GetUserInterestsResponseModel {
    private List<String> interests;
    private String failMessage;

    public GetUserInterestsResponseModel(List<String> interests){
        this.interests = interests;
    }

    public GetUserInterestsResponseModel(String errorMessage) {
        this.failMessage = errorMessage;
    }

    /**
     * Return the user's interests.
     */
    public List<String> getInterests() {
        return interests;
    }

    /**
     * Change the stored interests to <interests>.
     */
    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    /**
     * Returns a message explaining why the use case failed to get the user's interests.
     */
    public String getFailMessage() {
        return failMessage;
    }
}
