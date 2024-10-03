import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Controller {
    private final HWMVC view;
    private final Model model;
    private final List<String> history = new ArrayList<>();

    public Controller(HWMVC view, Model model) {
        this.view = view;
        this.model = model;

        register(Operation.SUBTRACT, view::addListeners1);
        register(Operation.MODULO, view::addListeners2);
        register(Operation.MULTIPLY, view::addListeners3);
        register(Operation.DIVIDE, view::addListeners4);
        register(Operation.ADD, view::addListeners5);
        registerUnary(Operation.SQRT, view::addListeners6);

        // ✅ Export history listener (button #7)
        view.addListeners7(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    exportHistoryToFile("calc_history.txt");
                    view.showMessage("✅ History exported to calc_history.txt");
                } catch (IOException ex) {
                    view.showError("❌ Failed to export history: " + ex.getMessage());
                }
            }
        });
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
                long result = model.returnresult();
                view.setResult(result);
                log(op.name(), a, b, result);

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
                long result = model.returnresult1();
                view.setResult1(result);
                log(op.name(), a, 0, result);

            } catch (NumberFormatException ex) {
                view.showError("Please enter a valid number.");
            } catch (Exception ex) {
                view.showError("Unexpected error: " + ex.getMessage());
            }
        });
    }

    private void log(String op, long a, long b, long result) {
        String entry = String.format("[%s] (%d, %d) => %d", op, a, b, result);
        history.add(entry);
        System.out.println("📘 " + entry);
        view.appendHistory(entry); // ✅ View should have a text area or list
    }

    private void exportHistoryToFile(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            for (String entry : history) {
                writer.write(entry + "\n");
            }
        }
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
