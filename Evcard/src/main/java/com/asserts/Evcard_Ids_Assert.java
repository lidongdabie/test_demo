package com.asserts;


import com.VO.ExcelDataVO;
import com.csvreader.CsvWriter;
import com.jayway.jsonpath.JsonPath;
import com.pages.Evcard_Ids_Page;
import com.tools.ExcelWriter;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Velocity on 2017年-06月29日-15时03分11秒.
 */
public class Evcard_Ids_Assert {

    Evcard_Ids_Page evcard_mas_page = new Evcard_Ids_Page();
    List<HashMap> authors = null;

    public void asserttest(String JSESSIONID,String acw_tc,String accessToken,String startdate,String enddate,String csvpath_carNo,String csvpath_carNo2,String host,String usbkey,String exportFilePath) throws Exception {
//        String result = evcard_mas_page.test(JSESSIONID,acw_tc,accessToken,csvpath);
//        //List<String> authors = JsonPath.read(result, "$.data.content[?(@.ztStr == '违法未处理')].xh");
//        authors = JsonPath.read(result, "$.data.content[*].xh");
        authors = new ArrayList<HashMap>();


        authors = evcard_mas_page.test3(JSESSIONID,acw_tc,accessToken,host);


        //String filePath = csvpath;
        String filePath_carNo = csvpath_carNo;
        String filePath_carNo2 = csvpath_carNo2;
       // System.out.println(filePath);
        System.out.println(filePath_carNo);
      //  CsvWriter csvWriter = new CsvWriter(filePath,',', Charset.forName("UTF-8"));
        CsvWriter csvWriter_carNo = new CsvWriter(filePath_carNo,',', Charset.forName("UTF-8"));


        // 写表头
        //String[] headers = {"违法行为","罚款金额","记分值","号牌号码","违法地点","违法时间","是否处理","缴款状态","号牌种类"};
       // String[] headers = {"号牌号码","罚款金额","记分值","违法时间","违法行为","违法地点","是否处理","缴款状态","号牌种类"};
        String[] headers2 = {"号牌号码","号牌种类","是否爬取"};

       // csvWriter.writeRecord(headers);
        csvWriter_carNo.writeRecord(headers2);
        //写入车牌号数据
        System.out.println("写入车牌号数据");
        for (int i = 0;i<authors.size();i++){
            test6(authors.get(i),csvWriter_carNo);
        }

        System.out.println("写入完毕");

        CsvWriter csvWriter_carNo2 = new CsvWriter(filePath_carNo2,',', Charset.forName("UTF-8"));
        csvWriter_carNo2.writeRecord(headers2);
        try{
            for (int i = 0;i<authors.size();i++){
                System.out.println("开始执行:"+authors.get(i)+"---第"+(i+1)+"条数据---");
                List<HashMap> li = asserttest2(authors.get(i),JSESSIONID,acw_tc,accessToken,startdate,enddate,host,usbkey);
                //test3(li,csvWriter);
                exportExcel(li,exportFilePath);
                test7(authors.get(i),csvWriter_carNo2);
                //csvWriter.flush();
                csvWriter_carNo.flush();
                csvWriter_carNo2.flush();
                System.out.println("写入完毕");
            }
        }catch (Exception e){
            e.printStackTrace();
            csvWriter_carNo2.close();
        }

        System.out.println("--------Excle文件已经写入--------");
        //csvWriter.close();
        csvWriter_carNo.close();
        csvWriter_carNo2.close();
    }

    public List<HashMap> asserttest2(HashMap xh,String a,String b,String d,String startdate,String enddate,String host,String usbkey) throws Exception {
        List<String> result = evcard_mas_page.test2(xh,a,b,d,startdate,enddate,host,usbkey);
        List<HashMap> authorslist = new ArrayList<>();
        final HashMap[] hashMap = {new HashMap()};
        //List<String> authors = JsonPath.read(result, "$.data.content[?(@.clbjStr == '未处理')]['wfms','hphm','wfdz','wfsj','hpzlStr','clbjStr','jkbjStr']");
       for(int i =0 ;i<result.size();i++){
           List<HashMap> authors = JsonPath.read(result.get(i), "$.data.content[*]['wfms','fkje','wfjfs','hphm','wfdz','wfsj','clbjStr','jkbjStr','hpzlStr','cjjg','xh','hpzl']");
           //部分数据违法行为为空。进入二级子页面查询
           List<HashMap> authors2 = authors.stream().filter(info -> info.get("wfms") == null).collect(Collectors.toList());
           if (authors2.size()>0){
               authors.removeAll(authors2);
               authors2.forEach(e -> {
                   try {
                       hashMap[0] = test5(String.valueOf(e.get("hphm")),String.valueOf(e.get("hpzl")),String.valueOf(e.get("xh")),String.valueOf(e.get("cjjg")),a,b,d,host,String.valueOf(e.get("clbjStr")),String.valueOf(e.get("jkbjStr")));
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
        try {
            // 创建CSV写对象

            for (int i = 0; i <authors.size(); i++) {
                String[] csvContent = {(String) authors.get(i).get("hphm"),(String) authors.get(i).get("fkje"),(String) authors.get(i).get("wfjfs"),(String) authors.get(i).get("wfsj"),(String) authors.get(i).get("wfms"),(String) authors.get(i).get("wfdz"),(String) authors.get(i).get("clbjStr"),(String) authors.get(i).get("jkbjStr"),(String) authors.get(i).get("hpzlStr")};
                csvWriter.writeRecord(csvContent);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap test5(String hphm,String hpzl,String xh,String cjjg,String JSESSIONID,String acw_tc,String accessToken,String host,String clbjStr,String jkbjStr) throws Exception {
        System.out.println("该车辆违法行为为空，进入二级页面查询");
        String result = evcard_mas_page.test5(hphm,hpzl,xh,cjjg,JSESSIONID,acw_tc,accessToken,host);

        HashMap authors = JsonPath.read(result,"$.data['wfms','fkje','wfjfs','hphm','wfdz','wfsj','hpzlStr']");
        authors.put("clbjStr",clbjStr);
        authors.put("jkbjStr",jkbjStr);
        return authors;
    }

    public void test6(HashMap authors,CsvWriter csvWriter){

        try {
            String[] csvContent = {(String) authors.get("hphm"),(String) authors.get("hpzlStr")};
            csvWriter.writeRecord(csvContent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test7(HashMap authors, CsvWriter csvWriter) throws IOException {

        try {
            String[] csvContent = {(String) authors.get("hphm"),(String) authors.get("hpzlStr"),"已爬"};
            csvWriter.writeRecord(csvContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exportExcel(List<HashMap> authors,String exportFilePath){
        // 创建需要写入的数据列表
        List<ExcelDataVO> dataVOList = new ArrayList<>(2);
        dataVOList = authors.stream().map(it -> ExcelDataVO(it)).collect(Collectors.toList());
        // 写入数据到工作簿对象内
        Workbook workbook = ExcelWriter.exportData(dataVOList);

        // 以文件的形式输出工作簿对象
        FileOutputStream fileOut = null;
        try {
            String path = exportFilePath;
            File exportFile = new File(path);
            if (!exportFile.exists()) {
                exportFile.createNewFile();
            }

            fileOut = new FileOutputStream(exportFilePath);
            workbook.write(fileOut);
            fileOut.flush();
        } catch (Exception e) {
            System.out.println("输出Excel时发生错误，错误原因：" + e.getMessage());
        } finally {
            try {
                if (null != fileOut) {
                    fileOut.close();
                }
                if (null != workbook) {
                    workbook.close();
                }
            } catch (IOException e) {
                System.out.println("关闭输出流时发生错误，错误原因：" + e.getMessage());
            }
        }

    }

    public ExcelDataVO ExcelDataVO(HashMap it) {
        ExcelDataVO dataVO = new ExcelDataVO();
        dataVO.setHpzlStr((String) it.get("hpzlStr"));
        dataVO.setJkbjStr((String) it.get("jkbjStr"));
        dataVO.setClbjStr((String) it.get("clbjStr"));
        dataVO.setWfdz((String) it.get("wfdz"));
        dataVO.setWfms((String) it.get("wfms"));
        dataVO.setWfsj((String) it.get("wfsj"));
        dataVO.setWfjfs((String) it.get("wfjfs"));
        dataVO.setFkje((String) it.get("fkje"));
        dataVO.setHphm((String) it.get("hphm"));
        return dataVO;
    }

    }