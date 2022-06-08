public class RobinHoodBear extends Baloo implements ISidekick{
    private String catchphrase;
    private Sidekick sidekick;

    public RobinHoodBear(String name, int height, String furColor, String catchphrase) {
        super(name, height, furColor, catchphrase);
    }

    @Override
    public String getCatchPhrase() {
        return "Give to the poor";
    }

    @Override
    public Sidekick getSideKick() {
        return sideKick;
    }
}
