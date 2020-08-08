package DoorSecurity.Rule;

import DoorSecurity.UserInfo;
import org.jetbrains.annotations.NotNull;

public interface ValidateRule {
    boolean isValid(@NotNull final UserInfo userInfo);
}
