public class Square implements Shape{
    Double side;


    public Double getSide() {
        return side;
    }

    public void setSide(Double side) {
        this.side = side;
    }


    @Override
    public Double area() {
        return side*side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
