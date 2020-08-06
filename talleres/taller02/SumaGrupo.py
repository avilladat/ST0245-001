def suma_grupo(start, nums, target):
    if start==len(nums):
        if target==0:
            return True
        else:
            return False
    else:
        return suma_grupo(start+1, nums, target-nums[start]) == True or suma_grupo(start+1, nums, target) == True

print("Suma Grupo")
print((suma_grupo(0, [10,2,2,5], 8)))