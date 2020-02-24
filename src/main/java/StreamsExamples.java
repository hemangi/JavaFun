import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Stream.flatMap() helps in converting Collection<Collection<T>> to Collection<T>.
public class StreamsExamples {
    public static void main (String args[]) {
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

        List<Integer> list = listOfLists.stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
        System.out.println("Combining list : " + list);

        String[][] dataArray = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}, {"g", "h"}};

        List<String> listOfAllChars = Arrays.stream(dataArray)
                .flatMap(x -> Arrays.stream(x))
                .collect(Collectors.toList());

        System.out.println("Combining multidimensional array : from {\"a\", \"b\"}, {\"c\", \"d\"}, {\"e\", \"f\"}, {\"g\", \"h\"} to (using flatmap)-->" + listOfAllChars);
    }

}
