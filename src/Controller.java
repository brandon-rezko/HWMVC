import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Controller class for the MVC Calculator using an enum-based action dispatcher.
 */
public class Controller {
    private final HWMVC view;
    private final Model model;

    public Controller(HWMVC view, Model model) {
        this.view = view;
        this.model = model;

        // ✅ Map buttons to operations
        register(Operation.SUBTRACT, view::addListeners1);
        register(Operation.MODULO, view::addListeners2);
        register(Operation.MULTIPLY, view::addListeners3);
        register(Operation.DIVIDE, view::addListeners4);
        register(Operation.ADD, view::addListeners5);
        registerUnary(Operation.SQRT, view::addListeners6);
    }

    /**
     * Register a binary operation (uses two inputs).
     */
    private void register(Operation op, Consumer<ActionListener> bind) {
        bind.accept(e -> {
            try {
                long a = view.getFirst();
                long b = view.getSecond();

                if (op == Operation.DIVIDE && b == 0) {
                    view.showError("Division by zero is not allowed.");
                    return;
                }

                op.apply(model, a, b);
                view.setResult(model.returnresult());

            } catch (NumberFormatException ex) {
                view.showError("Please enter valid numbers.");
            } catch (Exception ex) {
                view.showError("Unexpected error: " + ex.getMessage());
            }
        });
    }

    /**
     * Register a unary operation (uses one input only).
     */
    private void registerUnary(Operation op, Consumer<ActionListener> bind) {
        bind.accept(e -> {
            try {
                long a = view.getFirst();

                if (op == Operation.SQRT && a < 0) {
                    view.showError("Square root of negative number is not allowed.");
                    return;
                }

                op.apply(model, a, 0); // b is ignored for unary ops
                view.setResult1(model.returnresult1());

            } catch (NumberFormatException ex) {
                view.showError("Please enter a valid number.");
            } catch (Exception ex) {
                view.showError("Unexpected error: " + ex.getMessage());
            }
        });
    }

    /**
     * Operation types with associated behavior.
     */
    private enum Operation {
        ADD((m, a, b) -> m.add(a, b)),
        SUBTRACT((m, a, b) -> m.sub(a, b)),
        MULTIPLY((m, a, b) -> m.multi(a, b)),
        DIVIDE((m, a, b) -> m.div(a, b)),
        MODULO((m, a, b) -> m.mod(a, b)),
        SQRT((m, a, b) -> m.sqrrt(a)); // b is ignored

        private final BiConsumer<Model, Long, Long> logic;

        Operation(BiConsumer<Model, Long, Long> logic) {
            this.logic = logic;
        }

        public void apply(Model m, long a, long b) {
            logic.accept(m, a, b);
        }
    }
}
