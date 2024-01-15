package ud5.examples;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebugRockPaperScissorsTest {
    @Test
    @DisplayName("Empat: Pedra vs Pedra")
    void pedraEmpatPedra() {
        assertEquals(0, DebugRockPaperScissors.guanya("pedra", "pedra"));
    }

    @Test
    @DisplayName("Perd: Pedra vs Paper")
    void pedraPerdPaper() {
        assertEquals(2, DebugRockPaperScissors.guanya("pedra", "paper"));
    }

    @Test
    @DisplayName("Guanya: Pedra vs Tisores")
    void pedraGuanyaTisores(){
        assertEquals(1, DebugRockPaperScissors.guanya("pedra", "tisores"));
    }

    @Test
    @DisplayName("Guanya: Paper vs Pedra")
    void paperGuanyaPedra() {
        assertEquals(1, DebugRockPaperScissors.guanya("paper", "pedra"));
    }

    @Test
    @DisplayName("Empat: Paper vs Paper")
    void paperEmpatPaper() {
        assertEquals(0, DebugRockPaperScissors.guanya("paper", "paper"));
    }

    @Test
    @DisplayName("Perd: Paper vs Tisores")
    void paperPerdTisores(){
        assertEquals(2, DebugRockPaperScissors.guanya("paper", "tisores"));
    }

    @Test
    @DisplayName("Perd: Tisores vs Pedra")
    void tisoresPerdPedra() {
        assertEquals(2, DebugRockPaperScissors.guanya("tisores", "pedra"));
    }

    @Test
    @DisplayName("Guanya: Tisores vs Paper")
    void tisoresGuanyaPaper() {
        assertEquals(1, DebugRockPaperScissors.guanya("tisores", "paper"));
    }

    @Test
    @DisplayName("Empat: Tisores vs Tisores")
    void tisoresEmpataTisores(){
        assertEquals(0, DebugRockPaperScissors.guanya("tisores", "tisores"));
    }
}