import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {
    static Stream<Arguments> streamProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 2}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{-1, -3, 5, 4}, new int[]{-3, -1, 4, 5}),
                Arguments.of(new int[]{-5, -3, -7, -8, -1}, new int[]{-8, -7, -5, -3, -1}),
                Arguments.of(new int[]{5, 4, 0, -3, 7}, new int[]{-3, 0, 4, 5, 7}),
                Arguments.of(new int[]{3, 9, -1}, new int[]{-1, 3, 9})
        );
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("streamProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array) {
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int[] result = new int[random_array.length];
        for (int i = 0; i < random_array.length; i++) {
            test.offer(random_array[i]);
        }
        for (int i = 0; i < random_array.length; i++) {
            s = test.poll();
            assertEquals(correct_array[i], s);
        }
    }

    @Test
    void testException1() {
        Exception e = assertThrows(Exception.class, () -> {
            //test.offer(null);
            PriorityQueue<Integer> test = new PriorityQueue<Integer>(-1);
        });
        assertEquals(e.getClass(), IllegalArgumentException.class);
    }

    @Test
    void testException2() {
        Exception e = assertThrows(Exception.class, () -> {
            PriorityQueue<Integer> test = new PriorityQueue<Integer>();
            test.offer(null);
        });
        assertEquals(e.getClass(), NullPointerException.class);
    }

    @Test
    void testException3() {
        Exception e = assertThrows(Exception.class, () -> {
            PriorityQueue<Integer> test = new PriorityQueue<Integer>();
            test.add(null);
        });
        assertEquals(e.getClass(), IllegalArgumentException.class);
    }

}