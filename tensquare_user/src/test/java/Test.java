import com.tensquare.user.common.Okhttp3Util;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: guass
 * @description: 设备管理类
 * @data: 2019-05-28 12:20
 **/
public class Test {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("111","222","333","111","222");

        list.stream().distinct().forEach(System.out::println);
;    }


}
