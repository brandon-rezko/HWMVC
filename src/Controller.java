import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller class that handles button events and connects the View (HWMVC) with the Model logic.
 */
public class Controller {
    private HWMVC view;
    private Model model;

    public Controller(HWMVC view1, Model model1) {
        this.view = view1;
        this.model = model1;

        attachListener(() -> model.sub(view.getFirst(), view.getSecond()), view::addListeners1);
        attachListener(() -> model.mod(view.getFirst(), view.getSecond()), view::addListeners2);
        attachListener(() -> model.multi(view.getFirst(), view.getSecond()), view::addListeners3);

        // ✅ Division with zero check
        view.addListeners4(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    long a = view.getFirst();
                    long b = view.getSecond();
                    if (b == 0) {
                        view.showError("Division by zero is not allowed.");
                        return;
                    }
                    model.div(a, b);
                    view.setResult(model.returnresult());
                } catch (NumberFormatException ex) {
                    view.showError("Invalid input: please enter numeric values.");
                }
            }
        });

        attachListener(() -> model.add(view.getFirst(), view.getSecond()), view::addListeners5);

        // ✅ Square root validation
        view.addListeners6(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    long a = view.getFirst();
                    if (a < 0) {
                        view.showError("Cannot compute square root of a negative number.");
                        return;
                    }
                    model.sqrrt(a);
                    view.setResult1(model.returnresult1());
                } catch (NumberFormatException ex) {
                    view.showError("Invalid input: please enter a number.");
                }
            }
        });
    }

    /**
     * Generic method to attach an action to a view listener with basic exception handling.
     */
    private void attachListener(Runnable modelAction, java.util.function.Consumer<ActionListener> addListenerFunc) {
        addListenerFunc.accept(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    modelAction.run();
                    view.setResult(model.returnresult());
                } catch (NumberFormatException ex) {
                    view.showError("Invalid input: please enter valid numbers.");
                } catch (Exception ex) {
                    view.showError("An error occurred: " + ex.getMessage());
                }
            }
        });
    }
}
