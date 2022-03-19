import java.util.ArrayList;

public abstract class GameData {
    protected static final java.util.Random random;
    protected final java.util.List<Fortune> fortunes;
    protected final java.util.List<MOB> monsters;
    protected final java.util.List<Knight> knights;
    protected final java.util.List<Knight> activeKnights;

    public GameData(){

    }
    public java.util.List<Knight> getKnights(){
        return knights;
    }

    public java.util.List<Knight> getActiveKnights(){
        return activeKnights;
    }
    public Knight findKnight(String nameOrId, java.util.List<Knight> list){
        Knight target = null;
        for(Knight checker: list){
            if(nameOrId.contains(checker.getName())){
                target = checker;
            }
            if(nameOrId.equals(checker.getId())){
                target = checker;
            }
        }
        return target;
    }

    public Knight getActive(String nameOrId){
        return findKnight(nameOrId, activeKnights);
    }

    public Knight getKnight(String nameOrId){
        return findKnight(nameOrId, knights);
    }

    public boolean setActive(Knight kt){
        if(activeKnights.size() < 4) {
            activeKnights.add(kt);
            return true;
        } else {
            return false;
        }
    }

    public void removeActive(Knight kt) {
        activeKnights.remove(kt);
        kt.resetDamage();
    }

    public Fortune getRandomFortune(){
        return fortunes.get(random.nextInt(fortunes.size()));
    }

    public java.util.List<MOB> getRandomMonsters(){
        java.util.List<MOB> list = new ArrayList<>();
        if(monsters.size() <= activeKnights.size()){
            list.add(monsters.get(random.nextInt(monsters.size())));
        }
        return list;
    }

    public java.util.List<MOB> getRandomMonsters(int number){
        ArrayList<MOB> list = new ArrayList<>(number);
        list.add(monsters.get(random.nextInt(monsters.size())));
        return list;
    }

    public abstract void save(String filename);
}
