package Evcard_Mas;


import com.asserts.Evcard_Ids_Assert;

import com.datadriver.AutoDataDriverBase;

import com.pages.Evcard_Ids_Page;
import lombok.SneakyThrows;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sun.jvm.hotspot.oops.ArrayKlass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/7/12.
 */
public class Evcard_Ids_testcase extends AutoDataDriverBase {

    Evcard_Ids_Assert evcard_ids_assert = new Evcard_Ids_Assert();
    Evcard_Ids_Page evcard_ids_page = new Evcard_Ids_Page();


    @Test(invocationCount = 100)
    public void testaddNewTask() throws IOException {
        List<String> list = new ArrayList<>();
        list.add("11122233300");
        list.add("11122233302");
        list.add("11122233303");
        list.add("11122233304");
        list.add("11122233305");
        list.add("11122233306");
        list.add("11122233307");
        list.add("11122233308");
        list.add("11122233310");
        list.add("11122233311");
        list.add("11122233312");
        list.add("11122233313");
        list.add("11122233314");
        list.add("11122233315");
        list.add("11122233316");
        list.add("11122233317");
        list.add("11122233318");
        list.add("11122233319");
        list.add("11122233320");
        list.add("11122233321");
        list.add("11122233322");
        list.add("11122233327");
        list.add("11122233328");
        list.add("11122233329");
        list.add("11122233330");
        list.add("11122233331");
        list.add("11122233332");
        list.add("11122233333");
        list.add("11122233334");
        list.add("11122233335");
        list.add("11122233336");
        list.add("11122233337");
        list.add("11122233338");
        list.add("11122233339");
        list.add("11122233340");
        list.add("11122233341");
        list.add("11122233342");
        list.add("11122233343");
        list.add("11122233344");
        list.add("11122233345");
        list.add("11122233347");
        list.add("11122233348");
        list.add("11122233349");
        list.add("11122233350");
        list.add("11122233351");
        list.add("11122233352");
        list.add("11122233353");
        list.add("11122233354");
        list.add("11122233355");
        list.add("11122233356");
        list.add("11122233357");
        list.add("11122233358");
        list.add("11122233359");
        list.add("11122233360");
        list.add("11122233361");
        list.add("11122233362");
        list.add("11122233363");
        list.add("11122233364");
        list.add("11122233365");
        list.add("11122233366");
        list.add("11122233367");
        list.add("11122233368");
        list.add("11122233369");
        list.add("11122233370");
        list.add("11122233371");
        list.add("11122233373");
        list.add("11122233374");
        list.add("11122233375");
        list.add("11122233376");
        list.add("11122233377");
        list.add("11122233378");
        list.add("11122233379");
        list.add("11122233380");
        list.add("11122233381");
        list.add("11122233382");
        list.add("11122233383");
        list.add("11122233384");
        list.add("11122233385");
        list.add("11122233386");
        list.add("11122233387");
        list.add("11122233388");
        list.add("11122233389");
        list.add("11122233390");
        list.add("11122233391");
        list.add("11122233392");
        list.add("11122233394");
        list.add("11122233395");
        list.add("11122233396");
        list.add("11122233397");
        list.add("11122233398");
        list.add("11122233400");
        list.add("11122233401");
        list.add("11122233404");
        list.add("11122233405");
        list.add("11122233406");
        list.add("11122233407");
        list.add("11122233408");
        list.add("11122233409");
        list.add("11122233410");
        list.add("11122233411");
        list.add("11122233412");
        list.add("11122233413");
        list.add("11122233414");
        list.add("11122233415");
        list.add("11122233416");
        list.add("11122233419");
        list.add("11122233420");
        list.add("11122233421");
        list.add("11122233422");
        list.add("11122233423");
        list.add("11122233424");
        list.add("11122233425");
        list.add("11122233426");
        list.add("11122233427");
        list.add("11122233428");
        list.add("11122233429");
        list.add("11122233430");
        list.add("11122233431");
        list.add("11122233432");
        list.add("11122233433");
        list.add("11122233434");
        list.add("11122233435");
        list.add("11122233436");
        list.add("11122233437");
        list.add("11122233439");
        list.add("11122233440");
        list.add("11122233441");
        list.add("11122233443");
        list.add("11122233444");
        list.add("11122233445");
        list.add("11122233446");
        list.add("11122233447");
        list.add("11122233448");
        list.add("11122233449");
        list.add("11122233450");
        list.add("11122233451");
        list.add("11122233452");
        list.add("11122233453");
        list.add("11122233454");
        list.add("11122233455");
        list.add("11122233456");
        list.add("11122233457");
        list.add("11122233459");
        list.add("11122233460");
        list.add("11122233461");
        list.add("11122233462");
        list.add("11122233463");
        list.add("11122233465");
        list.add("11122233466");
        list.add("11122233467");
        list.add("11122233468");
        list.add("11122233469");
        list.add("11122233470");
        list.add("11122233471");
        list.add("11122233472");
        list.add("11122233473");
        list.add("11122233474");
        list.add("11122233476");
        list.add("11122233478");
        list.add("11122233479");
        list.add("11122233480");
        list.add("11122233481");
        list.add("11122233482");
        list.add("11122233483");
        list.add("11122233485");
        list.add("11122233490");
        list.add("11122233491");
        list.add("11122233492");
        list.add("11122233493");
        list.add("11122233494");
        list.add("11122233495");
        list.add("11122233496");
        list.add("11122233497");
        list.add("11122233498");
        list.add("11122233499");
        list.add("11122233500");
        list.add("11122233501");
        list.add("11122233502");
        list.add("11122233503");
        list.add("11122233504");
        list.add("11122233505");
        list.add("11122233506");
        list.add("11122233507");
        list.add("11122233508");
        list.add("11122233509");
        list.add("11122233510");
        list.add("11122233511");
        list.add("11122233512");
        list.add("11122233513");
        list.add("11122233514");
        list.add("11122233515");
        list.add("11122233516");
        list.add("11122233517");
        list.add("11122233518");
        list.add("11122233519");
        list.add("11122233520");
        list.add("11122233521");
        list.add("11122233522");
        list.add("11122233523");
        list.add("11122233524");
        list.add("11122233525");
        list.add("11122233526");
        list.add("11122233527");
        list.add("11122233528");
        list.add("11122233529");
        list.add("11122233530");
        list.add("11122233531");
        list.add("11122233532");
        list.add("11122233533");
        list.add("11122233534");
        list.add("11122233535");
        list.add("11122233536");
        list.add("11122233537");
        list.add("11122233538");
        list.add("11122233539");
        list.add("11122233540");
        list.add("11122233541");
        list.add("11122233542");
        list.add("11122233543");
        list.add("11122233544");
        list.add("11122233545");
        list.add("11122233546");
        list.add("11122233547");
        list.add("11122233548");
        list.add("11122233549");
        list.add("11122233550");
        list.add("11122233551");
        list.add("11122233552");
        list.add("11122233553");
        list.add("11122233554");
        list.add("11122233555");
        list.add("11122233556");
        list.add("11122233557");
        list.add("11122233558");
        list.add("11122233559");
        list.add("11122233560");
        list.add("11122233561");
        list.add("11122233562");
        list.add("11122233563");
        list.add("11122233564");
        list.add("11122233565");
        list.add("11122233566");
        list.add("11122233567");
        list.add("11122233568");
        list.add("11122233569");
        list.add("11122233570");
        list.add("11122233571");
        list.add("11122233572");
        list.add("11122233573");
        list.add("11122233574");
        list.add("11122233575");
        list.add("11122233576");
        list.add("11122233577");
        list.add("11122233578");
        list.add("11122233579");
        list.add("11122233580");
        list.add("11122233581");
        list.add("11122233582");
        list.add("11122233583");
        list.add("11122233584");
        list.add("11122233585");
        list.add("11122233586");
        list.add("11122233587");
        list.add("11122233588");
        list.add("11122233589");
        list.add("11122233590");
        list.add("11122233591");
        list.add("11122233592");
        list.add("11122233593");
        list.add("11122233594");
        list.add("11122233595");
        list.add("11122233596");
        list.add("11122233597");
        list.add("11122233598");
        list.add("11122233599");
        list.add("11122233600");
        list.add("11122233601");
        list.add("11122233602");
        list.add("11122233603");
        list.add("11122233604");
        list.add("11122233605");
        list.add("11122233606");
        list.add("11122233607");
        list.add("11122233608");
        list.add("11122233609");
        list.add("11122233610");
        list.add("11122233611");
        list.add("11122233612");
        list.add("11122233613");
        list.add("11122233614");
        list.add("11122233615");
        list.add("11122233616");
        list.add("11122233617");
        list.add("11122233618");
        list.add("11122233619");
        list.add("11122233620");
        list.add("11122233621");
        list.add("11122233622");
        list.add("11122233623");
        list.add("11122233624");
        list.add("11122233625");
        list.add("11122233626");
        list.add("11122233627");
        list.add("11122233628");
        list.add("11122233629");
        list.add("11122233630");
        list.add("11122233631");
        list.add("11122233632");
        list.add("11122233633");
        list.add("11122233634");
        list.add("11122233635");
        list.add("11122233636");
        list.add("11122233637");
        list.add("11122233638");
        list.add("11122233639");
        list.add("11122233640");
        list.add("11122233641");
        list.add("11122233642");
        list.add("11122233643");
        list.add("11122233644");
        list.add("11122233645");
        list.add("11122233646");
        list.add("11122233647");
        list.add("11122233648");
        list.add("11122233649");
        list.add("11122233650");
        list.add("11122233651");
        list.add("11122233652");
        list.add("11122233653");
        list.add("11122233654");
        list.add("11122233655");
        list.add("11122233656");
        list.add("11122233657");
        list.add("11122233658");
        list.add("11122233659");
        list.add("11122233660");
        list.add("11122233661");
        list.add("11122233662");
        list.add("11122233663");
        list.add("11122233664");
        list.add("11122233665");
        list.add("11122233666");
        list.add("11122233667");
        list.add("11122233668");
        list.add("11122233669");
        list.add("11122233670");
        list.add("11122233671");
        list.add("11122233672");
        list.add("11122233673");
        list.add("11122233674");
        list.add("11122233675");
        list.add("11122233676");
        list.add("11122233679");
        list.add("11122233689");
        list.add("11122233690");
        list.add("11122233691");
        list.add("11122233692");
        list.add("11122233693");
        list.add("11122233694");
        list.add("11122233695");
        list.add("11122233696");
        list.add("11122233697");
        list.add("11122233698");
        list.add("11122233699");
        list.add("11122233700");
        list.add("11122233701");
        list.add("11122233702");
        list.add("11122233703");
        list.add("11122233704");
        list.add("11122233705");
        list.add("11122233706");
        list.add("11122233707");
        list.add("11122233708");
        list.add("11122233709");
        list.add("11122233710");
        list.add("11122233711");
        list.add("11122233712");
        list.add("11122233713");
        list.add("11122233714");
        list.add("11122233715");
        list.add("11122233716");
        list.add("11122233717");
        list.add("11122233718");
        list.add("11122233719");
        list.add("11122233720");
        list.add("11122233721");
        list.add("11122233722");
        list.add("11122233723");
        list.add("11122233724");
        list.add("11122233725");
        list.add("11122233726");
        list.add("11122233727");
        list.add("11122233730");
        list.add("11122233731");
        list.add("11122233732");
        list.add("11122233733");
        list.add("11122233734");
        list.add("11122233735");
        list.add("11122233736");
        list.add("11122233737");
        list.add("11122233738");
        list.add("11122233739");
        list.add("11122233740");
        list.add("11122233741");
        list.add("11122233742");
        list.add("11122233743");
        list.add("11122233744");
        list.add("11122233745");
        list.add("11122233746");
        list.add("11122233747");
        list.add("11122233749");
        list.add("11122233750");
        list.add("11122233751");
        list.add("11122233752");
        list.add("11122233753");
        list.add("11122233754");
        list.add("11122233755");
        list.add("11122233756");
        list.add("11122233757");
        list.add("11122233758");
        list.add("11122233759");
        list.add("11122233760");
        list.add("11122233761");
        list.add("11122233762");
        list.add("11122233763");
        list.add("11122233764");
        list.add("11122233765");
        list.add("11122233766");
        list.add("11122233767");
        list.add("11122233768");
        list.add("11122233769");
        list.add("11122233770");
        list.add("11122233771");
        list.add("11122233772");
        list.add("11122233773");
        list.add("11122233774");
        list.add("11122233775");
        list.add("11122233776");
        list.add("11122233790");
        list.add("11122233791");
        list.add("11122233800");
        list.add("11122233801");
        list.add("11122233802");
        list.add("11122233803");
        list.add("11122233804");
        list.add("11122233805");
        list.add("11122233806");
        list.add("11122233807");
        list.add("11122233808");
        list.add("11122233809");
        list.add("11122233810");
        list.add("11122233811");
        list.add("11122233813");
        list.add("11122233814");
        list.add("11122233815");
        list.add("11122233816");
        list.add("11122233817");
        list.add("11122233818");
        list.add("11122233830");
        list.add("11122233831");
        list.add("11122233832");
        list.add("11122233833");
        list.add("11122233834");
        list.add("11122233835");
        list.add("11122233836");
        list.add("11122233837");
        list.add("11122233838");
        list.add("11122233840");
        list.add("11122233841");
        list.add("11122233842");
        list.add("11122233843");
        list.add("11122233844");
        list.add("11122233845");
        list.add("11122233847");
        list.add("11122233848");
        list.add("11122233849");
        list.add("11122233850");
        list.add("11122233851");
        list.add("11122233852");
        list.add("11122233853");
        list.add("11122233854");
        list.add("11122233855");
        list.add("11122233856");
        list.add("11122233857");
        list.add("11122233858");
        list.add("11122233859");
        list.add("11122233860");
        list.add("11122233861");
        list.add("11122233862");
        list.add("11122233863");
        list.add("11122233864");
        list.add("11122233865");
        list.add("11122233866");
        list.add("11122233867");
        list.add("11122233868");
        list.add("11122233869");
        list.add("11122233870");
        list.add("11122233871");
        list.add("11122233891");
        list.add("11122233900");
        list.add("11122233901");
        list.add("11122233902");
        list.add("11122233903");
        list.add("11122233904");
        list.add("11122233905");
        list.add("11122233906");
        list.add("11122233907");
        list.add("11122233908");
        list.add("11122233909");
        list.add("11122233910");
        list.add("11122233911");
        list.add("11122233912");
        list.add("11122233913");
        list.add("11122233914");
        list.add("11122233915");
        list.add("11122233917");
        list.add("11122233918");
        list.add("11122233919");
        list.add("11122233920");
        list.add("11122233923");
        list.add("11122233924");
        list.add("11122233930");
        list.add("11122233931");
        list.add("11122233935");
        list.add("11122233950");
        list.add("11122233952");
        list.add("11122233953");
        list.add("11122233954");
        list.add("11122233955");
        list.add("11122233956");
        list.add("11122233957");
        list.add("11122233958");
        list.add("11122233959");
        list.add("11122233960");
        list.add("11122233961");
        list.add("11122233962");
        list.add("11122233963");
        list.add("11122233964");
        list.add("11122233965");
        list.add("11122233966");
        list.add("11122233967");
        list.add("11122233968");
        list.add("11122233969");
        list.add("11122233970");
        list.add("11122233971");
        list.add("11122233972");
        list.add("11122233973");
        list.add("11122233974");
        list.add("11122233975");
        list.add("11122233976");
        list.add("11122233977");
        list.add("11122233978");
        list.add("11122233979");
        list.add("11122233980");
        list.add("11122233981");
        list.add("11122233991");
        list.add("11122233997");
        list.add("11122233999");
        list.add("11122234000");
        list.add("11122234001");
        list.add("11122234002");
        list.add("11122234003");
        list.add("11122234022");
        list.add("11122234030");
        list.add("11122234031");
        list.add("11122234050");
        list.add("11122234051");
        list.add("11122234052");
        list.add("11122234053");
        list.add("11122234054");
        list.add("11122234055");
        list.add("11122234056");
        list.add("11122234101");
        list.add("11122234102");
        list.add("11122234103");
        list.add("11122234104");
        list.add("11122234105");
        list.add("11122234106");
        list.add("11122234108");
        list.add("11122234109");
        list.add("11122234110");
        list.add("11122234111");
        list.add("11122234113");
        list.add("11122234114");
        list.add("11122234115");
        list.add("11122234116");
        list.add("11122234123");
        list.add("11122234128");
        list.add("11122234132");
        list.add("11122234135");
        list.add("11122234136");
        list.add("11122234137");
        list.add("11122234138");
        list.add("11122234139");
        list.add("11122234140");
        list.add("11122234141");
        list.add("11122234144");
        list.add("11122234148");
        list.add("11122234149");
        list.add("11122234150");
        list.add("11122234151");
        list.add("11122234152");
        list.add("11122234153");
        list.add("11122234154");
        list.add("11122234155");
        list.add("11122234161");
        list.add("11122234163");
        list.add("11122234164");
        list.add("11122234165");
        list.add("11122234166");
        list.add("11122234167");
        list.add("11122234168");
        list.add("11122234169");
        list.add("11122234170");
        list.add("11122234176");
        list.add("11122234177");
        list.add("11122234179");
        list.add("11122234181");
        list.add("11122234182");
        list.add("11122234185");
        list.add("11122234186");
        list.add("11122234187");
        list.add("11122234188");
        list.add("11122234189");
        list.add("11122234190");
        list.add("11122234191");
        list.add("11122234192");
        list.add("11122234193");
        list.add("11122234194");
        list.add("11122234195");
        list.add("11122234196");
        list.add("11122234197");
        list.add("11122234199");
        list.add("11122234200");
        list.add("11122234201");
        list.add("11122234202");
        list.add("11122234203");
        list.add("11122234204");
        list.add("11122234206");
        list.add("11122234207");
        list.add("11122234208");
        list.add("11122234210");
        list.add("11122234216");
        list.add("11122234217");
        list.add("11122234218");
        list.add("11122234219");
        list.add("11122234220");
        list.add("11122234221");
        list.add("11122234222");
        list.add("11122234224");
        list.add("11122234227");
        list.add("11122234228");
        list.add("11122234229");
        list.add("11122234230");
        list.add("11122234231");
        list.add("11122234232");
        list.add("11122234233");
        list.add("11122234234");
        list.add("11122234236");
        list.add("11122234237");
        list.add("11122234238");
        list.add("11122234239");
        list.add("11122234240");
        list.add("11122234241");
        list.add("11122234246");
        list.add("11122234247");
        list.add("11122234249");
        list.add("11122234251");
        list.add("11122234256");
        list.add("11122234257");
        list.add("11122234258");
        list.add("11122234261");
        list.add("11122234271");
        list.add("11122234272");
        list.add("11122234286");
        list.add("11122234291");
        list.add("11122234296");
        ExecutorService executor = Executors.newFixedThreadPool(300);

        for(int i =0 ;i<=list.size();i++){
            int finalI = i;
            Runnable task = new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                   // evcard_ids_assert.test4(list.get(finalI));
                }
            };
            executor.submit(task);
        }
        executor.shutdown();
        try {
            if(!executor.awaitTermination(30, TimeUnit.SECONDS)){
                // 超时的时候向线程池中所有的线程发出中断(interrupted)。
                executor.shutdownNow();
            }
            System.out.println("AwaitTermination Finished");
        } catch (InterruptedException ignore) {
            executor.shutdownNow();
        }
        while (true){
            if(executor.isTerminated()){
                System.out.println("所有子线程结束!");
                break;
            }
    }

    }


}