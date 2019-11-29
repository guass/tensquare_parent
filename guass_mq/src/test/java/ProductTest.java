import com.guass.www.mq.GuassMqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GuassMqApplication.class)
public class ProductTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void test(){
        rabbitTemplate.convertAndSend("guass_queue","111111");
    }


    @Test
    public void test2(){
        rabbitTemplate.convertAndSend("guass",null,"222222");
    }
}
