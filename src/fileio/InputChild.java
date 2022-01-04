package fileio;

import enums.Category;
import enums.Cities;

import java.util.ArrayList;
import java.util.List;

public final class InputChild {

  private Integer id;
  private String lastName;
  private String firstName;
  private Integer age;
  private Cities city;
  private Double niceScore;
  private List<Category> giftsPreferences;

  public InputChild() {

  }

  public InputChild(final Integer id, final String lastName, final String firstName,
                    final Integer age, final Cities city, final Double niceScore,
                    final List<Category> giftsPreferences) {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
    this.age = age;
    this.city = city;
    this.niceScore = niceScore;
    this.giftsPreferences = giftsPreferences;
  }

  public Integer getId() {
    return id;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public Integer getAge() {
    return age;
  }

  public Cities getCity() {
    return city;
  }

  public Double getNiceScore() {
    return niceScore;
  }

  public List<Category> getGiftsPreferences() {
    return giftsPreferences;
  }
  @Override
  public String toString() {
    return "InputChild{" +
        "id=" + id +
        ", lastName='" + lastName + '\'' +
        ", firstName='" + firstName + '\'' +
        ", age=" + age +
        ", city=" + city +
        ", niceScore=" + niceScore +
        ", giftsPreferences=" + giftsPreferences +
        '}';
  }

}
