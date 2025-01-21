class RandomizedSet {
    private Map<Integer, Integer> map; // Store vale -> index
    private List<Integer> list;        // Store values for  random access
    private Random random;             // Random number generator
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;             // Value already in map
        }
        map.put(val, list.size());    // Map the value to its index in the list
        list.add(val);                // Add value to the list
        
        return true;                  // Successfully inserted
    }
       
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false; // Value does not exist
        }
        int index = map.get(val);             // Get the index of the value to remove
        int lastValue = list.get(list.size() - 1); // Get the last value in the list

        list.set(index, lastValue);           // Move the last value to the index of the value to remove
        map.put(lastValue, index);            // Update the map for the swapped value

        list.remove(list.size() - 1);         // Remove the last element
        map.remove(val);                      // Remove the value from the map
        return true;                          // Successfully removed
    }

    
    public int getRandom() {
        int randomIndex = random.nextInt(list.size()); // Generate a random number from (0 - list.size() - 1) 
        return list.get(randomIndex); // Return the number 
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */