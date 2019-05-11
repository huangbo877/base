package com.xpzones.net;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.BaseRequest;
import com.xpzones.base.BaseModel;
import com.xpzones.bean.DistictCodeBean;
import com.xpzones.net.callback.JsonCallback;
import com.xpzones.net.callback.XZoneNetCallBack;
import com.xpzones.utils.AppSysMgr;
import com.xpzones.utils.InfoUtil;


import okhttp3.Call;
import okhttp3.Response;

public class NetManager {

    private static NetManager netManager;

    public static NetManager getInstance() {
        if (netManager == null) {
            netManager = new NetManager();
        }
        return netManager;
    }


//    /**
//     * 获取areId
//     * @param distictCode
//     * @param lng
//     * @param lat
//     * @param callBack
//     */
//    public void GetMallAreaByDistictCode(String distictCode, String lng, String lat, final XZoneNetCallBack<DistictCodeBean> callBack) {
//        OkGo.post(NetConfig.Url.GetMallAreaByDistictCode) // 请求方式和请求url
//                .tag(this)
//                .params("distictCode",distictCode)
//                .params("lng",lng)
//                .params("lat",lat)
//                .execute(new JsonCallback<BaseModel<DistictCodeBean>>() {
//                    @Override
//                    public void onBefore(BaseRequest request) {
//                    }
//
//                    @Override
//                    public void onAfter(BaseModel<DistictCodeBean> queryStoreModelBaseModel, Exception e) {
//                    }
//
//                    @Override
//                    public void onError(Call call, Response response, Exception e) {
//                        callBack.onFailed(e.getMessage());
//                    }
//
//                    @Override
//                    public void onSuccess(final BaseModel<DistictCodeBean> baseModel, Call call, Response response) {
//                        if (baseModel.status == 1 && baseModel.result != null) {
//                            InfoUtil.setareaId(baseModel.result.areaId);
//                            InfoUtil.setfreight(baseModel.result.freight);
//                            InfoUtil.setfreightFeePrice(baseModel.result.freightFeePrice);
//                            InfoUtil.setorderStart(baseModel.result.orderStart);
//                            InfoUtil.setorderEnd(baseModel.result.orderEnd);
//                            callBack.onSucceed(baseModel.result);
//                        }
//                    }
//                });
//    }
//    public void AutoLogin(final XZoneNetCallBack<DistictCodeBean> callBack) {
//        OkGo.post(NetConfig.Url.AutoLogin) // 请求方式和请求url
//                .tag(this)
//                .params("phone", InfoUtil.getTelephone())
//                .params("passcode", InfoUtil.getPasscode())
//                .params("pnsToken", InfoUtil.getChannelId())
//                .params("platForm", "2")
//                .params("deviceCode", AppSysMgr.getPsuedoUniqueID())
//                .execute(new JsonCallback<BaseModel<DistictCodeBean>>() {
//                    @Override
//                    public void onBefore(BaseRequest request) {
//                    }
//
//                    @Override
//                    public void onAfter(BaseModel<DistictCodeBean> queryStoreModelBaseModel, Exception e) {
//                    }
//
//                    @Override
//                    public void onError(Call call, Response response, Exception e) {
//                        callBack.onFailed(e.getMessage());
//                    }
//
//                    @Override
//                    public void onSuccess(final BaseModel<DistictCodeBean> baseModel, Call call, Response response) {
//                        if (baseModel.status == 1 && baseModel.result != null) {
//                            InfoUtil.setareaId(baseModel.result.areaId);
//                            InfoUtil.setfreight(baseModel.result.freight);
//                            InfoUtil.setfreightFeePrice(baseModel.result.freightFeePrice);
//                            InfoUtil.setorderStart(baseModel.result.orderStart);
//                            InfoUtil.setorderEnd(baseModel.result.orderEnd);
//                            callBack.onSucceed(baseModel.result);
//                        }
//                    }
//                });
//    }

}
