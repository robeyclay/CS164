public class UnitTests {
    public void runTests() {
        //DiceSet tests
        DiceSet testDice = new DiceSet();
        System.out.println(testDice.roll(DiceType.D4));
        System.out.println(testDice.roll(DiceType.D6));
        System.out.println(testDice.roll(DiceType.D8));
        System.out.println(testDice.roll(DiceType.D10));
        System.out.println(testDice.roll(DiceType.D12));
        System.out.println(testDice.roll(DiceType.D20));

        //Fortune Test
        Fortune testFortune = new Fortune("Clay",20,5,6,DiceType.D4);
        System.out.println(testFortune.toString());

        //MOB Test
        MOB testMOB = new MOB("Orc", 45, 15, 3, DiceType.D8);
        testMOB.addDamage(15);
        System.out.println(testMOB.getDamage());
        testMOB.resetDamage();
        System.out.println(testMOB.toString());

        //Knight Test
        Knight testKnight = new Knight(1,"Arthur", 30, 25, 2, DiceType.D10, 0);
        testKnight.addDamage(3);
        System.out.println(testKnight.getDamage());
        System.out.println(testKnight.getActiveFortune());
        testKnight.resetDamage();
        testKnight.addXP(15);
        System.out.println(testKnight.toString());
    }
}
