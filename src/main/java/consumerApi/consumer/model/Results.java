package consumerApi.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
    @JsonProperty("gender")
    public String gender;
    @JsonProperty("name")
    public Name name;
    public Location location;
    public String email;
    public Login login;
    public Dob dob;
    public Registered registered;
    public String phone;
    public String cell;
    public JsonTypeInfo.Id id;
    public Picture picture;
    public String nat;

}