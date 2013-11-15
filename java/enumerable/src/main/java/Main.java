import com.devshorts.enumerable.Enumerable;
import com.devshorts.enumerable.data.Tuple;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

import static java.util.Arrays.asList;

public class Main{
    public static void main(String[] arsg) throws InterruptedException, ExecutionException {

        List<String> t = asList("oooo", "ba", "baz", "booo");

        Enumerable<String> strings = Enumerable.init(t);

        strings.zip(strings, (a, b) -> new Tuple<>(a, b))
               .map(i -> i.item2.length())
               .zip(strings, (x, y) -> new Tuple<>(x, y))
               .orderBy(i -> i.item2)
               .skipWhile(i -> i.item1 < 4)
               .iteri((i, elem) -> System.out.println(i + ": " + elem.item1 + " * " + elem.item2))
               .toList();
    }

}