package validatePassword;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class CreateASecuredPassword {

    //Folgende Zeichen werden für die Generierung eines sicheren Passworts benötigt
    private final String ALPHABET_UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String ALPHABET_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private final String DIGITS = "0123456789";
    private final String CHARACTERS_SPECIAL = "!@#$%^&*_=+-/";
    private static final Pattern SPECIAL_CHARS_PATTERN = Pattern.compile("[^a-z0-9 ]");
    private final SecureRandom randomlyGeneratedPassword = new SecureRandom();
    private final Pattern CHARACTERS_SPECIAL_Patern = Pattern.compile("[@#$%^&*_=+-/]");

    int minPasswordLength = 8;
    boolean checkLowerCase;
    boolean checkUpperCase;
    //boolean checkPasswordContainsDigits;
    //boolean checkPasswordLength;

    // 16 Zeichen würde ausreichen
    int pwd16Chars = randomlyGeneratedPassword.nextInt(minPasswordLength) + 8;
    String addCharacters = ALPHABET_LOWERCASE + ALPHABET_UPPERCASE + DIGITS + CHARACTERS_SPECIAL;

    public boolean isPasswordContainsDigits(String digitPassword) {

//        char[] chars = digitPassword.toCharArray();
//
//        for (char ch : chars){
//            if (Character.isDigit(ch)){
//                return true;
//            }
//        }
//
//        return false;
        return digitPassword.matches(".*[0-9].*");
    }

    public boolean isContainsLowerAndUpperCase(String password) {
//        checkLowerCase = false;
//        checkUpperCase = false;
//
//        for (char c : password.toCharArray()) {
//            if (Character.isLowerCase(c)) {
//                checkLowerCase = true;
//            } else if (Character.isUpperCase(c)) {
//                checkUpperCase = true;
//            }
//
//            if (checkUpperCase && checkLowerCase) {
//                return true;
//            }
//        }
//return false;
        return !password.toUpperCase().equals(password) && !password.toLowerCase().equals(password);
    }

    public boolean isPasswordContainsMinLength(String password) {
        return password.length() >= minPasswordLength;
    }

    public boolean isPasswordValidityCheck(String password) {
        return isPasswordContainsMinLength(password) && isContainsLowerAndUpperCase(password) && isPasswordContainsDigits(password);

    }

    public boolean isPasswordStrongCheck(String password) {
        String[] passwords = new String[]{"MohaLy@7WK", "1Kaiser2Pinguin", "myPasswordBeiGoogle", "yahooMail"};
        boolean commonlyUsedPwd = true;

        for (String s : passwords) {
            if(s.equals(password)) {
                commonlyUsedPwd = false;
            }
        }

        return isPasswordValidityCheck(password) && isContainsLowerAndUpperCase(password)
                && isPasswordContainsMinLength(password)
                && commonlyUsedPwd;
    }
        public boolean isContainsSpecialCharacters(String password){
            return CHARACTERS_SPECIAL_Patern.matcher(password).find();
        }

    public String generateRandomPassword() {
        List<Character> passwordChars = new ArrayList<>();

        passwordChars.add(getRandomCharacter(DIGITS));
        passwordChars.add(getRandomCharacter(CHARACTERS_SPECIAL));
        passwordChars.add(getRandomCharacter(ALPHABET_LOWERCASE));
        passwordChars.add(getRandomCharacter(ALPHABET_UPPERCASE));

        for (int i = 0; i <pwd16Chars; i++) {
            passwordChars.add(getRandomCharacter(addCharacters));
        }

        Collections.shuffle(passwordChars, randomlyGeneratedPassword);

        StringBuilder password = new StringBuilder();
        for (char ch : passwordChars) {
            password.append(ch);
        }

        return password.toString();
    }

    public char getRandomCharacter(String characters) {
        return characters.charAt(randomlyGeneratedPassword.nextInt(characters.length()));
    }

}

