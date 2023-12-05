import java.util.HashMap;
import java.util.Map;
class Main {
    public static void main(String[] args) {
        FiniteStateAutomaton automaton = new FiniteStateAutomaton();
        String input = "001100"; 
        for (char symbol : input.toCharArray()) {
            String nextState = automaton.getNextState(symbol);
            System.out.println("'" + symbol + "' Next State: " + nextState);
        }
        boolean isAccepted = automaton.processInput(input);
        if (isAccepted) {
            System.out.println("Input '" + input + "' is accepted");
        } else {
            System.out.println("Input '" + input + "' is rejected");
        }
    }
}
public class FiniteStateAutomaton {
    private String currentState;
    private Map<String, Map<Character, String>> transitions;
    private String[] acceptingStates;

    public FiniteStateAutomaton() {
        this.currentState = "S0";
        this.transitions = new HashMap<>();
        this.acceptingStates = new String[]{"S2"};

        // Add transitions for each state and input symbol
        addTransition("S0", '0', "S1");
        addTransition("S0", '1', "S0");
        addTransition("S1", '1', "S2");
        addTransition("S2", '0', "S1");
        addTransition("S1", '0', "S1");
        addTransition("S2", '1', "S0");
    }
    private void addTransition(String currentState, char inputSymbol, String nextState) {
        transitions.computeIfAbsent(currentState, k -> new HashMap<>()).put(inputSymbol, nextState);
    }
    public String getCurrentState(char inputSymbol) {
        return currentState;
    }
    public String getNextState(char inputSymbol) {
        if (transitions.containsKey(currentState)) {
            Map<Character, String> stateTransitions = transitions.get(currentState);
            if (stateTransitions.containsKey(inputSymbol)) {
                return stateTransitions.get(inputSymbol);
            }
        }
        return null;  // Transition not found
    }
    public boolean processInput(String input) {
        for (char symbol : input.toCharArray()) {
            if (!transitions.get(currentState).containsKey(symbol)) {
                return false;  // Invalid input symbol encountered
            }
            currentState = transitions.get(currentState).get(symbol);
        }
        // Check if the final state is an accepting state
        for (String acceptingState : acceptingStates) {
            if (currentState.equals(acceptingState)) {
                return true;  // Input accepted
            }
        }
        return false;  // Input not accepted
    }
}
