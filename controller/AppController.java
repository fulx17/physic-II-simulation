package controller;
import model.experiment.problem.Problem1Model;
import view.experiment.problem.problem1.Problem1Panel;
import view.experiment.problem.problem2.Problem2Panel;
import view.experiment.problem.problem3.Problem3Panel;
import view.experiment.problem.problem4.Problem4Panel;
import view.experiment.problem.problem5.Problem5Panel;
import view.experiment.problem.problem6.Problem6Panel;
import view.frame.MainFrame;
import view.instruction.InstructionContent;
import view.instruction.InstructionHeader;
import view.instruction.InstructionPanel;
import view.instruction.InstructionTextPanel;
import view.menu.MenuPanel;
import view.notify.CheckNotify;

public class AppController {
    private MainFrame frame;
    public AppController() {
        frame = new MainFrame();
        openMenu();
        frame.setVisible(true);
    }
    public void sendNotify(String message) {
        new CheckNotify(frame, message);
    }
    public void openMenu() {
        frame.setContent(new MenuPanel(this));
    }
    public void openExperiment(int experimentId) {
        switch (experimentId) {
            case 1 -> frame.setContent(new Problem1Panel(this));
            // case 2 -> frame.setContent(new Problem2Panel(this));
            // case 3 -> frame.setContent(new Problem3Panel(this));
            // case 4 -> frame.setContent(new Problem4Panel(this));
            // case 5 -> frame.setContent(new Problem5Panel(this));
            // case 6 -> frame.setContent(new Problem6Panel(this));
            default -> throw new IllegalArgumentException("ID thí nghiệm không hợp lệ: " + experimentId);
        }
    }
    public void openInstruction() {
        frame.setContent(new InstructionPanel(this));
    }
}