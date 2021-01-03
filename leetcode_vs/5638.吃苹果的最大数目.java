/*
 * @lc app=leetcode.cn id=5638 lang=java
 *
 * [5638] 吃苹果的最大数目
 */
 
// @lc code=star
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        // 尽量每天都吃苹果
        // 但吃哪天的苹果要考虑
        // 对第i天，吃最快过期的那个
        int n = days.length;
        int [] outdate = new int [n];
        int max = 0;
        for(int i = 0;i<n;i++){  
            if(days[i]>0){
                outdate[i]=i+days[i]; 
            if(max<outdate[i])max=outdate[i];
            }
        }
        int eat = 0;
        // 定义一个优先队列当做最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                return outdate[i]-outdate[j];
            }
        });
        
        for(int i = 0 ;i<max;i++){
            // 每天都将苹果加入优先队列

            if(i<n&&apples[i]>0){
                queue.offer(i);
            }
            // 每天都尽量吃，但是判断能不能吃得判断apples[j]>0且i<=outdate[j];
            // 因为今天能不能吃，不仅看今天有没有，还看前面有没有剩下的 
            int j = -1;// j不一定有值
            
            while(!queue.isEmpty()){
                // 每次找过期时间最早的
                j = queue.poll();
                // 如果今天还没有过期
                if(i<outdate[j]){
                    eat++;
                    break;
                }                
            }
            if(j==-1)continue;
            // j有值的话
            apples[j]--;
            // 如果还有苹果
            if(apples[j]>0){
                queue.offer(j);
            }
        }
        return eat;
        
    }
}
// @lc code=en