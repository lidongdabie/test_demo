package Evcard_Mas;


import com.asserts.Evcard_Ids_Assert;
import com.builder.dispatchData;
import com.builder.newTaskQueryData;
import com.builder.queryMyTaskData;
import com.builder.queryMyTaskResultData;
import com.datadriver.AutoDataDriverBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Administrator on 2016/7/12.
 */
public class Evcard_Ids_testcase extends AutoDataDriverBase {

    private String Token = "";
    private String dispatchTaskSeq = "";
    private queryMyTaskResultData.DataBean.PageBean.ListBean listBean;
    private String workOrderSeq;
    private String AppToken;
    private int dispatchTaskId;
    private int dispatchOrderId;
    Evcard_Ids_Assert evcard_ids_assert = new Evcard_Ids_Assert();

    /**
     * 单点登陆获取token
     *
     * @throws Exception
     */
    @BeforeTest()
    public String getToken() throws Exception {
        Token = evcard_ids_assert.assertverifySSOlogin();
        return Token;
    }

//    @AfterMethod
//    public void resetcarinfo() {
//    }

    /**
     * 客服创建调度任务
     *
     * @throws IOException
     */
    @Test(enabled = false, description = "客服创建调度任务")
    public void testAddNewTask() throws IOException {
        newTaskQueryData addnewTask = newTaskQueryData.builder().createType(3).type(12)
                .orderSeq("14001140171025403076").authId("C2019082007380000011").build();
        String dispatchTaskSeq = evcard_ids_assert.assertAddNewTask(addnewTask, Token);//返回任务编号
        System.out.println(dispatchTaskSeq);
    }

    /**
     * 创建无法还车任务
     *
     * @return
     * @throws IOException
     */
    @Test(enabled = true, description = "创建无法还车任务", priority = 1)
    public String testCreateNewTask() throws IOException {
        dispatchTaskSeq = evcard_ids_assert.assertCreateNewTask();//返回任务编号
        System.out.println(dispatchTaskSeq);
        return dispatchTaskSeq;
    }

    //提供切换查询角色的参数
    @DataProvider(name = "testidsChangRole")
    public Object[][] createData6() {
        return new Object[][]{
                {"区域", Token},
        };
    }

    /**
     * 切换查询角色
     *
     * @throws IOException
     */
    @Test(enabled = true, description = "切换查询角色", dataProvider = "testidsChangRole", priority = 2)
    public void testidsChangRole(String role, String token) throws IOException {
        evcard_ids_assert.assertChangeRole(role, token);
    }

    //提供查询的参数
    @DataProvider(name = "testCreateNewTask")
    public Object[][] createData3() {
        return new Object[][]{
                {dispatchTaskSeq, Token},
        };
    }

    /**
     * 根据任务编号查询
     *
     * @throws IOException
     */
    @Test(enabled = true, description = "根据任务编号查询", dataProvider = "testCreateNewTask", priority = 3)
    public queryMyTaskResultData.DataBean.PageBean.ListBean testQueryMyTask(String dispatchTaskSeq, String Token) throws IOException {
//        String dispatchTaskSeq = "WFHC201908210002";
        queryMyTaskData queryMyTaskData = com.builder.queryMyTaskData.builder().minCreateTime("2019-08-20 15:36:50").
                maxCreateTime("2019-12-18 15:36:50").externalTask(false).delayTask(false).dispatchTaskSeq(dispatchTaskSeq)
                .authority(1).pageSize(20).pageNum(1).queryLastPage(false).queryTotal(false).build();
        listBean = evcard_ids_assert.assertQueryMyTask(queryMyTaskData, Token);
        return listBean;
    }


    /**
     * 调度任务指派区域
     *
     * @throws IOException
     */
    @Test(enabled = false, description = "调度任务指派区域")
    public void testIdsAssignTask(queryMyTaskResultData.DataBean.PageBean.ListBean listBean, String token) throws IOException {
        dispatchData.TaskDetailBean TaskDetailBean = dispatchData.TaskDetailBean.builder().regionId(320586).build();
        dispatchData dispatchdata = dispatchData.builder().procInstId(listBean.getProcInstId()).id(listBean.getId()).permissionValue("assign").taskDetail(TaskDetailBean).build();
        evcard_ids_assert.assertidsAssignTaskToErea(dispatchdata, token);
    }

    /**
     * 区域任务上报到调度
     *
     * @throws IOException
     */
    @Test(enabled = false, description = "区域任务上报到调度")
    public void testIdsRejectTask(String procInstId, String token) throws IOException {
//        String procInstId = "15735014";
        dispatchData dispatchdata = dispatchData.builder().procInstId(procInstId).reportReason("自动化测试").permissionValue("reject").build();
        evcard_ids_assert.assertIdsRejectTaskToErea(dispatchdata, token);
    }


    //提供指派的参数
    @DataProvider(name = "testQueryMyTask")
    public Object[][] createData5() {
        return new Object[][]{
                {listBean, Token},
        };
    }

    /**
     * 区域任务指派任务到巡检
     *
     * @throws IOException
     */
    @Test(enabled = true, description = "区域任务指派任务到巡检", dataProvider = "testQueryMyTask", priority = 4)
    public void testIdsRejectTaskToIPQC(queryMyTaskResultData.DataBean.PageBean.ListBean listBean, String token) throws IOException {
//        int id = 20323;
//        String procInstId = "15735014";
        dispatchData.TaskDetailBean TaskDetailBean = dispatchData.TaskDetailBean.builder()
                .regionId(320586).authId("12111121999134052250").build();//车城区域和巡检的authid(对应巡检账号12111121999@sh)
        dispatchData dispatchdata = dispatchData.builder()
                .procInstId(listBean.getProcInstId()).id(listBean.getId())
                .permissionValue("assign").taskDetail(TaskDetailBean).build();
        evcard_ids_assert.assertIdsRejectTaskToIPQC(dispatchdata, token);
    }

    /**
     * 调度查询当前任务的EVWORK子任务
     *
     * @param taskSeq
     * @param token
     * @return
     * @throws IOException
     */
    @Test(enabled = true, description = "调度查询当前任务的EVWORK子任务", dataProvider = "testCreateNewTask", priority = 5)
    public String testIdsQueryWorkOrderTask(String taskSeq, String token) throws IOException {
        workOrderSeq = evcard_ids_assert.assertidsQueryWorkOrderTask(taskSeq, token);
        return workOrderSeq;
    }

    /**
     * 任务流传
     *
     * @throws Exception
     */
    @Test(enabled = false, description = "任务流传")
    public void testEditTask() throws Exception {
        evcard_ids_assert.assertEditTask(Token);
    }

    //EVWORK登录信息
    @DataProvider(name = "getEvworkToken")
    public Object[][] createData14() {
        return new Object[][]{
                {"12111121999@sh"},
        };
    }

    /**
     * 获取EVWORK登录token
     *
     * @param "12111121999@sh" 密码默认为Mm123456
     * @throws IOException
     */
    @Test(enabled = true, description = "获取EVWORK登录token", priority = 6, dataProvider = "getEvworkToken")
    public String getEvworkToken(String username) throws IOException {
        AppToken = evcard_ids_assert.assertEvwork_Login(username);
        return AppToken;
    }

    //EVWORK工单列表查询参数传值
    @DataProvider(name = "workOrderSeq")
    public Object[][] createData() {
        return new Object[][]{
                {workOrderSeq, AppToken},
        };
    }

    /**
     * EVWORK工单列表取值
     *
     * @param AppToken
     * @return
     * @throws IOException
     */
    @Test(enabled = true, description = "EVWORK工单列表取值", dataProvider = "workOrderSeq", priority = 7)
    public int testEvwork_getWorkOrderList(String dispatchOrderSeq, String AppToken) throws IOException {
        dispatchOrderId = evcard_ids_assert.assertgetWorkOrderList(dispatchOrderSeq, AppToken);
        return dispatchOrderId;
    }

    @DataProvider(name = "dispatchOrderId")
    public Object[][] createData8() {
        return new Object[][]{
                {dispatchOrderId, AppToken},
        };
    }

    /**
     * 获取对应工单的详情
     *
     * @param dispatchOrderId
     * @param AppToken
     * @return
     * @throws IOException
     */
    @Test(enabled = true, description = "获取对应工单的详情", dataProvider = "dispatchOrderId", priority = 8)
    public int testEvwork_getOrderDetail(int dispatchOrderId, String AppToken) throws IOException {
        dispatchTaskId = evcard_ids_assert.assertEvwork_getOrderDetail(dispatchOrderId, AppToken);
        return dispatchTaskId;
    }


    /**
     * 巡检任务出发
     *
     * @param dispatchOrderId
     * @param AppToken
     * @throws IOException
     */
    @Test(enabled = true, description = "巡检任务出发", dataProvider = "dispatchOrderId", priority = 9)
    public void testEvwork_DepartOrder(int dispatchOrderId, String AppToken) throws IOException {
        evcard_ids_assert.assertEvwork_DepartOrder(dispatchOrderId, AppToken);
    }

    @DataProvider(name = "testEvwork_StartTask")
    public Object[][] createData9() {
        return new Object[][]{
                {dispatchTaskId, dispatchOrderId, AppToken},
        };
    }


    /**
     * 巡检开始任务
     *
     * @param AppToken
     */
    @Test(enabled = true, description = "巡检开始任务", dataProvider = "testEvwork_StartTask", priority = 10)
    public void testEvwork_StartTask(int dispatchTaskId, int dispatchOrderId, String AppToken) throws IOException {
        evcard_ids_assert.assertEvwork_StartTask(dispatchTaskId, dispatchOrderId, AppToken);
    }

    @DataProvider(name = "testEvwork_UploadTaskInfo")
    public Object[][] createData10() {
        return new Object[][]{
                {dispatchTaskId, AppToken},
        };
    }

    /**
     * 完成信息上报
     *
     * @param dispatchTaskId
     * @param AppToken
     * @throws IOException
     */
    @Test(enabled = true, description = "完成信息上报", dataProvider = "testEvwork_UploadTaskInfo", priority = 11)
    public void testEvwork_UploadTaskInfo(int dispatchTaskId, String AppToken) throws IOException {
        evcard_ids_assert.assertEvwork_UploadTaskInfo(dispatchTaskId, AppToken);
    }

    /**
     * 巡检完成任务
     *
     * @param AppToken
     * @throws IOException
     */
    @Test(enabled = true, description = "巡检完成任务", dataProvider = "testEvwork_UploadTaskInfo", priority = 12)
    public void testEvcard_CompleteTask(int dispatchTaskId, String AppToken) throws IOException {
        evcard_ids_assert.assertEvcard_CompleteTask(dispatchTaskId, AppToken);
    }

    @DataProvider(name = "testIdsCompleteTask")
    public Object[][] createData11() {
        return new Object[][]{
                {listBean.getProcInstId(), Token},
        };
    }

    /**
     * 区域完成无法还车任务
     *
     * @param procInstId
     * @param token
     * @throws IOException
     */
    @Test(enabled = true, description = "区域完成无法还车任务", dataProvider = "testIdsCompleteTask", priority = 13)
    public void testIdsCompleteTask(String procInstId, String token) throws IOException {
        dispatchData dispatchdata = dispatchData.builder()
                .permissionValue("complete")
                .procInstId(procInstId)
                .reportReason("完成后到客服").build();
        evcard_ids_assert.assertidsCompleteTask(dispatchdata, token);
    }

    /**
     * 调度指派客服追偿-停卡(巡检完成后，调度指派至客服)
     *
     * @param procInstId
     * @param token
     * @throws IOException
     */
    @Test(enabled = false, description = "巡检完成后，调度指派至客服", dataProvider = "testIdsCompleteTask")
    public void testIdsAssignToCustomServant(String procInstId, String token) throws IOException {
        dispatchData dispatchdata = dispatchData.builder().procInstId(procInstId).reportReason("自动化测试").permissionValue("assignToCustomServant").build();
        evcard_ids_assert.assertIdsAssignToCustomServant(dispatchdata, token);
    }


    /**
     * 客服处理任务
     * @param procInstId
     * @param token
     * @throws IOException
     */
    @Test(enabled = false, description = "客服处理任务", dataProvider = "testIdsCompleteTask")
    public void testCallcenterProcessesTask(String procInstId, String token) throws IOException {
        dispatchData dispatchdata = dispatchData.builder()
             .procInstId(procInstId).reportReason("测试中").build();
        evcard_ids_assert.assertCallcenterProcessesTask(dispatchdata, token);
    }

    /**
     * 调度风控完成任务
     * @param procInstId
     * @param token
     * @throws IOException
     */
    @Test(enabled = false, description = "调度风控完成任务", dataProvider = "testIdsCompleteTask")
    public void testIdsRiskControltoConfirm(String procInstId, String token) throws IOException {
        dispatchData dispatchdata = dispatchData.builder().procInstId(procInstId).reportReason("自动化测试").permissionValue("complete").build();
        evcard_ids_assert.assertIdsRiskControltoConfirm(dispatchdata,token);
    }
}