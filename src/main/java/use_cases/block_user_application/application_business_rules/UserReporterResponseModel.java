package use_cases.block_user_application.application_business_rules;

public class UserReporterResponseModel {
    String report;
    String time;


    public UserReporterResponseModel(String report, String time) {
        this.report = report;
        this.time = time;

    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String creationTime) {
        this.time = creationTime;
    }


}