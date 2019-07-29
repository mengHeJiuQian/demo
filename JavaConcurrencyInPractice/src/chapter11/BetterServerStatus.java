package chapter11;

import util.ThreadSafe;

import java.util.Set;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/29 18:03
 * 版本：1.0
 * 内容描述：将ServerStatus改写为使用锁分解技术
 */
@ThreadSafe
public class BetterServerStatus {

    private final Set<String> users;
    private final Set<String> queries;

    public BetterServerStatus(Set<String> users, Set<String> queries) {
        this.users = users;
        this.queries = queries;
    }

    public synchronized void addUser(String u) {
        synchronized (users) {
            users.add(u);
        }
    }

    public synchronized void addQuery(String q) {
        synchronized (queries) {
            queries.add(q);
        }
    }

    public synchronized void removeUser(String u) {
        synchronized (users) {
            users.remove(u);
        }
    }

    public synchronized void removeQuery(String q) {
        synchronized (queries) {
            queries.remove(q);
        }
    }

}
