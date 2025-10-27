import java.util.Random;
import java.util.Stack;

public class TheStack<Type> implements TheStackInterface<Type> {

    // NO MODIFICAR: Atributos privados
    private Stack<Type> _stack;
    private Integer _capacity;

    // NO MODIFICAR: Constructor
    public TheStack(Integer capacity) {
        _stack = new Stack<Type>();
        _capacity = capacity;
    }

    /**
     * CORREGIDO: Soluciona el error de recursión infinita.
     * Inserta solo si el tamaño es menor que la capacidad.
     */
    @Override
    public Boolean push(Type item) {
        var available = _stack.size() < _capacity;
        if (available) {
            // Se llama correctamente al método push del objeto java.util.Stack.
            _stack.push(item);
        }
        return available;
    }

    /**
     * CORREGIDO: Agrega la verificación de pila vacía para evitar EmptyStackException (Underflow).
     */
    @Override
    public Type pop() {
        if (_stack.isEmpty()) {
            return null; // Devuelve null si la pila está vacía.
        }
        return _stack.pop();
    }

    /**
     * CORREGIDO: Agrega la verificación de pila vacía para evitar EmptyStackException (Underflow).
     */
    @Override
    public Type peek() {
        if (_stack.isEmpty()) {
            return null; // Devuelve null si la pila está vacía.
        }
        return _stack.peek();
    }

    /**
     * Método correcto. Devuelve Boolean para coincidir con la interfaz.
     */
    @Override
    public Boolean empty() {
        return _stack.isEmpty();
    }

    /**
     * CORREGIDO: El tipo de retorno es Integer para coincidir con la interfaz,
     * solucionando un error de compilación previo.
     */
    @Override
    public Integer size() {
        return _stack.size();
    }

    /**
     * Método correcto. Usa la implementación toString() de java.util.Stack.
     */
    @Override
    public String print() {
        return _stack.toString();
    }

    public static void main(String[] args) {
        
        // El requisito es que el argumento ES PROVISTO y ES CORRECTO (n >= 0).
        // No se necesita validación (sin try/catch).
        var capacity = Integer.parseInt(args[0]);
        
        TheStackInterface<Double> stack = new TheStack<Double>(capacity);
        
        // --- 1. PRUEBA DE OVERFLOW (n + 1 inserciones) ---
        
        System.out.printf("Pushing {%d} items (capacity + 1)\n", capacity + 1);
        var random = new Random();
        for (var n = 0; n <= capacity; n++) {
            var number = random.nextDouble();
            var pushed = stack.push(number);
            System.out.printf(" ↳ push(%.4f) → %s\n", number, pushed);
        }
        
        System.out.println();
        System.out.println("Pushed {full}");
        System.out.println(" ↳ print() → " + stack.print());
        System.out.println("    ↳ peek() → " + stack.peek());
        System.out.println("    ↳ size() → " + stack.size());
        System.out.println("    ↳ empty() → " + stack.empty());
        
        // --- 2. PRUEBA DE UNDERFLOW (n + 1 extracciones) ---
        
        System.out.println();
        System.out.printf("Popping {%d} items (capacity + 1)\n", capacity + 1);
        
        for (var n = 0; n <= capacity; n++) {
            var popped = stack.pop();
            // El último pop (n == capacity) devolverá 'null' o un elemento,
            // y el siguiente (n > capacity) siempre devolverá 'null'.
            System.out.println(" ↳ pop() → " + popped);
        }
        
        System.out.println();
        System.out.println("Popped {empty}");
        System.out.println(" ↳ print() → " + stack.print());
        System.out.println("    ↳ peek() → " + stack.peek()); // Devolverá null
        System.out.println("    ↳ size() → " + stack.size()); // Devolverá 0
        System.out.println("    ↳ empty() → " + stack.empty()); // Devolverá true
    }
}
// Se utilizó Gemini para consultas
