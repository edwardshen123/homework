public int[] frontPiece(int[] nums) {
  if (nums.length < 2) {
    return nums;
  } else {
    return new int[] {nums[0], nums[1]};
  }
}

public int sum13(int[] nums) {
  int sum = 0;
  for (int c = 0; c < nums.length; c++) {
    if (nums[c] == 13) {
      c++;
    } else {
      sum+=nums[c];
    }
  }
  return sum;
}
