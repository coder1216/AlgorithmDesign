package DoorSecurity;
import java.util.*;

public class ValidateServiceImpl implements ValidationService{
    /*
     * 1. Query DB and get the level
     * 2. Make Service Call
     */
    @Override
    public int getUserSecurityLevel(String userId) {
        return 0;
    }

    @Override
    public int getCheckerSecurityLevel(String checkerId) {
        return 0;
    }

    @Override
    public String getUserCurrentBadgeId(String userId) {
        return null;
    }

    @Override
    public List<IValidateRule> getCheckerValidationRules(String checkerId) {
        return null;
    }

    @Override
    public UserInfo getUserInfo(String userId) {
        return null;
    }
}
