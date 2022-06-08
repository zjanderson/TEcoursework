public class Baloo extends CartoonBear {

    private String balooCatchPhrase;

    public Baloo(String name, int height, String furColor, String catchphrase) {
        super(name, height, furColor, catchphrase);

    }

    @Override
    public String speaks() {
        return "";
    }


    @Override
    public String getCatchPhrase() {
        return balooCatchPhrase;
    }

    public String sings(){
        return "La la la la";
    }

    public String dances(){
        return "dance dance dance";
    }
}
