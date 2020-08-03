package Evcard_Mas;


import com.asserts.Evcard_Ids_Assert;

import com.datadriver.AutoDataDriverBase;

import com.pages.Evcard_Ids_Page;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Administrator on 2016/7/12.
 */
public class Evcard_Ids_testcase extends AutoDataDriverBase {

    Evcard_Ids_Assert evcard_ids_assert = new Evcard_Ids_Assert();
    Evcard_Ids_Page evcard_ids_page = new Evcard_Ids_Page();


    @Test(enabled = true)
    public void test() throws IOException {
      //  evcard_ids_assert.asserttest();
    }

    @Test(enabled = true)
    public void test2() throws IOException {
        System.out.println(System.getProperty("user.dir"));
    }
}