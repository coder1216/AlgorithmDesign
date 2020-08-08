package DoorSecurity;
import org.jetbrains.annotations.NotNull;
import DoorSecurity.Rule.*;

import java.util.*;

public class Checker {
    private final String checkerId;
    private final ValidationService service;
    private int securityLevel;

    //Multiple Rules to Open the door
    private List<IValidateRule> validateRules;

    public Checker(final String id, final ValidationService service) {
        this.checkerId = id;
        this.service = service;
        validateRules = new ArrayList<>();
        updateCheckerSettings();
    }

    private void updateCheckerSettings(){
        securityLevel = service.getCheckerSecurityLevel(checkerId);
        //Multiple Rules to Open the door
        validateRules = service.getCheckerValidationRules(checkerId);
    }

    public boolean isValid(@NotNull final String userId){
        int userSecurityLevel = service.getUserSecurityLevel(userId);

        return userSecurityLevel >= securityLevel;
    }

    //For check Security with Badge Lose/Found
    public boolean checkValid(@NotNull final String userId, @NotNull final String badgeId){
        final String userCurrentBadgeId = service.getUserCurrentBadgeId(userId);

        return isValid(userId) && badgeId.equals(userCurrentBadgeId);
    }

    //Multiple Rules to Open the door
    public boolean checkWithMultipleRules(@NotNull final String userId, @NotNull final String badgeId){
        final UserInfo userInfo = service.getUserInfo(userId);

        for (IValidateRule rule : validateRules) {
            if(!rule.isValid(userInfo)) {
                return false;
            }
        }

        return checkValid(userId, badgeId);
    }

}
