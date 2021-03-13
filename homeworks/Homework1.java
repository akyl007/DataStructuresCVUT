public class Homework1 implements Mergesort {
    @Override
    public int[] getFirstHalfOf(int[] array) {
        int delkaDelenaDvema = (array.length+1)/2;
        int[] newArray = new int[delkaDelenaDvema];
        System.arraycopy(array, 0, newArray, 0, delkaDelenaDvema);
        return newArray;
    }

    @Override
    public int[] getSecondHalfOf(int[] array) {
        int delkaDelenaDvema = (array.length)/2;
        int[] newArray = new int[delkaDelenaDvema];
        System.arraycopy(array, delkaDelenaDvema, newArray, 0, delkaDelenaDvema);
        return newArray;
    }

    @Override
    public int[] merge(int[] firstHalf, int[] secondHalf) {

        int first = 0;
        int second = 0;

        int[] mergeResult = new int[firstHalf.length + secondHalf.length];
        int resultIndex = 0;

        while (resultIndex < mergeResult.length) {
            if (first == firstHalf.length) {
                mergeResult[resultIndex] = secondHalf[second];
                second++;
            }
            else
            {
                if (second == secondHalf.length) {
                    mergeResult[resultIndex] = firstHalf[first];
                    first++;
                }
                else
                {
                    if (firstHalf[first] < secondHalf[second]) {
                        mergeResult[resultIndex] = firstHalf[first];
                        first++;
                    }
                    else
                    {
                        mergeResult[resultIndex] = secondHalf[second];
                        second++;
                    }
                }
            }

            resultIndex++;
        }

        return mergeResult;
    }

    @Override
    public int[] mergesort(int[] array) {
        boolean alreadySorted = array.length <= 1;
        if (alreadySorted) {
            return array;
        } else {
            int[] firstHalf = getFirstHalfOf(array);
            int[] secondHalf = getSecondHalfOf(array);
            int[] firstHalfSorted = mergesort(firstHalf);
            int[] secondHalfSorted = mergesort(secondHalf);

            return merge(firstHalfSorted, secondHalfSorted);
        }
    }
}
