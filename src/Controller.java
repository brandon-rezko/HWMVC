import java.awt.event.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Controller class for MVC Calc with operation mapping, logging, and keyboard support.
 */
public class Controller {
    private final HWMVC view;
    private final Model model;

    public Controller(HWMVC view, Model model) {
        this.view = view;
        this.model = model;

        // ✅ Bind button listeners
        register(Operation.SUBTRACT, view::addListeners1);
        register(Operation.MODULO, view::addListeners2);
        register(Operation.MULTIPLY, view::addListeners3);
        register(Operation.DIVIDE, view::addListeners4);
        register(Operation.ADD, view::addListeners5);
        registerUnary(Operation.SQRT, view::addListeners6);

        // ✅ Bind key listeners
        addKeyBinding(KeyEvent.VK_PLUS, Operation.ADD);
        addKeyBinding(KeyEvent.VK_MINUS, Operation.SUBTRACT);
        addKeyBinding(KeyEvent.VK_ASTERISK, Operation.MULTIPLY);
        addKeyBinding(KeyEvent.VK_SLASH, Operation.DIVIDE);
        addKeyBinding(KeyEvent.VK_ENTER, Operation.ADD); // default to add on Enter
    }

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
                log(op.name(), a, b, model.returnresult());

            } catch (NumberFormatException ex) {
                view.showError("Please enter valid numbers.");
            } catch (Exception ex) {
                view.showError("Unexpected error: " + ex.getMessage());
            }
        });
    }

    private void registerUnary(Operation op, Consumer<ActionListener> bind) {
        bind.accept(e -> {
            try {
                long a = view.getFirst();

                if (op == Operation.SQRT && a < 0) {
                    view.showError("Square root of negative number is not allowed.");
                    return;
                }

                op.apply(model, a, 0);
                view.setResult1(model.returnresult1());
                log(op.name(), a, 0, model.returnresult1());

            } catch (NumberFormatException ex) {
                view.showError("Please enter a valid number.");
            } catch (Exception ex) {
                view.showError("Unexpected error: " + ex.getMessage());
            }
        });
    }

    /**
     * Maps a keyboard key to an operation.
     */
    private void addKeyBinding(int keyCode, Operation op) {
        view.getMainFrame().addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == keyCode) {
                    long a = view.getFirst();
                    long b = view.getSecond();
                    try {
                        op.apply(model, a, b);
                        view.setResult(model.returnresult());
                        log(op.name() + " [key]", a, b, model.returnresult());
                    } catch (Exception ex) {
                        view.showError("Key operation error: " + ex.getMessage());
                    }
                }
            }
        });
    }

    /**
     * Simple operation logger.
     */
    private void log(String operation, long a, long b, long result) {
        System.out.printf("🔍 %s -> (%d, %d) = %d%n", operation, a, b, result);
    }

    private enum Operation {
        ADD((m, a, b) -> m.add(a, b)),
        SUBTRACT((m, a, b) -> m.sub(a, b)),
        MULTIPLY((m, a, b) -> m.multi(a, b)),
        DIVIDE((m, a, b) -> m.div(a, b)),
        MODULO((m, a, b) -> m.mod(a, b)),
        SQRT((m, a, b) -> m.sqrrt(a)); // b ignored

        private final BiConsumer<Model, Long, Long> logic;
        Operation(BiConsumer<Model, Long, Long> logic) {
            this.logic = logic;
        }

        public void apply(Model m, long a, long b) {
            logic.accept(m, a, b);
        }
    }
}
