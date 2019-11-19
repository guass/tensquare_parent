import com.alibaba.fastjson.JSON;
import com.tensquare.spit.pojo.Spit;
import org.junit.Test;

import java.util.Date;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
public class GuassTest {

    @Test
    public void test(){
        Spit spit = new Spit();
        spit.set_id("2222");
        spit.setComment(56);
        spit.setContent("kkkkk");
        spit.setNickName("guass");
        spit.setPublishTime(new Date());
        spit.setShare(1);
        spit.setVisits(6);


        System.out.println(JSON.toJSONString(spit));
    }
}
