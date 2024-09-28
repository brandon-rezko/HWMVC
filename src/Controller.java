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

        // ✅ Assign all operation listeners
        attachListener(() -> model.sub(view.getFirst(), view.getSecond()), view::addListeners1);
        attachListener(() -> model.mod(view.getFirst(), view.getSecond()), view::addListeners2);
        attachListener(() -> model.multi(view.getFirst(), view.getSecond()), view::addListeners3);
        attachListener(() -> model.div(view.getFirst(), view.getSecond()), view::addListeners4);
        attachListener(() -> model.add(view.getFirst(), view.getSecond()), view::addListeners5);

        // ✅ Special case for square root: single number input
        view.addListeners6(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long input = view.getFirst();
                model.sqrrt(input);
                view.setResult1(model.returnresult1());
            }
        });
    }

    /**
     * Generic method to attach an action to a view listener.
     * It handles exceptions and updates the result area.
     */
    private void attachListener(Runnable modelAction, java.util.function.Consumer<ActionListener> addListenerFunc) {
        addListenerFunc.accept(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modelAction.run();
                view.setResult(model.returnresult());
            }
        });
    }
}
