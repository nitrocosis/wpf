package com.wpf.domain.common;

import java.util.HashMap;
import java.util.Map;

public class InputCommandProcessor implements InputProcessor {

    private Map<Input, InputCommand> inputCommandMap = new HashMap<Input, InputCommand>();

    public void setCommand(Input input, InputCommand inputCommand) {
        inputCommandMap.put(input, inputCommand);
    }

    @Override
    public boolean processInput(Input input) {
        return inputCommandMap.containsKey(input) && inputCommandMap.get(input).execute();
    }
}
