package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName EX4
 * @Description TODO
 * @Author Patrick Star
 * @Date 2020/12/7 4:38 下午
 */
class task {
    task(int id, int d, int w) {
        this.id = id;
        this.d = d;
        this.w = w;
    }

    public int id;
    public int d;
    public int w;

    @Override
    public String toString() {
        return "a" + id;
    }
}

public class EX4 {

    public static task[] getTasks1() {
        return new task[]{
                new task(1, 4, 70),
                new task(2, 2, 60),
                new task(3, 4, 50),
                new task(4, 3, 40),
                new task(5, 1, 30),
                new task(6, 4, 20),
                new task(7, 6, 10),

        };
    }
    public static task[] getTasks2() {
        return new task[]{
                new task(1, 4, 0),
                new task(2, 2, 10),
                new task(3, 4, 20),
                new task(4, 3, 30),
                new task(5, 1, 40),
                new task(6, 4, 50),
                new task(7, 6, 60),

        };
    }

    public static void greedy(task[]tasks){
        // 1. 对任务队列按照w大小排序
        Arrays.sort(tasks, new Comparator<task>() {
            @Override
            public int compare(task o1, task o2) {
                return o2.w-o1.w;
            }
        });

        // 找到最大的d
        int maxD=-1;
        for(int i=0;i<tasks.length;i++){
            if(maxD<tasks[i].d){
                maxD=tasks[i].d;
            }
        }
        // 每个时间片是否有任务设置标记
        List<task> list = new ArrayList<task>();
        int []flag=new int[maxD+1];
        for(int i=0;i<tasks.length;i++){
            int j;
            // 向左找到空位
            for(j=tasks[i].d;j>0;j--){
                // 找到空位的位置
                if(flag[j]==0){
                    flag[j]=1;
                    list.add(tasks[i]);
                    break;
                }
            }
        }
        // 将任务按照d有小到大排序
        list.sort(new Comparator<task>() {
            @Override
            public int compare(task o1, task o2) {
                return o1.d-o2.d;
            }
        });
        System.out.println(list);

    }

    public static void main(String[] args) {

        System.out.println("===============task1=================");
        task[] tasks1 = getTasks1();
        greedy(tasks1);

        System.out.println("===============task2=================");
        task[] tasks2 = getTasks2();
        greedy(tasks2);


    }
}
