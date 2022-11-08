import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class GroupRepo {
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    //    private final Map<String, UserRegisterDsRequestModel> accounts = new HashMap<>();

    public GroupRepo(String csvPath) throws IOException {
        csvFile = new File(csvPath);
    // TODO: INCOMPLETE
    }





}
