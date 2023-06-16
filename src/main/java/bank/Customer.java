package bank;

public class Customer {

  private int id;
  private String Name;
  private String username;
  private String password;
  private int account_id;
  private boolean authenticated;

  public int getAccount_id() {
    return this.account_id;
  }

  public void setAccount_id(int account_id) {
    this.account_id = account_id;
  }

  public boolean isAuthenticated() {
    return this.authenticated;
  }

  public void setAuthenticated(boolean authenticated) {
    this.authenticated = authenticated;
  }

  public Customer(int id, String name, String username, String password, int accountId) {

    setId(id);
    setName(name);
    setUsername(username);
    setPassword(password);
    setAccountId(account_id);
    setAuthenticated(false);

  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.Name;
  }

  public void setName(String Name) {
    this.Name = Name;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getAccountId() {
    return this.account_id;
  }

  public void setAccountId(int accountId) {
    this.account_id = accountId;
  }

}
