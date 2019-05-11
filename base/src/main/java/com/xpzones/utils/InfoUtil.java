package com.xpzones.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xpzones.base.BaseApplication;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/27.
 */

public class InfoUtil {

    public static void setHgPrice(String is) {
        BaseApplication.sp.putString("hgPrice", is);
    }

    public static String getHgPrice() {
        return BaseApplication.sp.getString("hgPrice", "0");
    }

    public static void setCity(String is) {
        BaseApplication.sp.putString("City", is);
    }

    public static String getCity() {
        return BaseApplication.sp.getString("City", "汕头");
    }

    public static void setSouls(String is) {
        if (!is.isEmpty()) {
            if (BaseApplication.sp.getString("Souls", "").contains(is + ",")) {
                String str = BaseApplication.sp.getString("Souls", "").replace(is + ",", "");
                BaseApplication.sp.putString("Souls", str);
//                LogUtil.Log(App.sp.getString("Souls", ""));
            }

            BaseApplication.sp.putString("Souls", is + "," + BaseApplication.sp.getString("Souls", ""));
//            LogUtil.Log(App.sp.getString("Souls", ""));
        }
    }
    public static void removeSouls(String is) {
        if (!is.isEmpty()) {
//            if (App.sp.getString("Souls", "").contains(is + ",")) {
                String str = BaseApplication.sp.getString("Souls", "").replace(is + ",", "");
            BaseApplication.sp.putString("Souls", str);
//                LogUtil.Log(App.sp.getString("Souls", ""));
//            }

//            App.sp.putString("Souls", is + "," + App.sp.getString("Souls", ""));
//            LogUtil.Log(App.sp.getString("Souls", ""));
        }
    }
    public static String getSouls() {
        return BaseApplication.sp.getString("Souls", "");
    }

    public static void setkufumsg(String is) {
        BaseApplication.sp.putString("kufumsg", is);
    }

    public static String getkufumsg() {
        return BaseApplication.sp.getString("kufumsg", "");
    }

    public static void setCouponId(String is) {
        BaseApplication.sp.putString("CouponId", is);
    }

    public static String getCouponId() {
        return BaseApplication.sp.getString("CouponId", "0");
    }

    public static void settradePwd(String id) {
        BaseApplication.sp.putString("tradePwd", id);
    }

    public static String gettradePwd() {
        return BaseApplication.sp.getString("tradePwd", "");
    }

    public static void setservice(String id) {
        BaseApplication.sp.putString("service", id);
    }

    public static String getservice() {
        return BaseApplication.sp.getString("service", "");
    }

    public static void setAddx(String id) {
        BaseApplication.sp.putString("Addx", id);
    }

    public static String getAddx() {
        return BaseApplication.sp.getString("Addx", "");
    }

    public static void setPay(String id) {
        BaseApplication.sp.putString("PayType", id);
    }

    public static String getPay() {
        return BaseApplication.sp.getString("PayType", "");
    }

    public static void setZP(String id) {
        BaseApplication.sp.putString("ZP", id);
    }

    public static String getZP() {
        return BaseApplication.sp.getString("ZP", "");
    }

    public static void setLogin(Boolean is) {
        BaseApplication.sp.putBoolean("Login", is);
    }

    public static Boolean getLogin() {
        return BaseApplication.sp.getBoolean("Login", false);
    }

    public static void setOne(Boolean is) {
        BaseApplication.sp.putBoolean("One", is);
    }

    public static Boolean getOne() {
        return BaseApplication.sp.getBoolean("One", false);
    }

    public static void setChannelId(String id) {
        BaseApplication.sp.putString("ChannelId", id);
    }

    public static String getChannelId() {
        return BaseApplication.sp.getString("ChannelId", "");
    }

    public static void setImei(String id) {
        BaseApplication.sp.putString("Imei", id);
    }

    public static String getImei() {
        return BaseApplication.sp.getString("Imei", "");
    }

    public static void setUUid(String id) {
        BaseApplication.sp.putString("UUid", id);
    }

    public static String getUUid() {
        return BaseApplication.sp.getString("UUid", "");
    }

    public static void setVersions(String id) {
        BaseApplication.sp.putString("Version", id);
    }

    public static String getVersions() {
        return BaseApplication.sp.getString("Version", "");
    }

    public static void setRemark(String id) {
        BaseApplication.sp.putString("Remark", id);
    }

    public static String getRemark() {
        return BaseApplication.sp.getString("Remark", "");
    }

    public static void setToken(String id) {
        BaseApplication.sp.putString("Token", id);
    }

    public static String getToken() {
        return BaseApplication.sp.getString("Token", "");
    }

    public static void setOpenId(String id) {
        BaseApplication.sp.putString("openId", id);
    }

    public static String getOpenId() {
        return BaseApplication.sp.getString("openId", "");
    }

    public static void setCode(String id) {
        BaseApplication.sp.putString("Code", id);
    }

    public static String getCode() {
        return BaseApplication.sp.getString("Code", "");
    }

    public static void setUnionId(String id) {
        BaseApplication.sp.putString("unionId", id);
    }

    public static String getUnionId() {
        return BaseApplication.sp.getString("unionId", "");
    }

    public static void setNickName(String id) {
        BaseApplication.sp.putString("nickName", id);
    }

    public static String getNickName() {
        return BaseApplication.sp.getString("nickName", "");
    }

    public static void setUserId(String id) {
        BaseApplication.sp.putString("UserId", id);
    }

    public static String getUserId() {
        return BaseApplication.sp.getString("UserId", "");
    }

    public static void settitleId(String id) {
        BaseApplication.sp.putString("titleId", id);
    }

    public static String gettitleId() {
        return BaseApplication.sp.getString("titleId", "");
    }

    public static void setHeadImgUrl(String id) {
        BaseApplication.sp.putString("headImgUrl", id);
    }

    public static String getHeadImgUrl() {
        return BaseApplication.sp.getString("headImgUrl", "");
    }

    public static void setFaceUrl(String id) {
        BaseApplication.sp.putString("faceUrl", id);
    }

    public static String getFaceUrl() {
        return BaseApplication.sp.getString("faceUrl", "");
    }

    public static void setPasscode(String id) {
        BaseApplication.sp.putString("passcode", id);
    }

    public static String getPasscode() {
        return BaseApplication.sp.getString("passcode", "");
    }

    public static void setTelephone(String id) {
        BaseApplication.sp.putString("telephone", id);
    }

    public static String getTelephone() {
        return BaseApplication.sp.getString("telephone", "");
    }

    public static void setProductcategory(String id) {
        BaseApplication.sp.putString("productcategory", id);
    }

//    public static ProductModel getProductcategory() {
//        Gson gson = new Gson();
//        Type type = new TypeToken<ProductModel>() {
//        }.getType();
//        ProductModel jsonObjects = gson.fromJson(BaseApplication.sp.getString("productcategory", ""), type);
//        for (int i = 0; i < jsonObjects.category.size(); i++) {
//            ProductModel.CategoryBean.SubListBean model = new ProductModel.CategoryBean.SubListBean();
//            model.id = jsonObjects.category.get(i).id;
//            model.name = "全部";
//            jsonObjects.category.get(i).subList.add(0, model);
//        }
//        for (int i = 0; i < jsonObjects.subject.size(); i++) {
//            ProductModel.CategoryBean model = new ProductModel.CategoryBean();
//            model.id = jsonObjects.subject.get(i).id;
//            model.name = jsonObjects.subject.get(i).name;
//            model.color = jsonObjects.subject.get(i).color;
//            model.word = jsonObjects.subject.get(i).word;
//            model.type = "2";
//            jsonObjects.category.add(i, model);
//        }
//        return jsonObjects;
//    }
//
//    public static ProductModel getProductcategory1() {
//        Gson gson = new Gson();
//        Type type = new TypeToken<ProductModel>() {
//        }.getType();
//        ProductModel jsonObjects = gson.fromJson(BaseApplication.sp.getString("productcategory", ""), type);
//        for (int i = 0; i < jsonObjects.category.size(); i++) {
//            ProductModel.CategoryBean.SubListBean model = new ProductModel.CategoryBean.SubListBean();
//            model.id = jsonObjects.category.get(i).id;
//            model.name = "全部分类";
//            jsonObjects.category.get(i).subList.add(0, model);
//        }
//        for (int i = 0; i < jsonObjects.subject.size(); i++) {
////            ProductModel.CategoryBean model = new ProductModel.CategoryBean();
////            model.id = jsonObjects.subject.get(i).id;
////            model.name = jsonObjects.subject.get(i).name;
////            model.color = jsonObjects.subject.get(i).color;
////            model.word = jsonObjects.subject.get(i).word;
////            model.type = "2";
////            jsonObjects.category.add(i, model);
//        }
//        return jsonObjects;
//    }

//    public static void setCategory(String id) {
//        BaseApplication.sp.putString("Category", id);
//    }
//
//    public static ProductModel getCategory() {
//        Gson gson = new Gson();
//        Type type = new TypeToken<ProductModel>() {
//        }.getType();
//        ProductModel jsonObjects = gson.fromJson(BaseApplication.sp.getString("Category", ""), type);
//        return jsonObjects;
//    }
//
//    public static void setBanner(String id) {
//        BaseApplication.sp.putString("Banner", id);
//    }
//
//    public static NewHomeBean getBanner() {
//        Gson gson = new Gson();
//        Type type = new TypeToken<NewHomeBean>() {
//        }.getType();
//        NewHomeBean jsonObjects = gson.fromJson(BaseApplication.sp.getString("Banner", ""), type);
//        return jsonObjects;
//    }
//
//    public static void setIcon(String id) {
//        BaseApplication.sp.putString("Icon", id);
//    }
//
//    public static NewHomeBean getIcon() {
//        Gson gson = new Gson();
//        Type type = new TypeToken<NewHomeBean>() {
//        }.getType();
//        NewHomeBean jsonObjects = gson.fromJson(BaseApplication.sp.getString("Icon", ""), type);
//        return jsonObjects;
//    }
//
//    public static void setSubject(String id) {
//        BaseApplication.sp.putString("Subject", id);
//    }
//
//    public static NewHomeBean getSubject() {
//        Gson gson = new Gson();
//        Type type = new TypeToken<NewHomeBean>() {
//        }.getType();
//        NewHomeBean jsonObjects = gson.fromJson(BaseApplication.sp.getString("Subject", ""), type);
//        return jsonObjects;
//    }
//
//    public static void setRecommand(String id) {
//        BaseApplication.sp.putString("Recommand", id);
//    }
//
//    public static NewHomeBean getRecommand() {
//        Gson gson = new Gson();
//        Type type = new TypeToken<NewHomeBean>() {
//        }.getType();
//        NewHomeBean jsonObjects = gson.fromJson(BaseApplication.sp.getString("Recommand", ""), type);
//        return jsonObjects;
//    }

    public static void clear() {
        BaseApplication.sp.putString("titleId", "");
        BaseApplication.sp.putString("openId", "");
        BaseApplication.sp.putString("unionId", "");
        BaseApplication.sp.putString("nickName", "");
        BaseApplication.sp.putString("headImgUrl", "");
        BaseApplication.sp.putString("faceUrl", "");
        BaseApplication.sp.putString("telephone", "");
        BaseApplication.sp.putString("UserId", "");
        BaseApplication.sp.putString("Token", "");
        BaseApplication.sp.putInt("zPcon", 0);
        BaseApplication.sp.putBoolean("Login", false);
        BaseApplication.sp.putBoolean("One", false);
//        BaseApplication.sp.clear();
    }


    public static void setlocLongitude(String id) {
        BaseApplication.sp.putString("locLongitude", id);
    }

    public static String getlocLongitude() {
        return BaseApplication.sp.getString("locLongitude", "");
    }

    public static void setPcon(String pid, int id) {
        BaseApplication.sp.putInt("Pid" + pid, id);
    }

    public static void setPcon(String pid, boolean is) {
        BaseApplication.sp.putBoolean("Pids" + pid, is);
    }

    public static int getPcon(String pid) {

        return BaseApplication.sp.getInt("Pid" + pid, 0);
    }

    public static void setzPcon(int id) {
        BaseApplication.sp.putInt("zPcon", id);
    }

    public static int getzPcon() {
        return BaseApplication.sp.getInt("zPcon", 0);
    }

    public static void setcartId(String pid, String id) {
        BaseApplication.sp.putString("cartId" + pid, id);
    }

    public static String getcartId(String pid) {
        return BaseApplication.sp.getString("cartId" + pid, "");
    }


    public static void setlocLatitude(String id) {
        BaseApplication.sp.putString("locLatitude", id);
    }

    public static String getlocLatitude() {
        return BaseApplication.sp.getString("locLatitude", "");
    }

    public static void setadder(String id) {
        BaseApplication.sp.putString("adder", id);
    }

    public static String getadder() {
        return BaseApplication.sp.getString("adder", "");
    }

    public static void setareaId(String id) {
        BaseApplication.sp.putString("areaId", id);
    }

    public static String getareaId() {
        return BaseApplication.sp.getString("areaId", "");
    }

    public static void setminPrice(String id) {
        BaseApplication.sp.putString("minPrice", id);
    }

    public static String getminPrice() {
        return BaseApplication.sp.getString("minPrice", "");
    }

    public static void setfreightFree(String id) {
        BaseApplication.sp.putString("freightFree", id);
    }

    public static String getfreightFree() {
        return BaseApplication.sp.getString("freightFree", "");
    }

    public static void setfreight(String id) {
        BaseApplication.sp.putString("freight", id);
    }

    public static String getfreight() {
        return BaseApplication.sp.getString("freight", "");
    }

    public static void setfreightFeePrice(String id) {
        BaseApplication.sp.putString("freightFeePrice", id);
    }

    public static String getfreightFeePrice() {
        return BaseApplication.sp.getString("freightFeePrice", "");
    }

    public static void setorderStart(String id) {
        BaseApplication.sp.putString("orderStart", id);
    }

    public static String getorderStart() {
        return BaseApplication.sp.getString("orderStart", "");
    }

    public static void setorderEnd(String id) {
        BaseApplication.sp.putString("orderEnd", id);
    }

    public static String getorderEnd() {
        return BaseApplication.sp.getString("orderEnd", "");
    }

    public static void setAmount(String id) {
        BaseApplication.sp.putString("Amount", id);
    }

    public static String getAmount() {
        return BaseApplication.sp.getString("Amount", "");
    }

    public static void setQRCode(String id) {
        BaseApplication.sp.putString("Amount", id);
    }

    public static String getQRCode() {
        return BaseApplication.sp.getString("Amount", "");
    }

    public static void setBalance(String id) {
        BaseApplication.sp.putString("Balance", id);
    }

    public static String getBalance() {
        return BaseApplication.sp.getString("Balance", "0");
    }

    public static void setShopName(String id) {
        BaseApplication.sp.putString("ShopName", id);
    }

    public static String getOrderID() {
        return BaseApplication.sp.getString("OrderID", "");
    }

    public static void setOrderID(String id) {
        BaseApplication.sp.putString("OrderID", id);
    }

    public static String getuseTradePwd() {
        return BaseApplication.sp.getString("useTradePwd", "");
    }

    public static void setuseTradePwd(String id) {
        BaseApplication.sp.putString("useTradePwd", id);
    }

    public static String getShopName() {
        return BaseApplication.sp.getString("ShopName", "");
    }

    public static void setArrearsP(ArrayList<String> id) {
        BaseApplication.sp.putString("Pname" + id.get(0), id.get(1));
        BaseApplication.sp.putString("PmemberPrice" + id.get(0), id.get(2));
        BaseApplication.sp.putString("PvipPrice" + id.get(0), id.get(3));
        BaseApplication.sp.putString("Pimg" + id.get(0), id.get(4));
        BaseApplication.sp.putString("Pspec" + id.get(0), id.get(5));
        BaseApplication.sp.putString("PstockCount" + id.get(0), id.get(6));
    }

    public static ArrayList<String> getArrearsP(String id) {
        ArrayList<String> pay = new ArrayList<String>();
        pay.add(id);
        pay.add(BaseApplication.sp.getString("Pname" + id, "0"));
        pay.add(BaseApplication.sp.getString("PmemberPrice" + id, "0"));
        pay.add(BaseApplication.sp.getString("PvipPrice" + id, "0"));
        pay.add(BaseApplication.sp.getString("Pimg" + id, "0"));
        pay.add(BaseApplication.sp.getString("Pspec" + id, "0"));
        pay.add(BaseApplication.sp.getString("PstockCount" + id, "0"));
        return pay;
    }

    public static void setlatticePay(ArrayList<String> id) {
        BaseApplication.sp.putString("latticePay0", id.get(0));
        BaseApplication.sp.putString("latticePay1", id.get(1));
        BaseApplication.sp.putString("latticePay2", id.get(2));
        BaseApplication.sp.putString("latticePay3", id.get(3));
    }

    public static ArrayList<String> getlatticePay() {
        ArrayList<String> pay = new ArrayList<String>();
        pay.add(BaseApplication.sp.getString("latticePay0", "0"));
        pay.add(BaseApplication.sp.getString("latticePay1", "0"));
        pay.add(BaseApplication.sp.getString("latticePay2", "0"));
        pay.add(BaseApplication.sp.getString("latticePay3", "0"));
        return pay;
    }

    public static void setshopPay(ArrayList<String> id) {
        BaseApplication.sp.putString("shopPay0", id.get(0));
        BaseApplication.sp.putString("shopPay1", id.get(1));
        BaseApplication.sp.putString("shopPay2", id.get(2));
        BaseApplication.sp.putString("shopPay3", id.get(3));
        BaseApplication.sp.putString("shopPay4", id.get(4));
    }

    public static ArrayList<String> getshopPay() {
        ArrayList<String> pay = new ArrayList<String>();
        pay.add(BaseApplication.sp.getString("shopPay0", "0"));
        pay.add(BaseApplication.sp.getString("shopPay1", "0"));
        pay.add(BaseApplication.sp.getString("shopPay2", "0"));
        pay.add(BaseApplication.sp.getString("shopPay3", "0"));
        pay.add(BaseApplication.sp.getString("shopPay4", "0"));

        return pay;
    }

    public static void setmallPay(ArrayList<String> id) {
        BaseApplication.sp.putString("mallPay0", id.get(0));
        BaseApplication.sp.putString("mallPay1", id.get(1));
        BaseApplication.sp.putString("mallPay2", id.get(2));
        BaseApplication.sp.putString("mallPay3", id.get(3));
        BaseApplication.sp.putString("mallPay4", id.get(4));
    }

    public static ArrayList<String> getmallPay() {
        ArrayList<String> pay = new ArrayList<String>();
        pay.add(BaseApplication.sp.getString("mallPay0", "0"));
        pay.add(BaseApplication.sp.getString("mallPay1", "0"));
        pay.add(BaseApplication.sp.getString("mallPay2", "0"));
        pay.add(BaseApplication.sp.getString("mallPay3", "0"));
        pay.add(BaseApplication.sp.getString("mallPay4", "0"));

        return pay;
    }

    public static void setArrearsPay(ArrayList<String> id) {
        BaseApplication.sp.putString("ArrearsPay0", id.get(0));
        BaseApplication.sp.putString("ArrearsPay1", id.get(1));
        BaseApplication.sp.putString("ArrearsPay2", id.get(2));
        BaseApplication.sp.putString("ArrearsPay3", id.get(3));
        BaseApplication.sp.putString("ArrearsPay4", id.get(4));
    }

    public static ArrayList<String> getArrearsPay() {
        ArrayList<String> pay = new ArrayList<String>();
        pay.add(BaseApplication.sp.getString("ArrearsPay0", "0"));
        pay.add(BaseApplication.sp.getString("ArrearsPay1", "0"));
        pay.add(BaseApplication.sp.getString("ArrearsPay2", "0"));
        pay.add(BaseApplication.sp.getString("ArrearsPay3", "0"));
        pay.add(BaseApplication.sp.getString("ArrearsPay4", "0"));
        return pay;
    }

    public static void setTopUpPay(ArrayList<String> id) {
        BaseApplication.sp.putString("TopUpPay0", id.get(0));
        BaseApplication.sp.putString("TopUpPay1", id.get(1));
        BaseApplication.sp.putString("TopUpPay2", id.get(2));
        BaseApplication.sp.putString("TopUpPay3", id.get(3));
        BaseApplication.sp.putString("TopUpPay4", id.get(4));
    }

    public static ArrayList<String> getTopUpPay() {
        ArrayList<String> pay = new ArrayList<String>();
        pay.add(BaseApplication.sp.getString("TopUpPay0", "0"));
        pay.add(BaseApplication.sp.getString("TopUpPay1", "0"));
        pay.add(BaseApplication.sp.getString("TopUpPay2", "0"));
        pay.add(BaseApplication.sp.getString("TopUpPay3", "0"));
        pay.add(BaseApplication.sp.getString("TopUpPay4", "0"));
        return pay;
    }

    public static void setOrderPay(ArrayList<String> id) {
        BaseApplication.sp.putString("OrderPay0", id.get(0));
        BaseApplication.sp.putString("OrderPay1", id.get(1));
        BaseApplication.sp.putString("OrderPay2", id.get(2));
        BaseApplication.sp.putString("OrderPay3", id.get(3));
        BaseApplication.sp.putString("OrderPay4", id.get(4));
    }

    public static ArrayList<String> getOrderPay() {
        ArrayList<String> pay = new ArrayList<String>();
        pay.add(BaseApplication.sp.getString("OrderPay0", "0"));
        pay.add(BaseApplication.sp.getString("OrderPay1", "0"));
        pay.add(BaseApplication.sp.getString("OrderPay2", "0"));
        pay.add(BaseApplication.sp.getString("OrderPay3", "0"));
        pay.add(BaseApplication.sp.getString("OrderPay4", "0"));
        return pay;
    }
}
