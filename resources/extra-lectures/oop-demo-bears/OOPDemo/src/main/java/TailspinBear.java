public class TailspinBear extends Baloo implements ISidekick {
    private String catchphrase;
    private Sidekick sidekick;

    public TailspinBear(String name, int height, String furColor,String catchphrase) {
        super(name, height, furColor,catchphrase);
    }

    @Override
    public Sidekick getSideKick() {
        return sidekick;
    }
}
