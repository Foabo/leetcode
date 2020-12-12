package main

/*
 * @Date: 2020-11-05 15:01:27
 * @LastEditors: Foabo
 * @LastEditTime: 2020-11-07 13:44:54
 * @FilePath: /leetcode_vs/sortAlgs.go
 */
import "fmt"

func partition(nums []int, low int, high int) int {

	pivot := nums[low]
	for low < high {
		for low < high && nums[high] > pivot {
			high--
		}
		if low < high {
			nums[low] = nums[high]
			low++
		}
		for low < high && nums[low] < pivot {
			low++
		}
		if low < high {
			nums[high] = nums[low]
			high--
		}

	}
	nums[low] = pivot
	fmt.Println("Partition 后的数组为: ", nums)
	// fmt.Println("划分位置： ",low)

	return low
}
func quickSort(nums []int, low int, high int) {
	if low >= high {
		return
	}
	mid := partition(nums, low, high)
	quickSort(nums, low, mid-1)
	quickSort(nums, mid+1, high)
}

func countingSort(nums []int) []int {
	/* 找出计数排序的最大最小值 */
	max := nums[0]
	min := nums[0]
	for _, num := range nums {
		if max < num {
			max = num
		}
		if min > num {
			min = num
		}
	}
	//cnt保存了数组中每个值出现的个数
	cnt := countingSortHelper(nums, max, min)
	fmt.Println("数组对应元素出现的个数: ", cnt)
	/*
		fmt.Println(cnt)
		k := 0
		for i, _ := range cnt {
			for j := 0; j < cnt[i]; j++ {
				//重新排列nums
				nums[k] = min + i
				k++
			}

	*/

	k := len(nums)
	res := make([]int, k)
	//对所有的计数累加
	for i := 1; i < len(cnt); i++ {
		cnt[i] += cnt[i-1]
	}
	//从后往前遍历
	for i := len(nums) - 1; i >= 0; i-- {

		res[cnt[nums[i]-min]-1] = nums[i]
		cnt[nums[i]-min] -= 1

	}
	return res

}
func countingSortHelper(nums []int, max int, min int) []int {
	cnt := make([]int, max-min+1)

	// 统计数组中每个值为num的元素出现的次数，存入数组cnt中
	for _, num := range nums {
		cnt[num-min] += 1
	}
	return cnt

}

func main() {
	nums := []int{-2, 1, -3, 4, -1, 2, 1, -5, 4}
	quickSort(nums, 0, len(nums)-1)
	fmt.Println("快排结果： ", nums)
	fmt.Println()
	nums2 := []int{95, 94, 91, 98, 99, 90, 99, 93, 91, 92}
	fmt.Println(countingSort(nums2))
}
