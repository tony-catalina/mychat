package com.example.onenight.controller;

import com.alibaba.fastjson.JSON;
import com.example.onenight.entity.FriendApply;
import com.example.onenight.entity.MyChatUser;
import com.example.onenight.service.FriendApplyService;
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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/forFriend")
public class forFriendController {
    @Autowired
    private myStringUtil stringUtil;

    @Autowired
    private userInfoController userInfoController;

    @Autowired
    FriendApplyService friendApplyService;


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
            System.out.println("======"+ JSON.toJSONString(friendApply));
            return friendApplyService.addOneFriendApply(friendApply);

        }else {
            return ResultUtils.error(Result.ERR_LOGIN,"用户未登录或登录信息失效,请先登录");
        }

    }


    /**
     * @Annotate:获取登录用户的待处理好友申请通知
     * @author ztx
     * @date 2020/6/18
     */
    @PostMapping("/getFriendApplyById")
    @ResponseBody
    public Result getFriendApplyById(HttpServletRequest request,HttpSession session){
        String loginUser=(String) session.getAttribute("LOGINUSER");
        MyChatUser myChatUser=(MyChatUser) userInfoController.findLoginUserInfo(session).getResult();

        String searchKey=request.getParameter("searchKey");
        if(!stringUtil.isNullorEmpty(loginUser)) {
            if(!stringUtil.isNullorEmpty(searchKey)){
                return friendApplyService.getFriendApplyByUserId(myChatUser.getUserId(),searchKey);
            }else {
                return friendApplyService.getFriendApplyByUserId(myChatUser.getUserId(),"");
            }


        }else {
            return ResultUtils.error(Result.ERR_LOGIN,"用户未登录或登录信息失效,请先登录");
        }
    }

    @PostMapping("/refuseFriendApply")
    @ResponseBody
    public Result refuseFriendApply(HttpSession session,HttpServletRequest request){
        String loginUser=(String) session.getAttribute("LOGINUSER");

        String friendApplyId=request.getParameter("friendApplyId");
        if(!stringUtil.isNullorEmpty(loginUser)) {
            if(!stringUtil.isNullorEmpty(friendApplyId)){
                return friendApplyService.refuseFriendApply(Integer.parseInt(friendApplyId));
            }else {
                return ResultUtils.error("获取申请记录ID失败");
            }
        }else {
            return ResultUtils.error(Result.ERR_LOGIN,"用户未登录或登录信息失效,请先登录");
        }
    }

}
