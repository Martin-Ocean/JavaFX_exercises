public class Test {
    public static void main(String[] args) {
        // Create a map
        MyMap<String, Integer> map = new MyHashMap<>();
        map.put("Smith", 30);
        map.put("Anderson", 31);
        map.put("Lewis", 29);
        map.put("Cook", 29);
        map.put("Tom", 21);
        map.put("Mark", 21);
        map.put("Smith", 65);
        map.put("Smith", 67);
        map.put("William", 21);

        System.out.println("Entries in map: " + map);

        System.out.println("The age of Smith is " +
                map.get("Smith"));
/*
        System.out.println("The age of William is " +
                map.get("William"));

        System.out.println("Is Smith in the map? " +
                map.containsKey("Smith"));

        System.out.println("Is Jay in the map? " +
                map.containsKey("Jay"));

        System.out.println("Is age 33 in the map? " +
                map.containsValue(33));

        System.out.println("Is age 31 in the map? " +
                map.containsValue(31));

        System.out.print("Keys in map: ");
        for (String key : map.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();

        System.out.print("Values in map: ");
        for (int value : map.values()) {
            System.out.print(value + " ");
        }
        System.out.println();
*/
        map.remove("Smith");
        System.out.println("Entries in map " + map);

        map.clear();
        System.out.println("Entries in map " + map);

    }
}
