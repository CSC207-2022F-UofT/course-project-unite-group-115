package database_classes;

import database_classes.UserReporterRepoRequestModel;

public interface UserReporterInt {
        /*add blacklist users to database
         */
    void adduserModel(UserReporterRepoRequestModel userMessageModel);
}
