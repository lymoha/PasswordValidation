package validatePassword;

public class Application {
    public static void main(String[] args) {
CreateASecuredPassword csp = new CreateASecuredPassword();
//csp.isPasswordValidityCheck(csp.generateRandomPassword());
        System.out.println(csp.isPasswordValidityCheck(csp.generateRandomPassword()));
    }
}
