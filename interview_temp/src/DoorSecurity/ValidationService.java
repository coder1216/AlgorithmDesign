package DoorSecurity;
import DoorSecurity.Rule.ValidateRule;

import java.util.*;


public interface ValidationService {
    int getUserSecurityLevel(final String userId);

    int getCheckerSecurityLevel(final String checkerId);

    String getUserCurrentBadgeId(final String userId);

    List<ValidateRule> getCheckerValidationRules(String checkerId);

    //Multiple Rules to Open the door
    UserInfo getUserInfo(final String userId);
}
