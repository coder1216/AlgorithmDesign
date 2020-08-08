package DoorSecurity.Rule;

import DoorSecurity.Position;
import DoorSecurity.UserInfo;
import org.jetbrains.annotations.NotNull;

public class PositionRule implements ValidateRule{
    private final Position position;

    public PositionRule(final Position position){
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }

    @Override
    public boolean isValid(@NotNull final UserInfo userInfo) {
        return position == userInfo.getPosition();
    }

}
