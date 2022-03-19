public interface GameView {
    void splashScreen();
    void endGame();
    String displayMainMenu();
    void printHelp();
    void knightNotFound();
    void showKnight(Knight knight);
    void setActiveFailed();
    void printBattleText(java.util.List<MOB> monsters, java.util.List<Knight> activeKnights);
    void printBattleText(MOB dead);
    void printFortunes(java.util.List<Knight> activeKnights);
    boolean checkContinue();
    void printDefeated();
}
