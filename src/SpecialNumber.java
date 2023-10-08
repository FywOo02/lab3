import java.util.List;

public abstract class SpecialNumber {
    public abstract SpecialNumber add(SpecialNumber num) throws Lab3Exception;

    public abstract SpecialNumber divideByInt(int divisor) throws Lab3Exception;

    public SpecialNumber computeAverage(List<SpecialNumber> specialNumberList) throws Lab3Exception {
        if (specialNumberList == null){
            throw new Lab3Exception("List cannot be empty");
        }

        return null;
    }
}
