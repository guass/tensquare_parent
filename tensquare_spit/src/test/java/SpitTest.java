import com.tensquare.spit.pojo.Spit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import utils.IdWorker;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpitTest {

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    IdWorker idWorker;

    @Test
    public void contextLoads() {
        Spit spit = new Spit();
        spit.set_id(idWorker.nextId() +"");
        spit.setComment(56);
        spit.setContent("kkkkk");
        spit.setNickName("guass");
        spit.setPublishTime(new Date());
        spit.setShare(1);
        spit.setVisits(6);

        mongoTemplate.save(spit);
    }
}
