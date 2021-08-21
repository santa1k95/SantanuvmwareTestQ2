public class Rectangle implements Shape{
    Double length,breath;

    public Double getBreath() {
        return breath;
    }

    public void setBreath(Double breath) {
        this.breath = breath;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }


    @Override
    public Double area() {
        return length*breath;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", breath=" + breath +
                '}';
    }
}
