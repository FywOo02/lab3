import java.util.List;

public abstract class SpecialNumber {
    public abstract SpecialNumber add(SpecialNumber num) throws Lab3Exception;

    public abstract SpecialNumber divideByInt(int divisor) throws Lab3Exception;

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
