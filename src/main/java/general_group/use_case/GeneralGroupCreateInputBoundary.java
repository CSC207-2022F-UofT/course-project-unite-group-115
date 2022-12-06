package general_group.use_case;

public interface GeneralGroupCreateInputBoundary {
    /**
     * Creates a new general group and saves it to the GroupDataBase file using requestModel
     * @param requestModel Data structure that consists of the group name, the friends the user wishes to add,
     *                     and the name of the group creator
     * @return  Data structure containing the group's name, ID, and creation time, if the creation was successful.
     *          Or returns a data structure containing a failure message, if the creation was unsuccessful.
     */
    GeneralGroupCreateDsResponseModel create(GeneralGroupCreateDsRequestModel requestModel);
}
