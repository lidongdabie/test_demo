package Evcard_Mas;

import com.builder.queryMyTaskResultData;
import org.testng.annotations.Test;

/**
 * @Auther: DELL
 * @Date: 2019/8/20 09:35
 * @Description:
 */
public class idsTestSuit {

    /**
     * 无法还车 (problemTypeId-12)
     *
     * @throws Exception
     */
    @Test(enabled = true, description = "无法还车 (problemTypeId-12)")
    public void UnableToCarSuit() throws Exception {
        Evcard_Ids_testcase evcard_ids_testcase = new Evcard_Ids_testcase();
        String token = evcard_ids_testcase.getToken();//获取登录token
        String dispatchTaskSeq = evcard_ids_testcase.testCreateNewTask();//创建无法还车任务
//        String dispatchTaskSeq = "WFHC201908210036";
        evcard_ids_testcase.testidsChangRole("区域", token);//切换区域查询角色
        //根据任务编号查询任务id以及procInstId
        queryMyTaskResultData.DataBean.PageBean.ListBean listBean = evcard_ids_testcase.testQueryMyTask(dispatchTaskSeq, token);
        evcard_ids_testcase.testIdsRejectTask(listBean.getProcInstId(), token);//上报至调度任务
        evcard_ids_testcase.testidsChangRole("调度", token);//切换区域查询角色
        evcard_ids_testcase.testIdsAssignTask(listBean, token);//调度指派任务至区域
        evcard_ids_testcase.testidsChangRole("区域", token);//切换区域查询角色
        evcard_ids_testcase.testIdsRejectTaskToIPQC(listBean, token);//区域指派任务至巡检
        String workOrderSeq = evcard_ids_testcase.testIdsQueryWorkOrderTask(dispatchTaskSeq, token);
        String AppToken = evcard_ids_testcase.getEvworkToken("12111121999@sh");//获取EVWORK登录token
        int dispatchOrderId = evcard_ids_testcase.testEvwork_getWorkOrderList(workOrderSeq, AppToken);
        int dispatchTaskId = evcard_ids_testcase.testEvwork_getOrderDetail(dispatchOrderId, AppToken);
        evcard_ids_testcase.testEvwork_DepartOrder(dispatchOrderId, AppToken); //巡检出发
        evcard_ids_testcase.testEvwork_StartTask(dispatchTaskId, dispatchOrderId, AppToken);//巡检开始任务
        evcard_ids_testcase.testEvwork_UploadTaskInfo(dispatchTaskId, AppToken);//巡检信息上报
        evcard_ids_testcase.testEvcard_CompleteTask(listBean.getId(), AppToken);//巡检完成任务
        String token1 = evcard_ids_testcase.getToken();//获取登录token
//        evcard_ids_testcase.testIdsCompleteTask(listBean.getProcInstId(),token1);//调度系统完成无法还车任务
        evcard_ids_testcase.testIdsAssignToCustomServant(listBean.getProcInstId(), token1);//区域指派无法还车任务至客服
        evcard_ids_testcase.testCallcenterProcessesTask(listBean.getProcInstId(), token1);//客服完成任务，任务指向调度风控
        evcard_ids_testcase.testidsChangRole("风控", token1);//切换区域查询角色
        evcard_ids_testcase.testIdsRiskControltoConfirm(listBean.getProcInstId(), token1);//调度风控完成无法还车任务
    }


}
