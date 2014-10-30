public boolean more14(int[] nums) {
  int ones = 0;
  int fours = 0;
  for (int c=0;c<nums.length;c++){
      if (nums[c] == 1){
	  ones = ones + 1;
      } else {
	  if (nums[c] == 4){
	      fours = fours + 1;
	  }
      }
  }
  if (ones > fours){
      return true;
  } else {
      return false;
  }
}

public boolean tripleUp(int[] nums) {
    int oof = 0;
    for (int c=0;c<nums.length-2;c++){
	if (nums[c] == (nums[c+1] - 1)){
	    if (nums[c] == (nums[c+2] - 2)){
		oof = 1;
	    } else {
		oof = oof;
	    }
	}
    }
    if (oof == 1) {
	return true;
    } else {
	return false;
    }
}


public int[] seriesUp(int n) {
    int[] result = new int[n * (n+1) / 2];
    int place = 0;
    for (int i=1;i<=n+1;i++){
	for (int j=1;j<i;j++){
	    result[place++]=j;
	}
    }
    return result;
}
