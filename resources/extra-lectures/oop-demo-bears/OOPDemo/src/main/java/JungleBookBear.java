public class JungleBookBear extends Baloo implements ISidekick {
    private String catchphrase;
    private Sidekick sidekick;
    public JungleBookBear(String name, int height, String furColor, String catchphrase) {
        super(name, height, furColor,catchphrase);
    }


    @Override
    public String getCatchPhrase() {
        return "Bare Necessities";
    }

    @Override
    public Sidekick getSideKick() {
        return null;
    }
}
