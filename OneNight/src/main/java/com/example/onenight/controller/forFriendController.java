package com.example.onenight.controller;

import com.example.onenight.entity.FriendApply;
import com.example.onenight.entity.MyChatUser;
import com.example.onenight.utils.Result;
import com.example.onenight.utils.ResultUtils;
import com.example.onenight.utils.myStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/forFriend")
public class forFriendController {
    @Autowired
    private myStringUtil stringUtil;

    @Autowired
    private userInfoController userInfoController;


    /**
     * @Annotate:好友关系申请
     * @author ztx
     * @date 2020/6/15
     */
    @PostMapping("/friendApply")
    @ResponseBody
    public Result friendApply(HttpServletRequest request, HttpSession session){
        String loginUser=(String) session.getAttribute("LOGINUSER");
        MyChatUser myChatUser=(MyChatUser) userInfoController.findLoginUserInfo(session).getResult();
        String friend_id=request.getParameter("friend_user_id");
        String apply_friend_name=request.getParameter("apply_friend_name");
        String apply_friend_message=request.getParameter("apply_friend_message");

        if(!stringUtil.isNullorEmpty(loginUser)) {
            FriendApply friendApply=new FriendApply();
            friendApply.setApplyUserid(myChatUser.getUserId());
            friendApply.setFriendUserid(Integer.parseInt(friend_id));
            friendApply.setApplyState(1);
            friendApply.setApplyTime(new Date());
            if(!stringUtil.isNullorEmpty(apply_friend_message)){
                friendApply.setApplyRemarks(apply_friend_message);
            }
            if (!stringUtil.isNullorEmpty(apply_friend_name)){
                friendApply.setApplyFriendname(apply_friend_name);
            }
            return ResultUtils.error(Result.ERR_LOGIN,"用户未登录或登录信息失效,请先登录");

        }else {
            return ResultUtils.error(Result.ERR_LOGIN,"用户未登录或登录信息失效,请先登录");
        }

    }

}
