package pojos;


public class Generate_token {

    private String email;
    private String password;
    private String tenantId;
    private String localId;
    private String displayName;
    private String idToken;
    private String registered;
    private String refreshToken;
    private String expiresIn;

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String password)
    {
        this.password =password;
    }

    public void setTenantId(String tenantId)
    {
        this.tenantId = tenantId;
    }

    public String getEmail()
    {
        return  email;
    }

    public String getPassword(){
        return password;
    }

    public String getTenantId()
    {
        return tenantId;
    }

    public String getLocalId(){
        return localId;
    }
    public String getDisplayName()
    {
        return displayName;
    }

    public String getIdToken()
    {
        return idToken;
    }
    public String getRegistered(){
        return registered;
    }

    public String getExpiresIn(){
        return expiresIn;
    }
    public String getRefreshToken(){
        return refreshToken;
    }

}
