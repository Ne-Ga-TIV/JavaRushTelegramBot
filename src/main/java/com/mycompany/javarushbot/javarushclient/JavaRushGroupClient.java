package com.mycompany.javarushbot.javarushclient;

import com.mycompany.javarushbot.javarushclient.dto.GroupDiscussionInfo;
import com.mycompany.javarushbot.javarushclient.dto.GroupInfo;
import com.mycompany.javarushbot.javarushclient.dto.GroupRequestArgs;
import com.mycompany.javarushbot.javarushclient.dto.GroupsCountRequestArgs;

import java.util.List;

public interface JavaRushGroupClient {
    List<GroupInfo> getGroupList(GroupRequestArgs requestArgs);

    List<GroupDiscussionInfo> getGroupDiscussionList(GroupRequestArgs requestArgs);

    Integer getGroupCount(GroupsCountRequestArgs countRequestArgs);

    GroupDiscussionInfo getGroupById(Integer id);
}
