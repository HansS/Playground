import com.devshorts.enumerable.Enumerable;
import com.devshorts.enumerable.data.Tuple;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertEquals;

public class EnumerableTests {
    @Test
    public void Distinct(){
        List<Integer> ids = Enumerable.init(asList(1, 1, 1, 2, 3, 4, 5, 6, 6, 7))
                                      .distinct()
                                      .toList();

        assertEquals(ids, asList(1,2,3,4,5,6,7));
    }

    @Test
    public void Zip(){
        Enumerable<Integer> ids = Enumerable.init(asList(1, 2, 3, 4, 5));

        List<String> expectZipped = asList("11", "22", "33", "44", "55");

        assertEquals(expectZipped, ids.zip(ids, (f, s) -> f.toString() + s.toString()).toList());
    }

    @Test
    public void Order(){
        assertEquals(asList(1, 2, 3, 4, 5),
                     Enumerable.init(asList(5, 4, 3, 2, 1))
                                .orderBy(i -> i)
                                .toList());
    }

    @Test
    public void OrderDesc(){
        assertEquals(asList(5, 4, 3, 2, 1),
                Enumerable.init(asList(1, 2, 3, 4, 5))
                        .orderByDesc(i -> i)
                        .toList());
    }

    @Test
    public void Map(){
        assertEquals(asList("5", "4", "3", "2", "1"),
                Enumerable.init(asList(5, 4, 3, 2, 1))
                        .map(i -> i.toString())
                        .toList());
    }

    @Test
    public void FlatMap(){
        assertEquals(asList("5", "4", "3", "2", "1"),
                Enumerable.init(asList(asList("5"), asList("4"), asList("3"), asList("2"), asList("1")))
                        .flatMap(i -> i)
                        .map(i -> i.toString())
                        .toList());
    }

    @Test
    public void Skip(){
        assertEquals(asList("4", "3", "2", "1"),
                Enumerable.init(asList("5", "4", "3", "2", "1"))
                        .skip(1)
                        .toList());
    }

    @Test
    public void SkipWhile(){
        assertEquals(asList("4", "3", "2", "1"),
                Enumerable.init(asList("5", "4", "3", "2", "1"))
                        .skipWhile(i -> i.equals("5"))
                        .toList());
    }

    @Test
    public void Take(){
        assertEquals(asList("5"),
                Enumerable.init(asList("5", "4", "3", "2", "1"))
                        .take(1)
                        .toList());
    }

    @Test
    public void TakeWhile(){
        assertEquals(asList("5"),
                Enumerable.init(asList("5", "4", "3", "2", "1"))
                        .takeWhile(i -> i.equals("5"))
                        .toList());
    }


}