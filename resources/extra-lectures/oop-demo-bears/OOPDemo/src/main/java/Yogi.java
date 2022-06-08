public final class Yogi extends CartoonBear implements ISidekick {
    // properties
    private String catchphrase;
    private Sidekick sidekick;

    public Yogi(String name, int height, String furColor, String catchphrase) {
        super(name, height, furColor, catchphrase);
    }


    //methods
    public String speaks(){
        return "Howdy";
    }
    public String getCatchPhrase(){
        return "I'm smarter than the average bear";
    }

    public void stealPicnicBasket(){
        return;
    }

    @Override
    public Sidekick getSideKick() {
        return sidekick;
    }
}
