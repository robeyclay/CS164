public class Knight extends MOB {
    protected int xp;
    protected final int id;
    public Fortune fortune;

    public Knight (int id, String name, int hp, int armor, int hitModifier, DiceType damageDie, int xp) {
        super(name, hp, armor, hitModifier, damageDie);
        this.id = id;
        this.xp = xp;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public DiceType getDamageDie(){
        return damageDie;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }

    public int getXP() {
        return xp;
    }

    public Fortune getActiveFortune() {
        return fortune;
    }

    public void setActiveFortune(Fortune activeFortune){
        this.fortune = activeFortune;
    }

    public void addXP(int xp) {
        this.xp += xp;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString(){
        String format = String.format("+======================+\n" +
                "|Name:%17s|\n" +
                "|HP:%19d|\n" +
                "|Armor:%16d|\n" +
                "|Weapon Skill:%9d|\n" +
                "|Power:%16s|\n" +
                "|XP:%19d|\n" +
                "+======================+", name, getDamage(), armor, hitModifier, damageDie, getXP());
        return format;
    }
}
