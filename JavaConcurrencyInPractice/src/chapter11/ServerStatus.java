package chapter11;

import util.ThreadSafe;

import java.util.Set;

/**
 * 创建人：yang.liu
 * 创建时间：2019/7/29 18:03
 * 版本：1.0
 * 内容描述：对锁进行分解
 */
@ThreadSafe
public class ServerStatus {

    private final Set<String> users;
    private final Set<String> queries;

    public ServerStatus(Set<String> users, Set<String> queries) {
        this.users = users;
        this.queries = queries;
    }

    public synchronized void addUser(String u) {
        users.add(u);
    }

    public synchronized void addQuery(String q) {
        queries.add(q);
    }

    public synchronized void removeUser(String u) {
        users.remove(u);
    }

    public synchronized void removeQuery(String q) {
        queries.remove(q);
    }

}
