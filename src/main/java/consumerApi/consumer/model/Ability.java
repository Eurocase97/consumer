package consumerApi.consumer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Ability implements Serializable {
    public String name;
    public String url;
}
