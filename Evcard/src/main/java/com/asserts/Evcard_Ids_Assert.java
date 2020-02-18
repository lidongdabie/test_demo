package com.asserts;

import com.builder.dispatchData;
import com.builder.newTaskQueryData;
import com.builder.queryMyTaskData;
import com.builder.queryMyTaskResultData;
import com.jayway.jsonpath.JsonPath;
import com.pages.Evcard_Ids_Page;
import com.pages.Evwork_Ids_Page;

import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Velocity on 2017年-06月29日-15时03分11秒.
 */
public class Evcard_Ids_Assert {

    Evcard_Ids_Page evcard_mas_page = new Evcard_Ids_Page();
    Evwork_Ids_Page evwork_Ids_Page = new Evwork_Ids_Page();


    public String assertverifySSOlogin() throws Exception {
        String token = evcard_mas_page.SSOlogin();
        return token;
    }

    public String assertEditTask(String token) throws Exception {
        String result = evcard_mas_page.addEditTask(token);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\",\"message\":\"编辑任务信息成功\""));
        return result;
    }

    public String assertAddNewTask(newTaskQueryData addnewTask, String token) throws IOException {
        String result = evcard_mas_page.addNewTask(addnewTask, token);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"success\":true"));
        String msg = result.split(",")[0].split(":")[1].substring(3, 19);
        return msg;
    }

    public String assertCreateNewTask() throws IOException {
        String result = evcard_mas_page.createNewTask();
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\""));
        String msg = JsonPath.read(result, "$.message");
        return msg;
    }

    public queryMyTaskResultData.DataBean.PageBean.ListBean assertQueryMyTask(queryMyTaskData queryMyTaskData, String token) throws IOException {
        String result = evcard_mas_page.idsQueryMyTask(queryMyTaskData, token);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\""));
        int id = JsonPath.read(result, "$.data.list[0].id");
        String procInstId = JsonPath.read(result, "$.data.list[0].procInstId");
        String activitiProcinstId = JsonPath.read(result, "$.data.list[0].activitiProcinstId");
        queryMyTaskResultData.DataBean.PageBean.ListBean ListBean = queryMyTaskResultData.DataBean.PageBean.ListBean.builder()
                .id(id)
                .procInstId(procInstId).activitiProcinstId(activitiProcinstId).build();
        return ListBean;
    }

    public String assertidsQueryWorkOrderTask(String taskSeq, String token) throws IOException {
        String result = evcard_mas_page.idsQueryWorkOrderTask(taskSeq, token);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\""));
        String workOrderSeq = JsonPath.read(result, "$.data.list[0].workOrderSeq");
        return workOrderSeq;
    }

    public void assertidsAssignTaskToErea(dispatchData dispatchdata, String token) throws IOException {
        String result = evcard_mas_page.idsAssignTaskToErea(dispatchdata, token);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\",\"message\":\"指派成功\""));
    }

    public void assertIdsRejectTaskToErea(dispatchData dispatchdata, String token) throws IOException {
        String result = evcard_mas_page.idsRejectTaskToErea(dispatchdata, token);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\",\"message\":\"上报成功\""));
    }

    public void assertChangeRole(String role, String token) throws IOException {
        String result = evcard_mas_page.idsChangeRole(role, token);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\""));
    }

    public void assertIdsRejectTaskToIPQC(dispatchData dispatchdata, String token) throws IOException {
        String result = evcard_mas_page.idsRejectTaskToIPQC(dispatchdata, token);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\",\"message\":\"指派成功\""));
    }

    public void assertidsCompleteTask(dispatchData dispatchdata, String token) throws IOException {
        String result = evcard_mas_page.idsCompleteTask(dispatchdata, token);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\""));
    }

    public String assertEvwork_Login(String username) throws IOException {
        String result = evwork_Ids_Page.Evwork_Login(username);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\""));
        String AppToken = JsonPath.read(result, "$.data.token");
        return AppToken;
    }

    public Integer assertgetWorkOrderList(String dispatchOrderSeq, String AppToken) throws IOException {
        String result = evwork_Ids_Page.getWorkOrderList(AppToken);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\""));
        int problemTypeId = 12;
        String jsonpath = "$.data[?(@.problemTypeId==" + problemTypeId + "&&@.dispatchOrderSeq=='" + dispatchOrderSeq + "')].dispatchOrderId";
        List<Integer> dispatchOrderIdlist = JsonPath.read(result, jsonpath);
        return dispatchOrderIdlist.get(0);
    }

    public int assertEvwork_getOrderDetail(int dispatchOrderId, String AppToken) throws IOException {
        String result = evwork_Ids_Page.Evwork_getOrderDetail(dispatchOrderId, AppToken);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\""));
        int dispatchTaskId = JsonPath.read(result, "$.data.dispatchTaskId");
        return dispatchTaskId;
    }

    public void assertEvwork_DepartOrder(int dispatchOrderId, String AppToken) throws IOException {
        String result = evwork_Ids_Page.Evwork_DepartOrder(dispatchOrderId, AppToken);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\""));
    }

    public void assertEvwork_StartTask(int dispatchTaskId, int dispatchOrderId, String AppToken) throws IOException {
        String result = evwork_Ids_Page.Evwork_StartTask(dispatchTaskId, dispatchOrderId, AppToken);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\""));
    }

    public void assertEvcard_CompleteTask(int dispatchTaskId, String AppToken) throws IOException {
        String result = evwork_Ids_Page.Evcard_CompleteTask(dispatchTaskId, AppToken);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\""));
    }

    public void assertEvwork_UploadTaskInfo(int dispatchTaskId, String AppToken) throws IOException {
        String result = evwork_Ids_Page.evwork_UploadTaskInfo(dispatchTaskId, AppToken);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\""));
        System.out.println(result);
    }

    public void assertEvwork_UploadTaskInfo_old(int dispatchTaskId, String AppToken) throws IOException {
        String result = evcard_mas_page.evwork_UploadTaskInfo(dispatchTaskId, AppToken);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\""));
    }

    public void assertCallcenterProcessesTask(dispatchData dispatchdata, String token) throws IOException {
        String result = evcard_mas_page.callcenterProcessesTask(dispatchdata, token);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"success\":true"));
    }

    public void assertIdsAssignToCustomServant(dispatchData dispatchdata, String token) throws IOException {
        String result = evcard_mas_page.idsAssignToCustomServant(dispatchdata, token);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\""));
    }

    public void assertIdsRiskControltoConfirm(dispatchData dispatchdata, String token) throws IOException {
        String result = evcard_mas_page.idsRiskControltoConfirm(dispatchdata, token);
        assertTrue("返回码错误，实际为返回的值是" + result, result.contains("\"code\":\"0\""));
    }
}