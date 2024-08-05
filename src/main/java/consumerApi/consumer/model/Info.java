package consumerApi.consumer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Info {
    private String seed;
    private Integer results;
    private Integer page;
    private String version;
}
