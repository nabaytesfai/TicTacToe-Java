public class Launcher {
    public static void main(String[] args) {
        RuleEngine game = new RuleEngine(3);
        Controller controller = new Controller(game, null);
        View view = new View(controller, game.getBoardSize());
        controller.setView(view);
    }
}
