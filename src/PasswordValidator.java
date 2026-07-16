// ดูโจทย์ spec และวิธีทำใน README.md
public class PasswordValidator {

    static final int MIN_LEN = 8;
    static final int MAX_LEN = 20;

    static boolean validate(String pw) {
         if(pw == null) throw new IllegalArgumentException();
      if(pw.length()<8) return false;
            if(pw.length()>20) return false;


      boolean hasUpper = false ;
      boolean haslower = false ;
      

      for (int i = 0; i < pw.length(); i++) {
        if (Character.isWhitespace(pw.charAt(i))) {
            return false;
        }
        if(Character.isUpperCase(pw.charAt(i))){
            hasUpper = true;
        }
        if(Character.isLowerCase(pw.charAt(i))){
            haslower = true;
        }
      }
        return hasUpper && haslower;
    }
}