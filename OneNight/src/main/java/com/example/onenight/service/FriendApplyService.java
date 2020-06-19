package com.example.onenight.service;

import com.example.onenight.entity.FriendApply;
import com.example.onenight.utils.Result;

public interface FriendApplyService {
    Result addOneFriendApply(FriendApply friendApply);

    Result getFriendApplyByUserId(int userId,String searchKey);

    Result refuseFriendApply(int friendApplyId);
}
