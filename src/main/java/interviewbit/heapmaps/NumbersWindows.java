package interviewbit.heapmaps;

import java.util.*;


public class NumbersWindows {

    public static void main(String[] args) {
        NumbersWindows s = new NumbersWindows();
//        s.dNums(Arrays.asList(1, 2, 1, 3, 4, 3), 3);
    }


    public ArrayList<Integer> dNums(ArrayList<Integer> elements, int size) {
        HashMap<Integer, Integer> windowsCount = new HashMap<>();
        ArrayList<Integer> distincts = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        elements.forEach(element ->{
            queue.add(element);
            windowsCount.put(element, windowsCount.getOrDefault(element, 0) + 1);

            if(queue.size() > size){
                Integer removed = queue.poll();
                windowsCount.put(removed, windowsCount.get(removed) - 1);
                if (windowsCount.get(removed) == 0){
                    windowsCount.remove(removed);
                }
            }

            if (queue.size() == size){
                distincts.add(windowsCount.values().size());
            }
        });

        return distincts;
    }
}
