import java.util.HashMap;
import java.util.Map;
class Main {
    public static void main(String[] args) {
        Lab4 l = new Lab4();
        String input = "001100"; 
        for (char symbol : input.toCharArray()) {
            String nextState = l.getNextState(symbol);
            System.out.println("'" + symbol + "' Next State: " + nextState);
        }
        boolean isAccepted = l.processInput(input);
        if (isAccepted) {
            System.out.println("Input '" + input + "' is accepted");
        } else {
            System.out.println("Input '" + input + "' is rejected");
        }
    }
}
public class Lab4 {
    private String currentState;
    private Map<String, Map<Character, String>> transitions;
    private String acceptingStates;
    public Lab4() {
        this.currentState = "S0";
        this.transitions = new HashMap<>();
        this.acceptingStates = "S2";
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
        return null;
    }
    public boolean processInput(String input) {
        for (char symbol : input.toCharArray()) {
            if (!transitions.get(currentState).containsKey(symbol)) {
                return false;
            }
            currentState = transitions.get(currentState).get(symbol);
        }
            if (currentState.equals(acceptingStates)) {
                return true;
            }
        
        return false;
    }
}
