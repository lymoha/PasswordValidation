package validatePassword;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateASecuredPasswordTest {
    @Test
    public void  isPasswordContainsDigits_ShouldReturnFalse_WhenNotContainingDigit() {
        CreateASecuredPassword csp = new CreateASecuredPassword();
        assertTrue(csp.isPasswordContainsDigits("1Password"));
    }
@Test
public void  isContainsLowerAndUpperCase_ShouldReturnFalse_WhenNotContainingLowerAndUpperCase() {
    CreateASecuredPassword csp = new CreateASecuredPassword();
    assertTrue(csp.isContainsLowerAndUpperCase("agoodpaworP"));
}
    @Test
    public void  isPasswordContainsMinLength_ShouldReturnFalse_WhenMinLengthNotGreater7() {
        CreateASecuredPassword csp = new CreateASecuredPassword();
        assertFalse(csp.isPasswordContainsMinLength("agoodp"));
    }
    @Test
    public void  isPasswordStrongCheck_ShouldReturnTrue_WhenPasswordStrong() {
        CreateASecuredPassword csp = new CreateASecuredPassword();
        assertTrue(csp.isPasswordStrongCheck("MyGoodPassword9"));
    }
    @Test
    public void  isContainsSpecialCharacters_ShouldReturnTrue_WhenPasswordContainingSpecialCharacter() {
        CreateASecuredPassword csp = new CreateASecuredPassword();
        assertTrue(csp.isContainsSpecialCharacters("MyGoodPassword#"));
    }

}
