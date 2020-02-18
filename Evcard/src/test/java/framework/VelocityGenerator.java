package framework;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by jin wei on 2016/10/14.
 */
public class VelocityGenerator {
    public static void main(String[] args) {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty("input.encoding", "UTF-8");
        ve.setProperty("output.encoding", "UTF-8");
       /* ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();*/
        Properties p = new Properties();

        p.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, "E:\\move\\Evcard-AutoTest\\Evcard\\src\\test\\java\\resources\\Testcase");

        ve.init(p);
        Template pageTpt = ve.getTemplate("AutoYmmPageTemplate.vm");
        Template assertTpt=ve.getTemplate("AutoYmmAssertTemplate.vm");
        Template testcaseTpt=ve.getTemplate("AutoTestcaseTemplate.vm");
        VelocityContext ctx = new VelocityContext();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒");
        Date date = new Date(System.currentTimeMillis());
        ctx.put("CreateTime",formatter.format(date));
       // String rootPath = VelocityGenerator.class.getClassLoader().getResource("").getFile() + "../../src/main";
        String rootPath="E:\\move\\Evcard-AutoTest\\Evcard\\src\\main\\java\\com";
        //添加Case名,请求地址名
        String[][] TestCaseGroup = {
                {"getOrderList","/evcard-mas/evcardapp?service=getOrderList"},
                {"getVehicleInfoList","/evcard-mas/evcardapp?service=getVehicleInfoList"},
                {"getVehicleRemind","/evcard-mas/evcardapp?service=getVehicleRemind"},
                {"getUserDetailInfo","/evcard-mas/evcardapp?service=getUserDetailInfo"},
                {"getVehicleModeList","/evcard-mas/evcardapp?service=getVehicleModeList"},
                {"queryAccount","/evcard-mas/evcardapp?service=queryAccount"},
                {"getAreaCodeList","/evcard-mas/evcardapp?service=getAreaCodeList"},
                {"queryActivityList","/evcard-mas/evcardapp?service=queryActivityList"},
                {"getTagInfoList","/evcard-mas/evcardapp?service=getTagInfoList"},
                {"getVersion","/evcard-mas/evcardapp?service=getVersion"},
                {"getCityInfo","/evcard-mas/evcardapp?service=getCityInfo"},
                {"getWelcomePagesUrlService","/evcard-mas/evcardapp?service=getWelcomePagesUrlService"},
                {"getToastList","/evcard-mas/evcardapp?service=getToastList"},
                {"queryPreauthorizationList","/evcard-mas/evcardapp?service=queryPreauthorizationList"},
                {"getLastShopList","/evcard-mas/evcardapp?service=getLastShopList"},
                {"queryCouponList","/evcard-mas/evcardapp?service=queryCouponList"},
                {"queryOrderDetail","/evcard-mas/evcardapp?service=queryOrderDetail"},
                {"queryOrderCouponList","/evcard-mas/evcardapp?service=queryOrderCouponList"},
                {"saveInfoAndPicture","/evcard-mas/evcardapp?service=saveInfoAndPicture"},
                {"queryApplyProgress","/evcard-mas/evcardapp?service=queryApplyProgress"},
                {"getVehicleModelByCity","/evcard-mas/evcardapp?service=getVehicleModelByCity"},
                {"uploadOrderPayStatus","/evcard-mas/evcardapp?service=uploadOrderPayStatus"},
                {"getMessageList","/evcard-mas/evcardapp?service=getMessageList"},
                {"cancelOrderCount","/evcard-mas/evcardapp?service=cancelOrderCount"},
                {"getSTSToken","/evcard-mas/evcardapp?service=getSTSToken"},
                {"getShopInfoList","/evcard-mas/evcardapp?service=getShopInfoList"},
                {"getSMSVerifyCode","/evcard-mas/evcardapp?service=getSMSVerifyCode"},
                {"getShareContent","/evcard-mas/evcardapp?service=getShareContent"},
                {"modifyUserInfo","/evcard-mas/evcardapp?service=modifyUserInfo"},
                {"vehicleOnlineRemind","/evcard-mas/evcardapp?service=vehicleOnlineRemind"},
                {"logout","/evcard-mas/evcardapp?service=logout"},
                {"queryEamountList","/evcard-mas/evcardapp?service=queryEamountList"},
                {"findPassword","/evcard-mas/evcardapp?service=findPassword"},
                {"uploadServiceVer","/evcard-mas/evcardapp?service=uploadServiceVer"},
                {"queryOrgCardList","/evcard-mas/evcardapp?service=queryOrgCardList"},
                {"queryChargeHistory","/evcard-mas/evcardapp?service=queryChargeHistory"},
                {"exchangeCoupon","/evcard-mas/evcardapp?service=exchangeCoupon"},
                {"getUserInfo","/evcard-mas/evcardapp?service=getUserInfo"},
                {"modifyPassword","/evcard-mas/evcardapp?service=modifyPassword"},
                {"queryTimeEamountList","/evcard-mas/evcardapp?service=queryTimeEamountList"},
                {"queryRechargeStand","/evcard-mas/evcardapp?service=queryRechargeStand"},
                {"writeFeedBack","/evcard-mas/evcardapp?service=writeFeedBack"},
                {"queryPreauthorization","/evcard-mas/evcardapp?service=queryPreauthorization"},
                {"wowAuthenticat","/evcard-mas/evcardapp?service=wowAuthenticat"},
                {"getShopBaseInfo","/evcard-mas/evcardapp?service=getShopBaseInfo"},
                {"getShopRealInfo","/evcard-mas/evcardapp?service=getShopRealInfo"},
                {"cancleOrderVehicle","/evcard-mas/evcardapp?service=cancleOrderVehicle"},
                {"queryActivity","/evcard-mas/evcardapp?service=queryActivity"},
                {"queryBaoyeche","/evcard-mas/evcardapp?service=queryBaoyeche"},
                {"queryUnpaidOrder","/evcard-mas/evcardapp?service=queryUnpaidOrder"},
                {"getShareStatus","/evcard-mas/evcardapp?service=getShareStatus"}
        };
        ctx.put("TestCaseGroup",TestCaseGroup);
        merge(pageTpt, ctx,rootPath + "\\pages\\Evcard_Mas_Page.java");
        merge(assertTpt,ctx,rootPath+"\\asserts\\Evcard_Mas_Assert.java");
        merge(testcaseTpt,ctx,"E:\\move\\Evcard-AutoTest\\Evcard\\src\\test\\java\\Evcard_Mas_testcase\\Evcard_Mas_testcase.java");
    }

    private static void merge(Template template, VelocityContext ctx, String path) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(path);
            template.merge(ctx, writer);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}

