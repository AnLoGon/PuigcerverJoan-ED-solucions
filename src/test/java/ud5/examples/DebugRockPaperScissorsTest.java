package ud5.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebugRockPaperScissorsTest {
    @Test
    @DisplayName("Guanya: Pedra vs Tisores")
    void pedraGuanyaTisores(){
        assertEquals(1, DebugRockPaperScissors.guanya("pedra", "tisores"));
    }

    @Test
    @DisplayName("Empat: Tisores vs Tisores")
    void tisoresEmpataTisores(){
        assertEquals(0, DebugRockPaperScissors.guanya("tisores", "tisores"));
    }
}