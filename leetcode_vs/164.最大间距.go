package leetcode_vs

/*
 * @lc app=leetcode.cn id=164 lang=golang
 *
 * [164] 最大间距
 */

// @lc code=start
func maximumGap1(nums []int) (res int) {
	n := len(nums)
	if n < 2 {
		return
	}
	// 基数排序
	buf := make([]int, n)
	maxVal := max(nums...)
	for exp := 1; exp <= maxVal; exp *= 10 {
		cnt := [10]int{}
		for _, v := range nums {
			// 尾数
			digit := v / exp % 10
			cnt[digit]++
		}

		for i := 1; i < 10; i++ {
			cnt[i] += cnt[i-1]
		}
		for i := n - 1; i >= 0; i-- {
			digit := nums[i] / exp % 10
			buf[cnt[digit]-1] = nums[i]
			cnt[digit]--
		}
		copy(nums, buf)

	}
	for i := 1; i < n; i++ {
		res = max(res, nums[i]-nums[i-1])
	}
	return

}
type pair struct{ min, max int }
func maximumGap(nums []int) (res int) {
	n := len(nums)
	if n < 2 {
		return
	}
	minVal :=min(nums...)
	maxVal := max(nums...)
	bucketLen:=max(1, (maxVal-minVal)/(n-1))
	bucketSize :=(maxVal - minVal)/bucketLen+1

	buckets := make([]pair, bucketSize)
	for i := range buckets {
        buckets[i] = pair{-1, -1}
    }
	for _,v :=range nums{
		loc:=(v-minVal)/bucketLen
		// 放到一个新的捅
		if buckets[loc].min == -1 {
            buckets[loc].min = v
            buckets[loc].max = v
        } else {
            buckets[loc].min = min(buckets[loc].min, v)
            buckets[loc].max = max(buckets[loc].max, v)
        }


	}

	prev := -1
    for i, b := range buckets {
        if b.min == -1 {
            continue
        }
        if prev != -1 {
            res = max(res, b.min-buckets[prev].max)
        }
        prev = i
    }
    return

}
func max(a ...int) int {
	res := a[0]
	for _, v := range a[1:] {
		if res < v {

			res = v
		}

	}
	return res
}

func min(a ...int) int {
	res := a[0]
	for _, v := range a[1:] {
		if res > v {
			res = v
		}
	}
	return res
}

// @lc code=end
