package entity;

public class StatusCode {
    public static final int OK = 20000;
    public static final int ERROR = 20001;
    public static final int LOGINERROR = 20002; //登陆失败
    public static final int ACCESSERROR = 20003; //权限不足
    public static final int REMOTEERROR = 20004; //远程调用失败
    public static final int REPERROR = 20005; //重复操作
}
