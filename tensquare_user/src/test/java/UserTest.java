import com.alibaba.fastjson.JSON;
import com.tensquare.user.UserApplication;
import com.tensquare.user.pojo.TbAdmin;
import com.tensquare.user.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class UserTest {

    @Resource
    AdminService adminService;

    @Test
    public void test(){
        TbAdmin admin = new TbAdmin();
        admin.setPassword("123456");
        admin.setLoginname("guass");
        admin.setState("1");

        adminService.addAdminUser(admin);
    }
}
