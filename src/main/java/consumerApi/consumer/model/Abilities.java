package consumerApi.consumer.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Abilities implements Serializable {
    public Ability ability;
    public boolean is_hidden;
    public int slot;
}
