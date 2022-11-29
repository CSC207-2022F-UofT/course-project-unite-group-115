package flManager.application_business_rules;

public interface flManRepoInt {
    boolean existsByName(String identifier);

    void save(flManRepoRequestModel requestModel);
// TODO: finish data part and check/ edit
    void addFri(String userName);
    void delFri(String userName);
}
