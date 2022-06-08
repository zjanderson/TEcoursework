public final class PapaBerenstainBear extends CartoonBear {
    // properties

    private String name;
    private int height;
    private String furColor;

    public PapaBerenstainBear(String name, int height, String furColor, String catchphrase) {
        super(name, height, furColor, catchphrase);
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

    //methods
    public String speaks(){
        return "Howdy";
    }

    @Override
    public String getCatchPhrase() {
        return null;
    }

}


