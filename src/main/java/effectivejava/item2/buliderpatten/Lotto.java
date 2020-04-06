package effectivejava.item2.buliderpatten;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

@Builder
@Getter
public class Lotto {
    @Singular private List<Long> nums;
}
