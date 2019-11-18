import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@RunWith(SpringRunner.class)
public class SpitTest {

    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void contextLoads() {

    }
}
