//nonStart Code
public String nonStart(String a, String b) {
  return (a.substring(1,a.length()) + b.substring(1,b.length()));
}

//makeAbba Code
public String makeAbba(String a, String b) {
  return (a + b + b + a);
}

//diff21 Code
public int diff21(int n) {
  if (n > 21) {
  return 2*(n - 21);
  }
  return 21 - n;
}
