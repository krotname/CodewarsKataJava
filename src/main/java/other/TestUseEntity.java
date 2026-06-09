package other;

import lombok.Builder;
import lombok.Data;

public class TestUseEntity {

    @Data
    @Builder
    public static class Entity {
        private String name;
        private String characteristic;
    }

}
