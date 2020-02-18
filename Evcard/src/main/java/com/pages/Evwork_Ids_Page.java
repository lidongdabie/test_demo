package com.pages;

import com.alibaba.fastjson.JSONObject;
import com.auth.EvcardAuthority;
import com.builder.evworkUploadTaskInfo;
import com.http.HttpClient;

import java.io.IOException;

/**
 * @Auther: DELL
 * @Date: 2019/8/20 17:16
 * @Description:
 */
public class Evwork_Ids_Page extends EvcardAuthority {
    public String baseUrl_evwork;

    public Evwork_Ids_Page() {

        baseUrl_evwork = super.getBaseUrl_Evwork();
    }

    /**
     * EVwork登录接口
     *
     * @return
     * @throws IOException
     */
    public String Evwork_Login(String username) throws IOException {
        String s = this.baseUrl_evwork + "evcard-sso/app/mobileLogin?" +
                "username="+username+"&password=79409c046934219ce6394df684b06f85&code=&imei=866438033559720";
        String result = HttpClient.toString(HttpClient.get(s, ""));
        return result;
    }

    /**
     * 当前EVWORK工单list
     *
     * @param AppToken
     * @return
     * @throws IOException
     */
    public String getWorkOrderList(String AppToken) throws IOException {
        String s = this.baseUrl_evwork + "evcard-ids/app/evwork/task/getWorkOrderList";
        String result = HttpClient.toString(HttpClient.postJson(s, "", AppToken));
        return result;
    }

    /**
     * EVwork查询任务详情
     *
     * @param dispatchOrderId 工单编号
     * @param AppToken
     * @return
     * @throws IOException
     */
    public String Evwork_getOrderDetail(int dispatchOrderId, String AppToken) throws IOException {
        String s = this.baseUrl_evwork + "evcard-ids/app/evwork/task/getOrderDetail";
        String parm = String.format("{\"dispatchOrderId\":" + dispatchOrderId + "}");
        String result = HttpClient.toString(HttpClient.postJson(s, parm, AppToken));
        return result;
    }

    /**
     * EVwork--巡检--出发
     *
     * @param AppToken
     * @return
     * @throws IOException
     */
    public String Evwork_DepartOrder(int dispatchOrderId, String AppToken) throws IOException {
        String s = this.baseUrl_evwork + "evcard-ids/app/evwork/work/order/departOrder";
        String parm = String.format("{\"dispatchOrderId\":" + dispatchOrderId + ",\"latitude\":\"31.287736\",\"longitude\":\"121.171667\"}");
        String result = HttpClient.toString(HttpClient.postJson(s, parm, AppToken));
        return result;
    }

    /**
     * EVwork--巡检-开始任务
     *
     * @param AppToken
     * @return
     * @throws IOException
     */
    public String Evwork_StartTask(int dispatchTaskId, int dispatchOrderId, String AppToken) throws IOException {
        String s = this.baseUrl_evwork + "evcard-ids/app/evwork/work/order/startOrder";
        String parm = String.format("{\"dispatchTaskId\":" + dispatchTaskId + ",\"latitude\":\"31.274899\",\"longitude\":\"121.179784\",\"problemTypeId\":12,\"dispatchOrderId\":" + dispatchOrderId + "}");
        String result = HttpClient.toString(HttpClient.postJson(s, parm, AppToken));
        return result;
    }

    /**
     * evwork异常上报—异常信息上传
     *
     * @param AppToken
     * @return
     * @throws IOException
     */
    public String evwork_UploadTaskInfo(int dispatchTaskId, String AppToken) throws IOException {
        String s = this.baseUrl_evwork + "evcard-ids/app/evwork/task/uploadTaskInfo";
        evworkUploadTaskInfo.ContentMapBean contentMapBean = evworkUploadTaskInfo.ContentMapBean.builder()
                .ILLEGAL_DEAL_RESULT("45588hvv").ILLEGAL_PIC_URL("evwork/orderImg/3_1565749468111_2.png")
                .RESTRICTIVE_ROAD_FEE("2").IS_ILLEGAL("1").NO_RESTRICTIVE_ROAD_FEE("3").PARK_FEE("1")
                .TRAIL_CAR_PIC_URL("evwork/orderImg/2_1565749468111_1.png")
                .DEAL_RESULT("测试测试测试1111")
                .PIC_URL("evwork/orderImg/1_1565686179903_1.png").build();
        evworkUploadTaskInfo evworkuploadtaskinfo = evworkUploadTaskInfo.builder().dispatchTaskId(dispatchTaskId)
                .contentMap(contentMapBean).token(AppToken).build();
        String parm = JSONObject.toJSONString(evworkuploadtaskinfo);
        String result = HttpClient.toString(HttpClient.postJson(s, parm, AppToken));
        return result;
    }

    /**
     * 无法还车完成任务
     *
     * @param AppToken
     * @return
     * @throws IOException
     */
    public String Evcard_CompleteTask(int dispatchTaskId, String AppToken) throws IOException {
//        String s = this.baseUrl_evwork + "evcard-ids/app/evwork/complete-task";
        String s = this.baseUrl_evwork + "evcard-ids/app/evwork/task/completeTask";
        String parm = String.format("{\"dispatchTaskId\":" + dispatchTaskId + ",\"latitude\":\"31.287821\",\"longitude\":\"121.171656\",\"problemTypeId\":12,\"token\":\"" + AppToken + "\"}");
        String result = HttpClient.toString(HttpClient.postJson(s, parm, AppToken));
        return result;
    }


}
