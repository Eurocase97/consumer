package consumerApi.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Picture{
    public String large;
    public String medium;
    public String thumbnail;
}
