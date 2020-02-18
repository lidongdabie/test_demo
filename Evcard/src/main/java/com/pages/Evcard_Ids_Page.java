package com.pages;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth.EvcardAuthority;
import com.builder.*;
import com.http.HttpClient;
import com.tools.UTF8;

import java.io.IOException;


/**
 * Created by Velocity on 2017年-06月29日-15时03分11秒.
 */
public class Evcard_Ids_Page extends EvcardAuthority {

    public String baseURL;

    public Evcard_Ids_Page() {
        baseURL = super.getBaseUrl();
    }

    /**
     * 单点登录接口
     *
     * @return
     * @throws Exception
     */
    public String SSOlogin() throws Exception {
        HttpClient.toString(HttpClient.get(this.baseURL + "evcard-sso/api/loginAjax?" +
                "username=extracme@hq&password=79409c046934219ce6394df684b06f85&code=123456", null));
        String token = HttpClient.printCookies("token");
        return token;
    }

    /**
     * 客服系统新增车辆检查任务
     *
     * @param token
     * @return
     * @throws IOException
     */
    public String addNewTask(newTaskQueryData addnewTask, String token) throws IOException {
        String s = this.baseURL + "evcard-callcenter/callcenter/dispatch-task!createTask.sy?createType="+addnewTask.getCreateType()+"" +
                "&type="+addnewTask.getType()+"&authId="+addnewTask.getAuthId()+"&orderSeq="+addnewTask.getOrderSeq()+"";
        String parm = String.format("inner.problemTypeId=7&inner.problemThirdLevelTypeId=155&inner.problemSubTypeId=104&inner.provinceId=110000&inner.cityId=110100&inner.areaId=110108&inner.pickupShopName=花桥管委办&inner.returnShopName=百度大厦12&inner.vehicleNo=沪GM0678&inner.name=蝴蝶瓦&inner.userPhone=12111101411&inner.orderSeq=C2019041115460000012&inner.priority=0&inner.content=55555555555&inner.groupId=0&inner.provinceName=北京市&inner.cityName=北京市&inner.areaName=海淀区&inner.taskStatus=2&data.userName=蝴蝶瓦&data.userPhone=12111101411&data.priority=0&data.isSetFaultCar=1&detail.IS_NEED_CUSTOM=0&data.vehicleDtcRemark=测试流程&data.remark=测试水水水水水&data.provinceName=北京市&data.cityName=北京市&data.areaName=海淀区&data.provinceId=110000&data.cityId=110100&data.areaId=110108&data.vin=SGMSGMSGMSGMG0678&data.vehicleNo=沪GM0678&detail.ORDER_RUN_TIME=7860&detail.noDeductiblesFlag=1");
        String result = HttpClient.toString(HttpClient.post(s, parm, token));
        return result;
    }

    /**
     * 创建任务（客服）
     *
     * @return
     * @throws IOException
     */
    public String createNewTask() throws IOException {
        String s = "http://csms-app-st.evcard.vip:180/evcard-ids/inner/callcenter/create-task";
        String parm = String.format("{\"areaId\":310114,\"areaName\":\"嘉定区\",\"authId\":\"350526197805232849\",\"cityId\":310100,\"cityName\":\"上海市\",\"createOperId\":259,\"createOperName\":\"姜杏环球\",\"hasRelatedSubTask\":false,\"inspectorCreate\":false,\"orderSeq\":\"C2019080916270000041\",\"place\":\"嘉定安亭镇\",\"priority\":0,\"problemTypeId\":12,\"processRole\":\"customServant\",\"processRoleName\":\"客服\",\"processUserName\":\"姜杏环球\",\"provinceId\":310000,\"provinceName\":\"上海市\",\"realUserName\":\"姜测试\",\"remark\":\"测试及任务\",\"shopName\":\"安驰路绿地\",\"shopSeq\":1516,\"taskDetail\":{\"IS_IN_SPECIFIED_SHOP\":\"1\",\"IS_VEHICLE_ABNORMAL\":\"1\",\"noDeductiblesFlag\":\"0\",\"ORDER_RUN_TIME\":\"329150\",\"IS_NEED_ALLOCATION\":\"1\",\"VEHICLE_TERMINAL_ID\":\"DE260042\"},\"taskLocation\":\"上海市上海市嘉定区嘉定安亭镇\",\"userName\":\"姜测试\",\"userPhone\":\"15039291618\",\"userRole\":\"customServant\",\"vehicleModelInfo\":\"荣威E50\",\"vehicleModelSeq\":2,\"vehicleNo\":\"沪AD54321\",\"vin\":\"B2BCESHI018\"}");
        String result = HttpClient.toString(HttpClient.postJson(s, parm,""));
        return result;
    }
    /**
     * 更换调度查询权限
     *
     * @param role
     * @return
     * @throws IOException
     */
    public String idsChangeRole(String role, String token) throws IOException {
        String role1 = UTF8.Utf8URLencode(role);
        String result = HttpClient.toString(HttpClient.get(this.baseURL +
                "evcard-ids/api/bussiness/setRoleName?roleName=" + role1 + "", token));
        return result;
    }

    /**
     * 调度任务处理列表查询接口
     *
     * @param queryMyTaskData
     * @param token
     * @return
     * @throws IOException
     */
    public String idsQueryMyTask(queryMyTaskData queryMyTaskData, String token) throws IOException {
        String s = this.baseURL + "evcard-ids/api/inquery/my-tasks";
        String parm = JSON.toJSONString(queryMyTaskData);
        String result = HttpClient.toString(HttpClient.postJson(s,parm,token));
        return result;
    }


    /**
     * 查询当前任务EVWORK任务编号
     *
     * @param taskSeq
     * @param token
     * @return
     * @throws IOException
     */
    public String idsQueryWorkOrderTask(String taskSeq,String token) throws IOException {
        String s = this.baseURL + "evcard-ids/api/work-order/query";
        String parm = "{\"taskSeq\":\""+taskSeq+"\",\"pageSize\":1000,\"workOrderStatus\":\"-1\",\"isCheckOrg\":false,\"pageNum\":1}";
        String result = HttpClient.toString(HttpClient.postJson(s,parm,token));
        return result;
    }

    /**
     * （无法还车）调度任务指派区域接口
     * @param token
     * @return
     * @throws IOException
     */
    public String idsAssignTaskToErea(dispatchData dispatchdata,String token) throws IOException {
        String s = this.baseURL + "evcard-ids/api/bussiness/complete";
        String parm = JSONObject.toJSONString(dispatchdata);
        String result = HttpClient.toString(HttpClient.postJson(s,parm,token));
        return result;
    }

    /**
     * （无法还车）调度上报任务接口
     * @param token
     * @return
     * @throws IOException
     */
    public String idsRejectTaskToCallcenter(String token) throws IOException {
        String s = this.baseURL + "evcard-ids/api/bussiness/complete";
        dispatchData dispatchdata = dispatchData.builder().procInstId("15670053").reportReason("自动化测试").permissionValue("reject").build();
        String parm = JSONObject.toJSONString(dispatchdata);
        String result = HttpClient.toString(HttpClient.postJson(s,parm,token));
        return result;
    }


    /**
     * （无法还车）区域上报任务接口
     * @param token
     * @return
     * @throws IOException
     */
    public String idsRejectTaskToErea(dispatchData dispatchdata,String token) throws IOException {
        String s = this.baseURL + "evcard-ids/api/bussiness/complete";
        String parm = JSONObject.toJSONString(dispatchdata);
        String result = HttpClient.toString(HttpClient.postJson(s,parm,token));
        return result;
    }

    /**
     * （无法还车）区域指派巡检
     * @param token
     * @return
     * @throws IOException
     */
    public String idsRejectTaskToIPQC( dispatchData dispatchdata,String token) throws IOException {
        String s = this.baseURL + "evcard-ids/api/bussiness/complete";
        String parm = JSONObject.toJSONString(dispatchdata);
        String result = HttpClient.toString(HttpClient.postJson(s,parm,token));
        return result;
    }


    /**
     * （无法还车）区域完成
     * @param token
     * @return
     * @throws IOException
     */
    public String idsCompleteTask(dispatchData dispatchdata,String token) throws IOException {
        String s = this.baseURL + "evcard-ids/api/bussiness/complete";
        String parm = JSONObject.toJSONString(dispatchdata);
        String result = HttpClient.toString(HttpClient.postJson(s,parm,token));
        return result;
    }


    /**
     * 车辆检查任务指派接口
     * @param token
     * @return
     * @throws IOException
     */
    public String idsDispatchHandle(String token) throws IOException {
        String s = this.baseURL + "evcard-ids/api/task/dispatchHandle";
        String parm = String.format("{\n" +
                "    \"id\": ,\n" +
                "    \"procInstId\": \"{{procInstId}}\",\n" +
                "    \"permissionValue\": \"assign\",\n" +
                "    \"taskDetail\": {\n" +
                "        \"regionId\": 320586}\n" +
                "    }\n" +
                "}");
        String result = HttpClient.toString(HttpClient.postJson(s,parm,token));
        return result;
    }

    /**
     * 调度任务流转接口
     *
     * @param token
     * @return
     * @throws Exception
     */
    public String addEditTask(String token) throws Exception {
        String s = this.baseURL + "evcard-ids/api/bussiness/edit";
        addEditTask editnewtask = addEditTask.builder().id("20096").orgId("000T").taskOrgId("000T").build();
        String parm = JSONObject.toJSONString(editnewtask);
        String result = HttpClient.toString(HttpClient.postJson(s, parm, token));
        return result;
    }

    /**
     *evwork异常上报—异常信息上传
     *
     * @param token
     * @return
     * @throws IOException
     */
    public String evwork_UploadTaskInfo(int dispatchTaskId,String token) throws IOException {
        String s = "http://csms-app-st.evcard.vip:180/evcard-ids/app/evwork/upload-task-info";
        evworkUploadTaskInfo.BaseMap baseMap = evworkUploadTaskInfo.BaseMap.builder().IS_ILLEGAL("0").build();
        evworkUploadTaskInfo.ContentMapBean contentMapBean = evworkUploadTaskInfo.ContentMapBean.builder().IS_ILLEGAL("0")
                .DEAL_RESULT("测试测试测试1111").PIC_URL("patrolTask//522400197404118556/1566397860073_add_11.png").build();
        evworkUploadTaskInfo evworkuploadtaskinfo = evworkUploadTaskInfo.builder().dispatchTaskId(dispatchTaskId)
                .contentMap(contentMapBean).baseMap(baseMap).token(token).build();
        String parm = JSONObject.toJSONString(evworkuploadtaskinfo);
        String result = HttpClient.toString(HttpClient.postJson(s, parm, token));
        return result;
    }

    /**
     *evwork异常上报—上报
     *
     * @param token
     * @return
     * @throws IOException
     */
    public String evwork_ExceptionReport(String token) throws IOException {
        String s = "http://csms-app-st.evcard.vip:180/evcard-ids/app/evwork/exception-report";
        String parm = String.format("{\"dispatchTaskId\":20217,\"latitude\":\"31.287823\",\"longitude\":\"121.17166\",\"problemTypeId\":12,\"token\":"+token+"}");
        String result = HttpClient.toString(HttpClient.postJson(s, parm, token));
        return result;
    }


    /**
     * 客服处理任务
     * @param dispatchdata
     * @param token
     * @return
     * @throws IOException
     */
    public String callcenterProcessesTask(dispatchData dispatchdata,String token) throws IOException {
        String text = UTF8.Utf8URLencode(dispatchdata.getReportReason());
        String s = this.baseURL + "evcard-callcenter/callcenter/dispatch-task!disposeTask.sy?" +
                "procInstId="+dispatchdata.getProcInstId()+"&reason="+text+"";
        String result = HttpClient.toString(HttpClient.postJson(s,"",token));
        return result;
    }

    /**
     * 客服取消任务
     */
    public void  callcenterCancelTask(){
        String s = this.baseURL + "evcard-callcenter/callcenter/dispatch-task!disableTask.sy?procInstId=15405073";

    }


    /**
     * 调度指派客服追偿-停卡(巡检完成后，调度指派至客服)
     *
     * @param token
     * @return
     * @throws IOException
     */
    public String idsAssignToCustomServant(dispatchData dispatchdata,String token) throws IOException {
        String s = this.baseURL + "evcard-ids/api/bussiness/complete";
        String parm = JSONObject.toJSONString(dispatchdata);
        String result = HttpClient.toString(HttpClient.postJson(s,parm,token));
        return result;
    }

    /**
     * 风控确认
     *
     * @param token
     * @return
     * @throws IOException
     */
    public String idsRiskControltoConfirm(dispatchData dispatchdata,String token) throws IOException {
        String s = this.baseURL + "evcard-ids/api/bussiness/complete";
        String parm = JSONObject.toJSONString(dispatchdata);
        String result = HttpClient.toString(HttpClient.postJson(s,parm,token));
        return result;
    }
}
