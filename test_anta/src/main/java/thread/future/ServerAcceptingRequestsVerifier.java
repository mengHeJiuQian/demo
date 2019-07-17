package thread.future;


import java.util.concurrent.Callable;

/**
 * 内容描述：
 * 创建人：yang.liu
 * 创建时间：2019/7/10 0:36
 * 版本：1.0
 */
public class ServerAcceptingRequestsVerifier implements Callable {
    /**
     * @return Boolean.TRUE is server is accepting requests
     * Boolean.FALSE otherwise
     */
    public Boolean call() throws Exception {
        Boolean isAcceptingRequests = null;
        return isAcceptingRequests;
    }
}
