public abstract class CartoonBear implements Bear {
    private String name;
    private int height;
    private String furColor;
    private String catchPhrase;

    public CartoonBear(String name, int height, String furColor, String catchPhrase) {
        this.name = name;
        this.height = height;
        this.furColor = furColor;
        this.catchPhrase = catchPhrase;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public String getFurColor() {
        return furColor;
    }

    public abstract  String speaks();
    public abstract String getCatchPhrase();

}
