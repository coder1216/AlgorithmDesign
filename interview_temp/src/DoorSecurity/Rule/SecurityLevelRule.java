package DoorSecurity.Rule;

import DoorSecurity.UserInfo;
import org.jetbrains.annotations.NotNull;

public class SecurityLevelRule implements ValidateRule{
    private final int securityLevel;

    public SecurityLevelRule(final int securityLevel){
        this.securityLevel = securityLevel;
    }

    public int getSecurityLevel(){
        return securityLevel;
    }

    @Override
    public boolean isValid(@NotNull final UserInfo userInfo) {
        return userInfo.getSecurityLevel() >= securityLevel;
    }
}
