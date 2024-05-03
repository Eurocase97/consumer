package consumerApi.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dob{
    public Date date;
    public int age;
}