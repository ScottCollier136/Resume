import java.util.*;

class SimpleArrayTasks {
    public static void main(String[] args) {

        int[] randomNumArray = {1,2,5,8,9,32,41,7,5,21,1,5,8,7,41,1,6,8,4,56,21,1,8,6,23,1,4,8,41,41,8,47,1,2,352,21,8,65,41,2,3,8,4,6,21,12,8,87,46,9,786,1,3,21,85,46};
        int[] randomNumArray2 = {1,2,5,8,1,1,2};

        removeDuplicates(randomNumArray2);
        
    }

    public static void reverseArray(int[] intArray){

        int forwardPointer = 0;
        int backwardsPointer = intArray.length - 1;
        int tempValueholder = 0;

        System.out.println(Arrays.toString(intArray));

        while(forwardPointer < backwardsPointer){
            tempValueholder = intArray[backwardsPointer];
            intArray[backwardsPointer] = intArray[forwardPointer];
            intArray[forwardPointer] = tempValueholder;
            forwardPointer++;
            backwardsPointer--;
        }

        System.out.println(Arrays.toString(intArray));
    }

    public static void findMostCommonElement(int[] intArray){

        int i = 0;
        int arrayValue = 0;
        HashMap<Integer, Integer> tempHashMap = new HashMap<Integer, Integer>();
        int highestFrequency = 0;
        int mostCommonValue = 0;

        for (i=0; i<intArray.length; i++){

            arrayValue = intArray[i];

            if(tempHashMap.containsKey(arrayValue)){
                tempHashMap.put (arrayValue, tempHashMap.get(arrayValue) + 1);
            }
            else{
                tempHashMap.put (arrayValue, 1);
            }
        }

        for (Map.Entry<Integer, Integer> mapEntries : tempHashMap.entrySet()){
            if (mapEntries.getValue() > highestFrequency){
                highestFrequency = mapEntries.getValue();
                mostCommonValue = mapEntries.getKey();
            }
        }

        System.out.println("The most recurring value is '" + mostCommonValue + "', which appears " + highestFrequency + " times.");

    }


    public static void removeDuplicates(int[] intArray){

        int i = 0;
        int arrayValue = 0;
        Map<Integer, Integer> tempHashMap = new HashMap<Integer, Integer>();
        ArrayList<Integer> uniqueValuesArray = new ArrayList<Integer>();

        for (i=0; i<intArray.length; i++){

            arrayValue = intArray[i];

            if(tempHashMap.containsKey(arrayValue)){
                tempHashMap.put (arrayValue, tempHashMap.get(arrayValue) + 1);
            }
            else{
                tempHashMap.put (arrayValue, 1);
            }
        }

        for (Map.Entry<Integer, Integer> mapEntries : tempHashMap.entrySet()){
            uniqueValuesArray.add(mapEntries.getKey());
        }

        System.out.println(uniqueValuesArray);

    }
}