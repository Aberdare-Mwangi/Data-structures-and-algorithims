def remove_duplicates(nums):
    if not nums:
        return 0
    unique_ptr = 0

    for i in range(1, len(nums)):
        if nums[i] != nums[unique_ptr]:
            unique_ptr += 1
            nums[unique_ptr] = nums[i]
    return unique_ptr + 1
nums = [1, 1, 2, 2, 3, 4, 4, 5]
new_length = remove_duplicates(nums)  

print("Original array:", nums[:new_length])
print("New length:", new_length)
