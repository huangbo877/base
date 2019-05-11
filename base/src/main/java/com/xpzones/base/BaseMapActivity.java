//package com.xpzones.base;
//
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//
//import com.baidu.location.BDAbstractLocationListener;
//import com.baidu.location.BDLocation;
//import com.baidu.location.LocationClient;
//import com.baidu.location.LocationClientOption;
//import com.baidu.mapapi.model.LatLng;
//import com.baidu.mapapi.search.core.SearchResult;
//import com.baidu.mapapi.search.geocode.GeoCodeResult;
//import com.baidu.mapapi.search.geocode.GeoCoder;
//import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
//import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
//import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
//import com.xpzones.utils.InfoUtil;
//import com.xpzones.utils.LogUtil;
//import com.xpzones.utils.StringUtils;
//import com.xpzones.utils.ToastUtils;
//
//public abstract class BaseMapActivity extends PermissionActivity {
//
//    GeoCoder mSearch;
//    LocationClient locationClient;
//
//    @Override
//    protected void PermissionOK() {
//        super.PermissionOK();
//        initLocationOption();
//    }
//
//    /**
//     * 初始化定位参数配置
//     */
//
//    private void initLocationOption() {
//        //定位服务的客户端。宿主程序在客户端声明此类，并调用，目前只支持在主线程中启动
//        locationClient = new LocationClient(getApplicationContext());
//        //声明LocationClient类实例并配置定位参数
//        LocationClientOption locationOption = new LocationClientOption();
//        MyLocationListener myLocationListener = new MyLocationListener();
//        //注册监听函数
//        locationClient.registerLocationListener(myLocationListener);
//        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
//        locationOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
//        //可选，默认gcj02，设置返回的定位结果坐标系，如果配合百度地图使用，建议设置为bd09ll;
//        locationOption.setCoorType("bd09ll");
//        //可选，默认0，即仅定位一次，设置发起连续定位请求的间隔需要大于等于1000ms才是有效的
//        locationOption.setScanSpan(0);
//        //可选，设置是否需要地址信息，默认不需要
//        locationOption.setIsNeedAddress(true);
//        //可选，设置是否需要地址描述
//        locationOption.setIsNeedLocationDescribe(true);
//        //可选，设置是否需要设备方向结果
//        locationOption.setNeedDeviceDirect(false);
//        //可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
//        locationOption.setLocationNotify(true);
//        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
//        locationOption.setIgnoreKillProcess(true);
//        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
//        locationOption.setIsNeedLocationDescribe(true);
//        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
//        locationOption.setIsNeedLocationPoiList(true);
//        //可选，默认false，设置是否收集CRASH信息，默认收集
//        locationOption.SetIgnoreCacheException(false);
//        //可选，默认false，设置是否开启Gps定位
//        locationOption.setOpenGps(true);
//        //可选，默认false，设置定位时是否需要海拔信息，默认不需要，除基础定位版本都可用
//        locationOption.setIsNeedAltitude(false);
//        //设置打开自动回调位置模式，该开关打开后，期间只要定位SDK检测到位置变化就会主动回调给开发者，该模式下开发者无需再关心定位间隔是多少，定位SDK本身发现位置变化就会及时回调给开发者
//        locationOption.setOpenAutoNotifyMode();
//        //设置打开自动回调位置模式，该开关打开后，期间只要定位SDK检测到位置变化就会主动回调给开发者
//        locationOption.setOpenAutoNotifyMode(3000, 1, LocationClientOption.LOC_SENSITIVITY_HIGHT);
//        //开始定位
//        locationClient.start();
//    }
//
//    /**
//     * 实现定位回调
//     */
//    public class MyLocationListener extends BDAbstractLocationListener {
//        @Override
//        public void onReceiveLocation(BDLocation location) {
//            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
//            //以下只列举部分获取经纬度相关（常用）的结果信息
//            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明
//
//            //获取纬度信息
//            double latitude = location.getLatitude();
//            //获取经度信息
//            double longitude = location.getLongitude();
//            //获取定位精度，默认值为0.0f
//            float radius = location.getRadius();
//            //获取经纬度坐标类型，以LocationClientOption中设置过的坐标类型为准
//            String coorType = location.getCoorType();
//            //获取定位类型、定位错误返回码，具体信息可参照类参考中BDLocation类中的说明
//            int errorCode = location.getLocType();
//            if (errorCode == 61 || errorCode == 66 || errorCode == 161) {
//                LogUtil.Log("Map:" + latitude + "-" + longitude + "-" + location.getAdCode());
//                LocationOK(location);
//            } else {
//                ErrorDialog();
//            }
//        }
//    }
//
//    private void ErrorDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//        builder.setTitle("提示");
//        builder.setMessage("获取位置信息失败，请检查设置后重试");
//        builder.setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                finish();
//            }
//        });
//        builder.show();
//    }
//
//    protected void LocationOK(BDLocation location) {
//        InfoUtil.setCity(location.getCity());
//        InfoUtil.setlocLongitude(location.getLongitude() + "");
//        InfoUtil.setlocLatitude(location.getLatitude() + "");
//        mSearch = GeoCoder.newInstance();
//        mSearch.setOnGetGeoCodeResultListener(listener);
//        LatLng latlng = new LatLng(location.getLatitude(), location.getLongitude());
//        mSearch.reverseGeoCode(new ReverseGeoCodeOption()
//                .location(latlng));
//    }
//
//    OnGetGeoCoderResultListener listener = new OnGetGeoCoderResultListener() {
//
//        public void onGetGeoCodeResult(GeoCodeResult result) {
//
//            if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
//                //没有检索到结果
//                ErrorDialog();
//            }
//
//            //获取地理编码结果
//        }
//
//        @Override
//
//        public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result) {
//
//            if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
//                //没有找到检索结果
//                LogUtil.Log(result.error+"");
//                ErrorDialog();
//            } else {
//                ReverseResult(result);
//            }
//
//            //获取反向地理编码结果
//        }
//    };
//
//    protected void ReverseResult(ReverseGeoCodeResult result) {
//        InfoUtil.setAddx(result.getAdcode()+"");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (locationClient != null) {
//            locationClient.stop();
//        }
//        if (mSearch != null) {
//            mSearch.destroy();
//        }
//
//    }
//}
