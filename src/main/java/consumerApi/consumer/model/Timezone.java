package consumerApi.consumer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Timezone{
    public String offset;
    public String description;
}
