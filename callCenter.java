package CallCenterDesign;

public class Call {

    public final String id;

    private long createTime;

    private int rank;

    private Employee handler;

    private final User user;

    public Call(final String id, final User user){
        this.id = id;
        this.user = user;
        rank = 1;
        this.createTime = System.currentTimeMillis();
    }

    public void setRank(final int rank){
        this.rank = rank;
    }

    public boolean setHandler(final Employee handler){
        if(handler.takeCall(this)){
            this.handler = handler;
            return true;
        }

        return false;
    }

    public boolean isWaiting(){
        return handler == null;
    }

    public void disConnect(){
        this.handler = null;
    }

    public int getRank(){
        return rank;
    }

    public long getCreateTime(){
        return createTime;
    }

    public User getUser(){
        return user;
    }

    public Employee getHandler(){
        return handler;
    }

}

package CallCenterDesign;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ServiceCenter {


    public static final int REPRESENTATIVE_NUM = 100;

    public static final int SENIOR_NUM = 10;

    public static final int MANAGER_NUM = 2;

    public static final int MAX_LEVEL = 3;

    private final List<Queue<Call>> waitingLists;
    private final List<List<Employee>> employees;

    private static ServiceCenter instance = null;

    private ServiceCenter(){

        waitingLists = new ArrayList<Queue<Call>>(MAX_LEVEL);
        employees = new ArrayList<List<Employee>>(MAX_LEVEL);

        initEmployee(REPRESENTATIVE_NUM,Rank.Representative);
        initEmployee(SENIOR_NUM,Rank.Senior);
        initEmployee(MANAGER_NUM,Rank.Manager);

        initWaitingList();
    }

    public static ServiceCenter getInstance(){
        if(instance == null){
            instance = new ServiceCenter();
        }

        return instance;
    }

    private void initEmployee(final int employeeNum, final Rank rank){

        final List<Employee> employeeList = new ArrayList<Employee>();

        for(int i = 0; i < employeeNum; i++){
            final Employee employee = new Employee("" + i,rank);
            employee.setServiceCenter(this);
            employeeList.add(employee);
        }

        employees.add(employeeList);
    }

    private void initWaitingList(){

        for(int i = 0; i < MAX_LEVEL; i++){
            waitingLists.add(new LinkedList<Call>());
        }
    }

    public void receiveCall(final Call call){
        final int callRank = call.getRank();
        final Queue<Call> waitingList = waitingLists.get(callRank);
        waitingList.add(call);
    }

    public boolean handleNormalCall(){

        if(assignCall(waitingLists.get(0).peek())){
            waitingLists.get(0).poll();
            return true;
        }

        return false;
    }

    public boolean assignCall(final Call call){
        if(call == null) return false;
        final int callRank = call.getRank();

        final List<Employee> employeeList = employees.get(callRank);

        for(Employee employee : employeeList){
            if(employee.takeCall(call)) return true;
        }

        return false;
    }
}