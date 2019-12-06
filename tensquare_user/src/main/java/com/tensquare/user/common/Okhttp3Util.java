package com.tensquare.user.common;

import okhttp3.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Okhttp3Util {

    private static Okhttp3Util ourInstance = new Okhttp3Util();

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()//构建器
            .connectTimeout(10, TimeUnit.SECONDS)//连接超时
            .writeTimeout(20, TimeUnit.SECONDS)//写入超时
            .readTimeout(10, TimeUnit.SECONDS)//读取超时

            // .addInterceptor(new CommonParamsInterceptor())//添加的是应用拦截器...公共参数
            //.addNetworkInterceptor(new CacheInterceptor())//添加的网络拦截器

            // .cache(new Cache(sdcache.getAbsoluteFile(), cacheSize))//设置缓存
            .build();

    public static Okhttp3Util getInstance() {
        return ourInstance;
    }

    private Okhttp3Util() {
    }

    /**
     * get请求
     * 参数1 url
     * 参数2 回调Callback
     */

    public void doGet(String url, Callback callback) {


        //创建Request
        Request request = new Request.Builder().url(url).build();
        //得到Call对象
        Call call = okHttpClient.newCall(request);
        //执行异步请求
        call.enqueue(callback);

    }

    /**
     * post请求
     * 参数1 url
     * 参数2 Map<String, String> params post请求的时候给服务器传的数据
     *      add..("","")
     *      add()
     */
    public void doPost(String url, Map<String, String> params, Callback callback) {


        //3.x版本post请求换成FormBody 封装键值对参数

        FormBody.Builder builder = new FormBody.Builder();
        //遍历集合
        for (String key : params.keySet()) {
            builder.add(key, params.get(key));

        }

        //创建Request
        Request request = new Request.Builder().url(url).post(builder.build()).build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);

    }

    /**
     * 同步
     * @param url
     * @param params
     * @return
     */
    public String doPost(String url, Map<String, String> params) {

        //3.x版本post请求换成FormBody 封装键值对参数
        FormBody.Builder builder = new FormBody.Builder();
        //遍历集合
        for (String key : params.keySet()) {
            builder.add(key, params.get(key));

        }

        //创建Request
        Request request = new Request.Builder().url(url).post(builder.build()).build();

        Call call = okHttpClient.newCall(request);
        try {
            String result = call.execute().body().string();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * post异步请求
     * @param url
     * @param json
     * @param callback
     * @throws IOException
     */
    public void postJson(String url, String json,Callback callback) throws IOException {


        RequestBody requestBody = FormBody.create(JSON, json);

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        System.out.println("request ==  " +request.toString());
        //创建/Call
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }


    /**
     * post同步请求
     * @param url
     * @param json
     * @return
     */
    public String postSyncJson(String url, String json){

        RequestBody requestBody = FormBody.create(JSON, json);

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        Call call = okHttpClient.newCall(request);
        try {
            //4.获得返回结果
            String result = call.execute().body().string();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 同步GET请求
     * @param url
     * @param params
     * @return
     */
    public String GET(String url, Map<String,Object> params){

        int index = 0;
        if(params != null && params.size() > 0){
            for(String key:params.keySet()){
                if(index == 0) {
                    url += "?" + key + "=" + params.get(key);
                }else {
                    url += "&" + key + "=" + params.get(key);
                }
                index++;
            }
        }

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Call call = okHttpClient.newCall(request);
        try {
            String result = call.execute().body().string();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 异步GET请求
     * @param url
     * @param params
     * @return
     */
    public void GET(String url,Map<String,Object> params,Callback callback){

        int index = 0;
        if(params != null && params.size() > 0){
            for(String key:params.keySet()){
                if(index == 0) {
                    url += "?" + key + "=" + params.get(key);
                }else {
                    url += "&" + key + "=" + params.get(key);
                }
                index++;
            }
        }

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);

    }




    public void uploadFile(String url, File file,Map<String,Object> params,Callback callback) throws Exception {

        MultipartBody.Builder builder = new MultipartBody.Builder();

        if(params != null && params.size() > 0){
            for(String key:params.keySet()){
                builder.addFormDataPart(key,params.get(key).toString());
            }
        }

        if (file != null) {
            builder.addFormDataPart("file", file!= null ? file.getName():"",
                    RequestBody.create(MediaType.parse("multipart/form-data"), file));
        }

        RequestBody requestBody = builder
                .setType(MultipartBody.FORM)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();


        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }



    /**
     * @param url
     * @param destFileDir
     * @param destFileName
     * @param listener
     */
    public void download(String url, Map<String,Object> params,final String destFileDir, final String destFileName, final OnDownloadListener listener) {


        int index = 0;
        if(params != null && params.size() > 0){
            for(String key:params.keySet()){
                if(index == 0) {
                    url += "?" + key + "=" + params.get(key);
                }else {
                    url += "&" + key + "=" + params.get(key);
                }
                index++;
            }
        }

        Request request = new Request.Builder()
                .url(url)
                .build();



        //异步请求
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 下载失败监听回调
                listener.onDownloadFailed(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;

                //储存下载文件的目录
                File dir = new File(destFileDir);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File file = new File(dir, destFileName);

                listener.onPrepare();

                try {

                    is = response.body().byteStream();
                    long total = response.body().contentLength();
                    fos = new FileOutputStream(file);
                    long sum = 0;
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                        sum += len;
                        int progress = (int) (sum * 1.0f / total * 100);
                        listener.onDownloading(progress);
                    }
                    fos.flush();
                    //下载完成
                    listener.onDownloadSuccess(file);
                } catch (Exception e) {
                    listener.onDownloadFailed(e);
                }finally {

                    try {
                        if (is != null) {
                            is.close();
                        }
                        if (fos != null) {
                            fos.close();
                        }
                        response.close();
                    } catch (IOException e) {

                    }

                }


            }
        });
    }


    public interface OnDownloadListener{

        /**
         * 下载成功之后的文件
         */
        void onDownloadSuccess(File file);

        /**
         * 下载进度
         */
        void onDownloading(int progress);

        /**
         * 下载异常信息
         */

        void onDownloadFailed(Exception e);

        void onPrepare();
    }
}
