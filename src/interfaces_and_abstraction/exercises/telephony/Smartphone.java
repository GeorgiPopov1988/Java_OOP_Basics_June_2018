package interfaces_and_abstraction.exercises.telephony;

public class Smartphone implements Callable, Browsable{
  
  
  @Override
  public String browse(String url) {
    boolean isUrl = true;
    
    for (int i = 0; i < url.length(); i++) {
      char letter = url.charAt(i);
      if (Character.isDigit(letter)){
        isUrl = false;
        break;
      }
    }
    
    if (!isUrl) {
      throw new IllegalArgumentException("Invalid URL!");
    } else {
      return String.format("Browsing: %s!", url);
    }
  }
  
  @Override
  public String call(String phoneNumber) {
    boolean isPhoneNumber = true;
  
    for (int i = 0; i < phoneNumber.length(); i++) {
      char letter = phoneNumber.charAt(i);
      if (!Character.isDigit(letter)){
        isPhoneNumber = false;
        break;
      }
    }
  
    if (!isPhoneNumber) {
      throw new IllegalArgumentException("Invalid number!");
    } else {
      return String.format("Calling... %s", phoneNumber);
    }
  }
}
