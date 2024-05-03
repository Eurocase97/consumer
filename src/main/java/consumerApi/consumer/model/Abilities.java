package consumerApi.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonIgnoreProperties
public class Abilities implements Serializable {
    public Ability ability;
    public boolean is_hidden;
    public int slot;
}