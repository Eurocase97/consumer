package consumerApi.consumer.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Ability implements Serializable {
    public String name;
    public String url;
}
