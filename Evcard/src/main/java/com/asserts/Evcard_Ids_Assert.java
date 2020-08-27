package com.asserts;

import com.builder.dispatchData;
import com.builder.newTaskQueryData;
import com.builder.queryMyTaskData;
import com.builder.queryMyTaskResultData;
import com.csvreader.CsvWriter;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;
import com.pages.Evcard_Ids_Page;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Velocity on 2017年-06月29日-15时03分11秒.
 */
public class Evcard_Ids_Assert {

    Evcard_Ids_Page evcard_mas_page = new Evcard_Ids_Page();
    List<HashMap> authors = null;

    public void asserttest(String JSESSIONID,String acw_tc,String accessToken,String csvpath,String startdate,String enddate) throws Exception {
//        String result = evcard_mas_page.test(JSESSIONID,acw_tc,accessToken,csvpath);
//        //List<String> authors = JsonPath.read(result, "$.data.content[?(@.ztStr == '违法未处理')].xh");
//        authors = JsonPath.read(result, "$.data.content[*].xh");
        authors = new ArrayList<HashMap>();


        authors = evcard_mas_page.test3(JSESSIONID,acw_tc,accessToken,csvpath);


        String filePath = csvpath;
        System.out.println(filePath);
        CsvWriter csvWriter = new CsvWriter(filePath,',', Charset.forName("UTF-8"));
        // 写表头
        //String[] headers = {"违法行为","罚款金额","记分值","号牌号码","违法地点","违法时间","是否处理","缴款状态","号牌种类"};
        String[] headers = {"号牌号码","罚款金额","记分值","违法时间","违法行为","违法地点","是否处理","缴款状态","号牌种类"};

        csvWriter.writeRecord(headers);
        for (int i = 0;i<authors.size();i++){
            System.out.println("开始执行:"+authors.get(i)+"---第"+(i+1)+"条数据---");
            List<HashMap> li = asserttest2(authors.get(i),JSESSIONID,acw_tc,accessToken,startdate,enddate);
            test3(li,csvWriter);
            System.out.println("写入完毕");
        }
        csvWriter.close();
        System.out.println("--------CSV文件已经写入--------");
        csvWriter.close();
    }

    public List<HashMap> asserttest2(HashMap xh,String a,String b,String d,String startdate,String enddate) throws Exception {
        List<String> result = evcard_mas_page.test2(xh,a,b,d,startdate,enddate);
        List<HashMap> authorslist = new ArrayList<>();
        final HashMap[] hashMap = {new HashMap()};
        //List<String> authors = JsonPath.read(result, "$.data.content[?(@.clbjStr == '未处理')]['wfms','hphm','wfdz','wfsj','hpzlStr','clbjStr','jkbjStr']");
       for(int i =0 ;i<result.size();i++){
           List<HashMap> authors = JsonPath.read(result.get(i), "$.data.content[*]['wfms','fkje','wfjfs','hphm','wfdz','wfsj','clbjStr','jkbjStr','hpzlStr','cjjg','xh','hpzl']");
           List<HashMap> authors2 = authors.stream().filter(info -> info.get("wfms") == null).collect(Collectors.toList());
           if (authors2.size()>0){
               authors.removeAll(authors2);
               authors2.forEach(e -> {
                   try {
                       hashMap[0] = test5(String.valueOf(e.get("hphm")),String.valueOf(e.get("hpzl")),String.valueOf(e.get("xh")),String.valueOf(e.get("cjjg")),a,b,d);
                       authors.add(hashMap[0]);
                   } catch (Exception exception) {
                       exception.printStackTrace();
                   }
               });
           }
           authorslist.addAll(authors);
       }
        return authorslist;
    }

    public void test3(List<HashMap> authors,CsvWriter csvWriter){
        //String filePath = "/Users/jinwei/Downloads/IDS_APIAutomation_OLD/Evcard/test.csv";

        try {
            // 创建CSV写对象
            //CsvWriter csvWriter = new CsvWriter(filePath,',', Charset.forName("UTF-8"));
            //CsvWriter csvWriter = new CsvWriter(filePath);


            //String[] content = {"12365","张山","34"};
            //csvWriter.writeRecord(headers);
            for (int i = 0; i <authors.size(); i++) {
                //String[] csvContent = { i + "000000", "StemQ", "1" + i };
                String[] csvContent = {(String) authors.get(i).get("hphm"),(String) authors.get(i).get("fkje"),(String) authors.get(i).get("wfjfs"),(String) authors.get(i).get("wfsj"),(String) authors.get(i).get("wfms"),(String) authors.get(i).get("wfdz"),(String) authors.get(i).get("clbjStr"),(String) authors.get(i).get("jkbjStr"),(String) authors.get(i).get("hpzlStr")};
                csvWriter.writeRecord(csvContent);
            }
//            csvWriter.close();
//            System.out.println("--------CSV文件已经写入--------");
//            csvWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap test5(String hphm,String hpzl,String xh,String cjjg,String JSESSIONID,String acw_tc,String accessToken) throws Exception {
        System.out.println("该车辆违法行为为空，进入二级页面查询");
        String result = evcard_mas_page.test5(hphm,hpzl,xh,cjjg,JSESSIONID,acw_tc,accessToken);
        HashMap authors = JsonPath.read(result,"$.data['wfms','fkje','wfjfs','hphm','wfdz','wfsj','clbjStr','jkbjStr','hpzlStr']");
        return authors;
    }

}