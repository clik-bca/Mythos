package probe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProbeTest {
    @Test
    void greetingIsStable() {
        assertEquals("token-ok", Probe.greeting());
    }
}
