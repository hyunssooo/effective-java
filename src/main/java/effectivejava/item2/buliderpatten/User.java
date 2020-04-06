package effectivejava.item2.buliderpatten;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    @Builder.Default
    private String name = "1";
}
