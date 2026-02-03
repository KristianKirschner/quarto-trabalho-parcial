package dto.auth;

public class LoginResponse {
    public String token;
    public String tokenType = "Bearer";
    public Integer userId;
    public String userName;
    public String userEmail;

    public LoginResponse() {}

    public LoginResponse(String token, Integer userId, String userName, String userEmail) {
        this.token = token;
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }
}
