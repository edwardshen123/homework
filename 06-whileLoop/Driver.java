//Front times: 2 min
public String frontTimes(String str, int n) {
  int counter = 0;
  String result = "";
  
  while (counter < n) {
    result += str.substring(0, Math.min(3, str.length()));
    counter++;
  }
  
  return result;
}

//String Bits: 2 min
public String stringBits(String str) {
  String result = "";
  int counter = 0;
  
  while (counter < str.length()) {
    result += str.substring(counter, counter + 1);
    counter += 2;
  }
  
  return result;
}

//string Yak: 5 min
public String stringYak(String str) {
  int counter = 0;
  String result = "";
  
  while (counter < str.length()) {
    if (counter < str.length() - 2 && str.substring(counter, counter + 3).equals("yak")) {
      counter += 3;
    }else{
      result += str.substring(counter, counter + 1);
      counter++;
    }
  }
  
  return result;
}


//string Match: 2 min
public int stringMatch(String a, String b) {
  int limit = Math.min(a.length(), b.length());
  int counter = 0;
  int pairCounter = 0;
  while (counter < limit - 1) {
  if (a.substring(counter, counter+2).equals(b.substring(counter, counter+2))) {
  pairCounter++;
  }
  counter++;
  }
  return pairCounter;
  
}
