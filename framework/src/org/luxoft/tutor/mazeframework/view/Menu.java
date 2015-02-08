package org.luxoft.tutor.mazeframework.view;

import org.luxoft.tutor.mazeframework.domain.Command;
import org.luxoft.tutor.mazeframework.domain.Displayed;
import org.luxoft.tutor.mazeframework.domain.View;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public abstract class Menu extends Displayed {

    protected Menu(View implementation) {
        super(implementation);
    }

    private static Menu instance;

    private final Map<String, Command> commands = new HashMap<>();

    public static void setInstance(Menu instance) {
        Menu.instance = instance;
    }

    public static Menu get() {
        return instance;
    }

    public <T extends Command> T getItem(String kind) {
        final Command command = commands.get(kind.toLowerCase());
        if (command == null)  {
            return makeUnknownCommand();
        }
        try {
            //noinspection unchecked
            return (T) command;
        } catch (ClassCastException e) {
            throw new IllegalStateException(format("The command of '%s' has invalid type", kind));
        }
    }

    protected abstract <T extends Command> T makeUnknownCommand();

    public void persist(String kind, Command command) {
        commands.put(kind.toLowerCase(), command);
    }


}
