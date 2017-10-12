package interviewbit.trees;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelReviews {


    public static void main(String[] args) {
        HotelReviews s = new HotelReviews();

        TreeNode treeNode = new TreeNode(460, 3871, 4698, 8399, 504, 4421, 7515, -1, 4167, 5727, -1, -1, 3096, 434, 7389, 2667, 5661, 1969, 7815, 4292, 3006, 9750, 6693, -1, 6906, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
        treeNode.print();
        new HotelReviews().solve("cool_ice_wifi", Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed"));

    }

    static final String SEPARATOR = "_";
    class Order{
        Integer index = 0;
        Integer count =0;
        public Order(int i, int c){ this.index = i; this.count = c;}
    }

    public ArrayList<Integer> solve(String wordsConcat, List<String> reviews) {
        ArrayList<Order> orders = new ArrayList<>();
        HashSet<String> keywords = new HashSet<>(Arrays.asList(wordsConcat.split(SEPARATOR)));

        for(int i=0; i < reviews.size(); i++){
            String review = reviews.get(i);
            long count = Stream.of(review.split(SEPARATOR)).filter(keywords::contains).count();
            orders.add(new Order(i, (int) count));
        }

        List<Integer> result = orders.stream().sorted((o1, o2) -> {
            int count = o2.count.compareTo(o1.count);
            return count == 0 ? o1.index.compareTo(o2.index) : count;
        }).map(order -> order.index).collect(Collectors.toList());

        return new ArrayList<>(result);
    }


}
