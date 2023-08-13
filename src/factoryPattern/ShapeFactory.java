package factoryPattern;

public class ShapeFactory {
    public Shape getShape(String type) {
        return switch (type) {
            case "CIRCLE" -> new Circle();
            case "RECTANGLE" -> new Rectangle();
            default -> null;
        };
    }
}
