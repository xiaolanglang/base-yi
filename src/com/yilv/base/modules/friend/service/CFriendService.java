package com.yilv.base.modules.friend.service;

import org.springframework.stereotype.Service;

import com.yilv.base.common.service.impl.CrudService;
import com.yilv.base.modules.friend.dao.HFriendDao;
import com.yilv.base.modules.friend.dao.MFriendDao;
import com.yilv.base.modules.friend.entity.Friend;

@Service
public class CFriendService extends CrudService<HFriendDao, MFriendDao, Friend> {

}
