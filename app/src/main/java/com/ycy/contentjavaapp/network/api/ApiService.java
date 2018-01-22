package com.ycy.contentjavaapp.network.api;



public interface ApiService {

//    @POST("verify/")
//    Observable<HttpBase.RetBase> verify(@Body HttpBase.ReqBase req);
//
//    @POST("login/")
//    Observable<HttpBase.RetBase> login(@Body HttpBase.ReqBase req);
//
//    @POST("login/")
//    Observable<HttpBase.RetBase> logout(@Body HttpBase.ReqBase req);
//
//    @Streaming
//    @GET()
//    Observable<ResponseBody> downloadFileAsync(@Url String fileUrl);
//
//    @GET()
//    Call<ResponseBody> downloadFileSync(@Url String url);
//
//    @Streaming
//    @GET()
//    Call<ResponseBody> downloadFileSyncStream(@Url String url);
//
//    @POST()
//    Call<HttpBase.RetBase> uploadAudio(@Url String url, @Body HttpBase.ReqBase req);
//
//    @POST()
//    Call<HttpBase.RetBase> uploadPhoto(@Url String url, @Body HttpBase.ReqBase req);
//
//    @POST()
//    Call<HttpBase.RetBase> uploadVideo(@Url String url, @Body HttpBase.ReqBase req);
//
//    @POST()
//    Call<HttpBase.RetBase> uploadFile(@Url String url, @Body HttpBase.ReqBase req);
//
//    @POST("user/edit/")
//    Call<HttpBase.RetBase> updateUserInfo(@Body HttpBase.ReqBase req);
//
//    @POST("user/list/")
//    Observable<HttpBase.RetBase> postUserInfo(@Body HttpBase.ReqBase req);
//
//    @POST("user/list/")
//    Call<HttpBase.RetBase> postUserInfoCall(@Body HttpBase.ReqBase req);
//
//    @POST("comment/add/")
//    Call<HttpBase.RetBase> sendComments(@Body HttpBase.ReqBase req);
//
//    @POST("comment/list/")
//    Observable<HttpBase.RetBase> postComments(@Body HttpBase.ReqBase req);
//
//    @POST("comment/one/")
//    Observable<HttpBase.RetBase> getDynamicDetail(@Body HttpBase.ReqBase req);
//
//
//    @POST("user/fetchfriends/")
//    Call<HttpBase.RetBase> getFriends(@Body HttpBase.ReqBase req);
//
//    @POST("user/relation/")
//    Observable<HttpBase.RetBase> getRelation(@Body HttpBase.ReqBase req);
//
//    @POST("user/relation/")
//    Call<HttpBase.RetBase> getRelationCall(@Body HttpBase.ReqBase req);
//
//    @POST("user/fetchattentions/")
//    Observable<HttpBase.RetBase> getFollowList(@Body HttpBase.ReqBase req);
//    @POST("user/fetchattentions/")
//    Call<HttpBase.RetBase> getFollowListSync(@Body HttpBase.ReqBase req);
//
//    @POST("user/fetchdoubleattentions/")
//    Observable<HttpBase.RetBase> getDoubleFollowList(@Body HttpBase.ReqBase req);
//
//    @POST("user/fetchfans/")
//    Observable<HttpBase.RetBase> getFansList(@Body HttpBase.ReqBase req);
//
//    @POST("user/fetchaddfriendlist/")
//    Observable<HttpBase.RetBase> getAddFriendList(@Body HttpBase.ReqBase req);
//
//    @POST("user/acceptfriend/")
//    Observable<HttpBase.RetBase> acceptFriend(@Body HttpBase.ReqBase req);
//
//    @POST("user/userrelationlist/")
//    Call<HttpBase.RetBase> getContactList(@Body HttpBase.ReqBase req);
//
//    @POST("user/qiuqiu/friends/")
//    Observable<HttpBase.RetBase> getQiuQiuFriendList(@Body HttpBase.ReqBase req);
//
//    @POST("user/qiuqiu/invite/")
//    Observable<HttpBase.RetBase> inviteQiuQiuFriend(@Body HttpBase.ReqBase req);
//
//    @POST("user/doattention/")
//    Observable<HttpBase.RetBase> doAttention(@Body HttpBase.ReqBase req);
//
//    @POST("comment/del/")
//    Observable<HttpBase.RetBase> delComments(@Body HttpBase.ReqBase req);
//
//    @POST("comment/add/")
//    Observable<HttpBase.RetBase> sendCommentsOb(@Body HttpBase.ReqBase req);
//
//    @POST("comment/read/")
//    Observable<HttpBase.RetBase> readComments(@Body HttpBase.ReqBase req);
//
//    @POST("comment/dolist/page/")
//    Observable<HttpBase.RetBase> getCommentsDoList(@Body HttpBase.ReqBase req);
//
//
//    @POST("room/list/")
//    Observable<HttpBase.RetBase> getRoomList(@Body HttpBase.ReqBase req);
//
//    @POST("room/recommend/")
//    Observable<HttpBase.RetBase> getHotRoomList(@Body HttpBase.ReqBase req);
//
//    @POST("room/member/page/")
//    Observable<HttpBase.RetBase> getRoomMemberList(@Body HttpBase.ReqBase req);
//
//    @POST("user/getalbum/")
//    Observable<HttpBase.RetBase> getAlbumList(@Body HttpBase.ReqBase req);
//
//    @POST("user/editalbum/")
//    Observable<HttpBase.RetBase> setAlbumList(@Body HttpBase.ReqBase req);
//
//    @POST("gift/getbill/")
//    Observable<HttpBase.RetBase> getBill(@Body HttpBase.ReqBase req);
//
//    @POST("gift/addcoin/")
//    Observable<HttpBase.RetBase> addCoin(@Body HttpBase.ReqBase req);
//
//    @POST("system/time/")
//    Observable<HttpBase.RetBase> getServerTime(@Body HttpBase.ReqBase req);
//
//    @POST("system/suggest/")
//    Observable<HttpBase.RetBase> sendFeedBack(@Body HttpBase.ReqBase req);
//
//    @POST("user/getroom/")
//    Observable<HttpBase.RetBase> getGetInRoom(@Body HttpBase.ReqBase req);
//
//    @POST("room/roominfo/")
//    Observable<HttpBase.RetBase> getGetRoomInfo(@Body HttpBase.ReqBase req);
//
//    @POST("system/report/")
//    Observable<HttpBase.RetBase> report(@Body HttpBase.ReqBase req);
//
//    @POST("user/getusersysstatus/")
//    Observable<HttpBase.RetBase> getUsersStatus(@Body HttpBase.ReqBase req);
//
//    @POST("user/search/heyid/")
//    Observable<HttpBase.RetBase> searchHeyId(@Body HttpBase.ReqBase req);
//
//    @POST("gift/getactivity/")
//    Observable<HttpBase.RetBase> getDayCoin(@Body HttpBase.ReqBase req);
//
//    @POST("gift/finishactivity/")
//    Observable<HttpBase.RetBase> getDayCoinFinish(@Body HttpBase.ReqBase req);
//
//    @POST("system/appver/")
//    Observable<HttpBase.RetBase> getRemoteVersionOld(@Body HttpBase.ReqBase req);
//
//    @POST("system/curver/")
//    Observable<HttpBase.RetBase> getCurVersion(@Body HttpBase.ReqBase req);
//
//    @POST("system/remotever/")
//    Call<HttpBase.RetBase> getRemoteVersion(@Body HttpBase.ReqBase req);
//
////    @POST("system/giftpackage/")
////    Call<HttpBase.RetBase> getGiftVersion(@Body HttpBase.ReqBase req);
//
//    @POST("system/giftpackagestring/")
//    Call<HttpBase.RetBase> getFileVersion(@Body HttpBase.ReqBase req);
//
//    @POST("gift/usergifttotal/")
//    Observable<HttpBase.RetBase> getUserGiftTotal(@Body HttpBase.ReqBase req);
//
//    @POST("gift/usergiftbill/")
//    Observable<HttpBase.RetBase> getUserGiftBill(@Body HttpBase.ReqBase req);
//
//    @POST("room/adminlist/")
//    Observable<HttpBase.RetBase> getAdminList(@Body HttpBase.ReqBase req);
//
//    @POST("user/geticopluslist/")
//    Observable<HttpBase.RetBase> getIconPlusList(@Body HttpBase.ReqBase req);
//
//    @POST("music/lib/list/")
//    Call<HttpBase.RetBase> getMyMusic(@Body HttpBase.ReqBase req);
//
//    @POST("music/hot/list/")
//    Observable<HttpBase.RetBase> getServerMusic(@Body HttpBase.ReqBase req);
//
//    @POST("music/search/")
//    Observable<HttpBase.RetBase> searchServerMusic(@Body HttpBase.ReqBase req);
//
//    @POST("music/lib/operate/")
//    Call<HttpBase.RetBase> musicOperate(@Body HttpBase.ReqBase req);
//
//    @POST("music/download/")
//    Call<HttpBase.RetBase> reportMusicDownload(@Body HttpBase.ReqBase req);
//
//    @POST("user/likeu/")
//    Observable<HttpBase.RetBase> likeSome(@Body HttpBase.ReqBase req);
//
//    @POST("user/likemelist/")
//    Observable<HttpBase.RetBase> getLikeList(@Body HttpBase.ReqBase req);
//
//    @POST("user/gettalkcfg/")
//    Observable<HttpBase.RetBase> getTalkSwitcher(@Body HttpBase.ReqBase req);
//
//    @POST("user/settalkcfg/")
//    Observable<HttpBase.RetBase> setTalkSwitcher(@Body HttpBase.ReqBase req);
//
//    @POST("user/getblacklist/")
//    Observable<HttpBase.RetBase> getBlackList(@Body HttpBase.ReqBase req);
//
//    @POST("user/getuserheylevel/")
//    Observable<HttpBase.RetBase> getLevelDetail(@Body HttpBase.ReqBase req);
//
//    @POST("gift/user/send/")
//    Observable<HttpBase.RetBase> sendGift(@Body HttpBase.ReqBase req);
//
//    @POST("room/search/")
//    Call<HttpBase.RetBase> searchRoom(@Body HttpBase.ReqBase req);
//
//    @POST("user/search/query/")
//    Call<HttpBase.RetBase> searchUser(@Body HttpBase.ReqBase req);
//
//
//    @POST("pay/getorder/")
//    Observable<HttpBase.RetBase> requestOrder(@Body HttpBase.ReqBase req);
//
//    @POST("pay/getpayresult/")
//    Observable<HttpBase.RetBase> getPayOrderResult(@Body HttpBase.ReqBase req);
//
//    @POST("pay/goodslist/")
//    Observable<HttpBase.RetBase> getPayGoodsList(@Body HttpBase.ReqBase req);
//
//    @POST("pay/goodslist/new/")
//    Observable<HttpBase.RetBase> getPayGoodsListNew(@Body HttpBase.ReqBase req);
//
//    @POST("user/searchattentions/")
//    Call<HttpBase.RetBase> searchFollow(@Body HttpBase.ReqBase req);
//
//    @POST("user/searchfans/")
//    Call<HttpBase.RetBase> searchFans(@Body HttpBase.ReqBase req);
//
//    @POST("user/getlevelrules/")
//    Observable<HttpBase.RetBase> getLevelRules(@Body HttpBase.ReqBase req);
//
//    @POST("user/getlevellist/")
//    Observable<HttpBase.RetBase> getLevelList(@Body HttpBase.ReqBase req);
//
//    @POST("login/prelogin/")
//    Observable<HttpBase.RetBase> preLogin(@Body HttpBase.ReqBase req);
//    @POST("login/check/")
//    Observable<HttpBase.RetBase> loginCheck(@Body HttpBase.ReqBase req);
//
//    @POST("login/third/bindcheck/")
//    Observable<HttpBase.RetBase> bindcheck(@Body HttpBase.ReqBase req);
//
//    @POST("login/verify/")
//    Observable<HttpBase.RetBase> sendCheckCodeMessage(@Body HttpBase.ReqBase req);
//
//    @POST("login/regist/")
//    Observable<HttpBase.RetBase> regist(@Body HttpBase.ReqBase req);
//
//    @POST("login/fetch/logininfo/")
//    Call<HttpBase.RetBase> fetchLoginInfo(@Body HttpBase.ReqBase req);
//
//    @POST("login/fetch/logininfo/")
//    Observable<HttpBase.RetBase> fetchLoginInfo2(@Body HttpBase.ReqBase req);
//
//    @POST("user/list/")
//    Call<HttpBase.RetBase> getUserInfoSync(@Body HttpBase.ReqBase req);
//
//    @POST("login/third/login/")
//    Observable<HttpBase.RetBase> thirdLogin(@Body HttpBase.ReqBase req);
//
//    @POST("user/getuserinfobyphone/")
//    Observable<HttpBase.RetBase> getuserinfobyphone(@Body HttpBase.ReqBase req);
//
//    @POST("system/sercet/")
//    Call<HttpBase.RetBase> getWeChatSercet(@Body HttpBase.ReqBase req);
//
//    @GET()
//    Call<ResponseBody> getWeChatIdAndToken(@Url String url, @Query("appid") String appid, @Query("secret") String secret, @Query("grant_type") String grant_type, @Query("code") String code);
//
//    @GET()
//    Call<ResponseBody> getWeChatUserInfo(@Url String url, @Query("access_token") String access_token, @Query("openid") String openid, @Query("lang") String lang);
//
//
//    @POST("login/setpwd/")
//    Observable<HttpBase.RetBase> setpwd(@Body HttpBase.ReqBase req);
//
//    @POST("login/chgpwd/")
//    Observable<HttpBase.RetBase> chgpwd(@Body HttpBase.ReqBase req);
//
//    @POST("login/exchange/phone/")
//    Observable<HttpBase.RetBase> exchange(@Body HttpBase.ReqBase req);
//
//    @POST("login/exchange/verify/")
//    Observable<HttpBase.RetBase> exchangePhoneVerify(@Body HttpBase.ReqBase req);
//
//    @POST("gift/getgifts/")
//    Observable<HttpBase.RetBase> getGifts(@Body HttpBase.ReqBase req);
//
//    @POST("room/list/page/")
//    Observable<HttpBase.RetBase> getRoomListPage(@Body HttpBase.ReqBase req);
//
//    @POST("user/qiuqiu/attentions/")
//    Observable<HttpBase.RetBase> getQiuQiuFollow(@Body HttpBase.ReqBase req);
//
//    @POST("user/qiuqiu/fans/")
//    Observable<HttpBase.RetBase> getQiuQiuFans(@Body HttpBase.ReqBase req);
//
//    @POST("user/qiuqiu/card/")
//    Observable<HttpBase.RetBase> getQiuQiuCard(@Body HttpBase.ReqBase req);
//
//    @POST("user/qiuqiu/card/")
//    Call<HttpBase.RetBase> getQiuQiuCardSync(@Body HttpBase.ReqBase req);
//
//    @POST("qiuqiu/team/invitelist/")
//    Observable<HttpBase.RetBase> getQiuQiuTeamInviteList(@Body HttpBase.ReqBase req);
//
//    @POST("user/qiuqiu/logintype/")
//    Observable<HttpBase.RetBase> getQiuQiuLoginType(@Body HttpBase.ReqBase req);
//
//    @POST("user/hey/qiuqiu/attention/")
//    Observable<HttpBase.RetBase> getQiuqiuHeyAttention(@Body HttpBase.ReqBase req);
//
//    @POST("user/getuseractivelevel/")
//    Observable<HttpBase.RetBase> getActiveLevel(@Body HttpBase.ReqBase req);
//
//    @POST("user/qiuqiu/userinfo/")
//    Observable<HttpBase.RetBase> getQiuqiuUserInfo(@Body HttpBase.ReqBase req);
//
//    //设置备注
//    @POST("user/setalias/")
//    Observable<HttpBase.RetBase> setRemarks(@Body HttpBase.ReqBase req);
//
//    @POST("system/applog/")
//    Call<HttpBase.RetBase> log(@Body HttpBase.ReqBase req);
//
//    @POST("user/ranklist/")
//    Observable<HttpBase.RetBase> getRanklist(@Body HttpBase.ReqBase req);
//
//    @POST("room/getchannellist/")
//    Observable<HttpBase.RetBase> getRoomChannelList(@Body HttpBase.ReqBase req);
//    @POST("room/getchannellist/2/")
//    Observable<HttpBase.RetBase> getRoomChannelList_2(@Body HttpBase.ReqBase req);
//
//    @POST("room/getchannel115/")
//    Observable<HttpBase.RetBase> getRoomChannelById(@Body HttpBase.ReqBase req);
//
//    @POST("room/getbglist/")
//    Observable<HttpBase.RetBase> getRoomSkinList(@Body HttpBase.ReqBase req);
//
//    @POST("room/getbg/")
//    Observable<HttpBase.RetBase> getRoomSkinInfo(@Body HttpBase.ReqBase req);
//
//    @POST("room/list/19/2/")
//    Observable<HttpBase.RetBase> getRoomList19(@Body HttpBase.ReqBase req);
//
//    @POST("room/chan/room/2/")
//    Observable<HttpBase.RetBase> getRoomChannel(@Body HttpBase.ReqBase req);
//
//    @POST("room/chan/random/")
//    Observable<HttpBase.RetBase> getRoomRandom(@Body HttpBase.ReqBase req);
//
//    @POST("login/third/fetch/")
//    Observable<HttpBase.RetBase> loginThirdFetch(@Body HttpBase.ReqBase req);
//
//    @POST("login/third/bind/")
//    Observable<HttpBase.RetBase> loginThirdBind(@Body HttpBase.ReqBase req);
//
//    @POST("login/third/unbind/")
//    Observable<HttpBase.RetBase> loginThirdUnBind(@Body HttpBase.ReqBase req);
//
//    @POST("user/getblackcoin/")
//    Observable<HttpBase.RetBase> getBlackCoin(@Body HttpBase.ReqBase req);
//
//    @POST("user/withdrawlist/")
//    Observable<HttpBase.RetBase> getExchangeHistory(@Body HttpBase.ReqBase req);
//    @POST("pay/convertgoodslist/")
//    Observable<HttpBase.RetBase> getConvertGoodsList(@Body HttpBase.ReqBase req);
//    @POST("pay/convert/")
//    Observable<HttpBase.RetBase> payConvertGoods(@Body HttpBase.ReqBase req);
//
//    @POST("user/checkverifycode/")
//    Observable<HttpBase.RetBase> phoneVerify(@Body HttpBase.ReqBase req);
//    @POST("user/setusercard/")
//    Observable<HttpBase.RetBase> setUserId(@Body HttpBase.ReqBase req);
//    @POST("user/getbankinfo/")
//    Observable<HttpBase.RetBase> getBankInfo(@Body HttpBase.ReqBase req);
//    @POST("user/setuserbank/")
//    Observable<HttpBase.RetBase> setUserCard(@Body HttpBase.ReqBase req);
//    @POST("user/withdraw/")
//    Observable<HttpBase.RetBase> exchangeCash(@Body HttpBase.ReqBase req);
//
//    @POST("game/fetch/")
//    Observable<HttpBase.RetBase> bindGameFetch(@Body HttpBase.ReqBase req);
//    @GET()
//    Call<ResponseBody> getBattleRoyaleInfo(@Url String url, @Query("nickname") String nickName);
//
//    @POST("game/set/kill/")
//    Observable<HttpBase.RetBase> setBattleRoyale(@Body HttpBase.ReqBase req);
//    @POST("game/set/kings/")
//    Observable<HttpBase.RetBase> setStrikeOfKings(@Body HttpBase.ReqBase req);
//    @POST("game/kings/chose/")
//    Observable<HttpBase.RetBase> getStrikeOfKings(@Body HttpBase.ReqBase req);
//    @POST("game/filte/bob/")
//    Observable<HttpBase.RetBase> getRoomQiuQiuMemberList(@Body HttpBase.ReqBase req);
//    @POST("game/filte/king/")
//    Observable<HttpBase.RetBase> getRoomWangzheMemberList(@Body HttpBase.ReqBase req);
//    @POST("game/filte/kill/")
//    Observable<HttpBase.RetBase> getRoomChijiMemberList(@Body HttpBase.ReqBase req);
//    @POST("game/filte/other/")
//    Observable<HttpBase.RetBase> getRoomOtherMemberList(@Body HttpBase.ReqBase req);
//    @POST("comment/like/")
//    Observable<HttpBase.RetBase> likeComment(@Body HttpBase.ReqBase req);
//    @POST("comment/del/like/")
//    Observable<HttpBase.RetBase> unLikeComment(@Body HttpBase.ReqBase req);
//    @POST("comment/dolist/write/")
//    Observable<HttpBase.RetBase> getCommentMessageList(@Body HttpBase.ReqBase req);
//    @POST("comment/write/")
//    Observable<HttpBase.RetBase> sendCommentMessage(@Body HttpBase.ReqBase req);
//    @POST("comment/del/write/")
//    Observable<HttpBase.RetBase> removeCommentMessage(@Body HttpBase.ReqBase req);
//    @POST("hudong/comment/like/")
//    Observable<HttpBase.RetBase> getInteractionLikeList(@Body HttpBase.ReqBase req);
//    @POST("hudong/comment/write/")
//    Observable<HttpBase.RetBase> getInteractionMessageList(@Body HttpBase.ReqBase req);
//    @POST("hudong/del/like/")
//    Observable<HttpBase.RetBase> removeInteractionLike(@Body HttpBase.ReqBase req);
//    @POST("hudong/del/write/")
//    Observable<HttpBase.RetBase> removeInteractionMessage(@Body HttpBase.ReqBase req);
//    @POST("hudong/clean/")
//    Observable<HttpBase.RetBase> clearInteractionChildList(@Body HttpBase.ReqBase req);
//    @POST("room/list/114/")
//    Observable<HttpBase.RetBase> getRoomList114(@Body HttpBase.ReqBase req);
////    @POST("room/chan/room/114/2/")
////    Observable<HttpBase.RetBase> getRoomGameChannel(@Body HttpBase.ReqBase req);
//    @POST("room/chan/room/115/")
//    Observable<HttpBase.RetBase> getRoomGameChannel(@Body HttpBase.ReqBase req);
//    @POST("user/attentions/game/")
//    Call<HttpBase.RetBase> getFollowListByChannelSync(@Body HttpBase.ReqBase req);
//    @POST("game/fetch/config/")
//    Call<HttpBase.RetBase> getGameConfigSync(@Body HttpBase.ReqBase req);
//
//    @POST("game/fetch/config/")
//    Observable<HttpBase.RetBase> getGameConfig(@Body HttpBase.ReqBase req);
//    @POST("game/fetch/gamedata/")
//    Observable<HttpBase.RetBase> getGameData(@Body HttpBase.ReqBase req);
//    @POST("game/set/item/")
//    Observable<HttpBase.RetBase> setGameData(@Body HttpBase.ReqBase req);
//    @POST("game/user/list/")
//    Observable<HttpBase.RetBase> getUserGameList(@Body HttpBase.ReqBase req);
//    @POST("game/list/")
//    Observable<HttpBase.RetBase> getGameList(@Body HttpBase.ReqBase req);
//    @POST("game/filter/userlist/")
//    Observable<HttpBase.RetBase> getRoomGameMemberList(@Body HttpBase.ReqBase req);
//    @POST("active/info/")
//    Observable<HttpBase.RetBase> getOnLineConfig(@Body HttpBase.ReqBase req);
//    @POST("active/goodidlist/")
//    Observable<HttpBase.RetBase> getGoodIdList(@Body HttpBase.ReqBase req);
//    @POST("active/exheyid/")
//    Observable<HttpBase.RetBase> modifyHeyId(@Body HttpBase.ReqBase req);
//    @POST("active/getaword/")
//    Observable<HttpBase.RetBase> getQualification(@Body HttpBase.ReqBase req);
//    @POST("active/guanming/")
//    Observable<HttpBase.RetBase> giftNaming(@Body HttpBase.ReqBase req);
//    @POST("active/ranklist/")
//    Observable<HttpBase.RetBase> getOnLineRanklist(@Body HttpBase.ReqBase req);
//    @POST("active/senditem/")
//    Observable<HttpBase.RetBase> sendOnLineFadeGift(@Body HttpBase.ReqBase req);
//    @POST("item/userbill/")
//    Observable<HttpBase.RetBase> getOnLineHistory(@Body HttpBase.ReqBase req);
//    @POST("room/invite/")
//    Call<HttpBase.RetBase> getRoomInviteListSync(@Body HttpBase.ReqBase req);
//    @POST("room/chanlist/115/")
//    Call<HttpBase.RetBase> getRoomList115Sync(@Body HttpBase.ReqBase req);
//    @POST("system/robot/")
//    Observable<HttpBase.RetBase> reportRobot(@Body HttpBase.ReqBase req);

//    /**
//     * 上传用户头像
//     */
//    @FormUrlEncoded
//    @POST("login/avatar/")
//    Observable<HttpResult> editUserAvatar(@Field("Uid") long uid, @Field("Url") String url);

//    /**
//     * 上传文件
//     *
//     * @return
//     */
//    @Multipart
//    @POST()
//    Observable<HttpResult<PhotoInfo>> uploadFile(@Url String url, @Query("session") String session, @Query("type") String type, @Part("uploadfile\"; filename=\"chatImage.jpg") RequestBody file);
//
//    /**
//     * 上传视频
//     */
//    @Multipart
//    @POST()
//    Observable<HttpResult<PhotoInfo>> uploadImageAsync(@Url String url, @Query("session") String session, @Query("type") String type, @Part("uploadfile\"; filename=\"chatImage.jpg") RequestBody file);
//
//
//    @Multipart
//    @POST()
//    Call<HttpResult<PhotoInfo>> uploadImageSync(@Url String url, @Query("session") String session, @Query("type") String type, @Part("uploadfile\"; filename=\"chatImage.jpg") RequestBody file);
//
//    /**
//     * 上传音频
//     */
//    @Multipart
//    @POST()
//    Observable<HttpResult<PhotoInfo>> uploadAudioAsync(@Url String url, @Query("session") String session, @Query("type") String type, @Query("kind") int kind, @Query("time") int time, @Part("uploadfile\"; filename=\"chatVoice.aac") RequestBody file);
//
//    /**
//     * 上传音频
//     */
//    @Multipart
//    @POST()
//    Call<HttpResult<PhotoInfo>> uploadAudioSync(@Url String url, @Query("session") String session, @Query("type") String type, @Query("kind") int kind, @Query("time") int time, @Part("uploadfile\"; filename=\"chatVoice.aac") RequestBody file);
//
//
//    /**
//     * 下载文件
//     */
//    @Streaming
//    @GET()
//    ResponseBody downloadFileAsync(@Url String fileUrl);
//
//    /**
//     * 下载文件
//     */
//    @GET()
//    Call<ResponseBody> downloadFileSync(@Url String url);

//    @POST()
//    Call<ResponseBody> notifyTest(@Url String url, @Query("cmd") String cmd, @Query("type") String type, @Query("leaderid") String leaderid,@Query("qrcode") String qrcode,@Query("params") String params);

}
