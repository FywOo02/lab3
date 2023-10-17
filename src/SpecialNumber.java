import java.util.List;

public abstract class SpecialNumber {
    public abstract SpecialNumber add(SpecialNumber num) throws Lab3Exception;

    public abstract SpecialNumber divideByInt(int divisor) throws Lab3Exception;

    /**
     * Computes the average of a list of SpecialNumber objects.
     *
     * This method takes a list of SpecialNumber objects and calculates the average value
     * by summing all the elements in the list and dividing by the number of elements.
     *
     * @param specialNumberList A list of SpecialNumber objects to compute the average from.
     * @return The average SpecialNumber value of the elements in the input list.
     * @throws Lab3Exception If the input list is null or empty, a Lab3Exception is thrown.
     *                      The exception message will indicate that the list cannot be empty.
     */
    public static SpecialNumber computeAverage(List<SpecialNumber> specialNumberList) throws Lab3Exception {
        if (specialNumberList == null){
            throw new Lab3Exception("List cannot be empty");
        }
        SpecialNumber result = specialNumberList.get(0);
        for(int i=1; i<specialNumberList.size(); i++){
            result = result.add(specialNumberList.get(i));
        }
        return result.divideByInt(specialNumberList.size());
    }
}
