//stringSplosion
public String stringSplosion(String str) {
  String output = "";
  for (int lengthCounter = 0; lengthCounter < str.length(); lengthCounter++) {
    output += str.substring(0, lengthCounter + 1);
  }
  return output;
}

//stringX
public String stringX(String str) {
  String output = "";
  for (int lenC = 0; lenC < str.length(); lenC++) {
  if (lenC == 0 || lenC == str.length() - 1 || str.charAt(lenC) != 'x') {
  output += str.substring(lenC, lenC + 1);
  }
  }
  return output;
}
