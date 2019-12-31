import java.lang.reflect.Array;
import java.util.*;

import com.fanpin.entity.*;
import com.fanpin.service.ICIficationSvc;
import com.fanpin.service.ILoginSvc;
import com.fanpin.service.IOrderSvc;
import com.fanpin.service.IProductSvc;
import com.fanpin.service.impl.OrderSvcIMPL;
import com.fanpin.util.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fanpin.util.ToolsUtil;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyTest {

    @Resource
    private ILoginSvc loginSvc;

    @Resource
    private IProductSvc productSvc;

    @Resource
    private IOrderSvc orderSvc;

    @Resource
    private ICIficationSvc cIficationSvc;

    @Test
    public void testname() {

        //编码规范：将[] 放在类型后 ，反例——非规范：byte buffer[];
		/*String[] str= {"1","2"};
		System.out.println(str[1]);*/

		/*--------------------测试1------------------------*/
        /*int everyPage = 5;
        Integer classid=1001;
        int totalCount = productSvc.proSelCount(classid);
        int currentPage; //当前页
        String scurrentPage=null;
        if (scurrentPage == null) {
            currentPage = 1;
        } else {
            currentPage = Integer.parseInt(scurrentPage);
        }
        Page page = ToolsUtil.createPage(everyPage, totalCount, currentPage, classid);
        System.out.println("是否有下一页："+page.isHasNextPage());
        List<Product> list = productSvc.findPage(page);
        for (Product product : list) {
            System.out.println(product);
        }*/

        /*--------------------测试2------------------------*/
        /*List<Order> list = orderSvc.getMyOrders(10010,0);
        for (Order order : list) {
            System.out.println(order.toString());
            List<OrderDetail> list1 = order.getOdetails();
            for (OrderDetail orderDetail : list1) {
                System.out.println(orderDetail.toString());
            }
        }*/

        /*--------------------测试3------------------------*/
        /*
        * ordercode:"20191026233451"
        * date:"2019-10-26"
        * */
        /*List<Order> list = orderSvc.getAdminOrders(null, null, "1", null, null, null);
        for (Order order1 : list) {
            System.out.println("----------"+order1);
            List<OrderDetail> list1 = order1.getOdetails();
            for (OrderDetail orderDetail : list1) {
                System.out.println("*******"+orderDetail.toString());
            }
        }*/

        /*--------------------测试4------------------------*/
        /*Order order = orderSvc.getOrderDetailById(33);
        List<OrderDetail> list1 = order.getOdetails();
        for (OrderDetail orderDetail : list1) {
            System.out.println(orderDetail.toString());
        }*/

        /*--------------------测试5------------------------*/
        /*List<Product> list = productSvc.searchProduct("手", null);
        System.out.println(list.size());*/

        /*--------------------测试6------------------------*/
        /*ClassIfication sort = new ClassIfication();
        sort.setClassid(1001);
        sort.setCname("移动终端");
        sort.setDescb("");
        int i = cIficationSvc.deleteSort(12);
        System.out.println(i);*/
    }

    public static void testF() {
        int[] array = {12, 31, 435, 2, 5};
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        for (int i = 0; i < 5; i++) {
            map.put("mymap", array[i]);
            map.put("mymap2", "哈哈");
            list.add(map);
        }
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap.get("mymap2"));
        }
        /*for (Map<String,Object> stringObjectMap : list) {
            System.out.println(stringObjectMap.get("mymap"));
        }*/
    }
}
