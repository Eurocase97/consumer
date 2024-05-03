package consumerApi.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Location{
    public Street street;
    public String city;
    public String state;
    public String country;
    public int postcode;
    public Coordinates coordinates;
    public Timezone timezone;
}