//mixStart Codes
public boolean mixStart(String str) {
  return (str.length()>=3 && (str.substring(0,3).endsWith("ix")));
}

//makeOutWord Codes
public String makeOutWord(String out, String word) {
  return (out.substring(0,2) + word + out.substring(2,4));
}

//firstHalf Codes
public String firstHalf(String str) {
  return str.substring(0, (str.length()/2));
}
