package DoorSecurity.Rule;

import DoorSecurity.UserInfo;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class OrgRule implements ValidateRule{
    private final String orgId;

    private final Set<String> subOrgs;

    public OrgRule(final String orgId) {
        this.orgId = orgId;
        subOrgs = new HashSet<>();
    }

    public String getOrgId(){
        return orgId;
    }

    public boolean isSubOrg(final String orgId){
        return subOrgs.contains(orgId);
    }

    @Override
    public boolean isValid(@NotNull UserInfo userInfo) {
        final String userOrgId = userInfo.getOrgId();
        return orgId.equals(userOrgId) || subOrgs.contains(userOrgId);
    }
}
