package net.schrage.resourceserver.response;

public class UserRest {

  private String firstName;
  private String lastName;
  private String id;

  public UserRest(String firstName, String lastName, String id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getId() {
    return id;
  }
}
