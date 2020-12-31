package mooc.duoxianchengxu.dxc01;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static int[] a(int[] nums ,int target){
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return indexs;
    }

	/**
	 * 设想百米赛跑比赛 发令枪发出信号后选手开始跑，全部选手跑到终点后比赛结束
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
	    int[] nums = {2,5,9,10};
        for (int i : a(nums, 7)) {
            System.out.println(i);
        }


//
//		int runnerCnt = 10;
//		CountDownLatch startSignal = new CountDownLatch(1);
//		CountDownLatch doneSignal = new CountDownLatch(runnerCnt);
//
//		for (int i = 0; i < runnerCnt; ++i) // create and start threads
//			new Thread(new Worker(startSignal, doneSignal)).start();
//
//		System.out.println("准备工作...");
//		System.out.println("准备工作就绪");
//		startSignal.countDown(); // let all threads proceed
//		System.out.println("比赛开始");
//		doneSignal.await(); // wait for all to finish
//		System.out.println("比赛结束");
	}

	static class Worker implements Runnable {
		private final CountDownLatch startSignal;
		private final CountDownLatch doneSignal;

		Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
			this.startSignal = startSignal;
			this.doneSignal = doneSignal;
		}

		public void run() {
			try {
				startSignal.await();
				doWork();
				doneSignal.countDown();
			} catch (InterruptedException ex) {
			} // return;
		}

		void doWork() {
			System.out.println(Thread.currentThread().getName() + ": 跑完全程");
		}
	}
}
