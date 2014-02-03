package dougrich.dev.mc.hermes.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ShopBaseCommandExecutor implements CommandExecutor {

    protected enum ShopCommandType {
        HELP,
        PURSE,
        LIST,
        BUY,
        SELL
    }

    protected class ShopExecutorArgs {
        public CommandSender sender;
        public ShopCommandType commandtype;
    }

    final public boolean onCommand(final CommandSender sender, final Command cmd, final String label, String[] args) {
        // validate arguments & switch to appropriate command

        // preprocess args: this changes it so that any commands in quotes with spaces work properly
        // i.e. /shop add "ginger cow" has args "add", "ginger cow", not "add", "\"ginger", "cow\""
        final List<String> strings = new ArrayList<String>();
        String currentstring = "";
        for(int i = 0; i < args.length; i++) {
            if(args[i].startsWith("\"") && !(args[i].endsWith("\"") && args[i].length() > 1)) {
                currentstring = args[i].toString();
                for(i++; i < args.length; i++) {
                    currentstring = currentstring.concat(" ");
                    currentstring = currentstring.concat(args[i]);
                    if(currentstring.endsWith("\"")) {
                        currentstring = currentstring.replace('"', ' ').trim();
                        break;
                    }
                }
                strings.add(currentstring);
            }
            else {
                strings.add(args[i].replace('"', ' ').trim());
            }
        }
        args = new String[strings.size()];
        strings.toArray(args);

        ShopBaseCommandExecutor executor = null;

        if(args.length > 0) {
            switch(args[0]) {
            /*
             * case "something": executor = new whatever(); break;
             */
                case "purse":
                    executor = new ShopPurseExecutor();
                    break;
                case "list":
                    executor = new ShopListExecutor();
                    break;
                case "buy":
                    executor = new ShopBuyExecutor();
                    break;
                case "sell":
                    executor = new ShopSellExecutor();
                    break;
                case "help":
                default:
                    executor = new ShopHelpExecutor();
                    break;
            }
        }
        else {
            executor = new ShopHelpExecutor();
        }

        ShopExecutorArgs localargs = executor.tryGetArgs(sender, cmd, label, args);
        if(localargs == null) {
            executor = new ShopHelpExecutor();
            localargs = executor.tryGetArgs(sender, cmd, label, args);
        }

        executor.handleCommand(localargs);

        return true;
    }

    protected ShopExecutorArgs tryGetArgs(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final ShopExecutorArgs parsedargs = new ShopExecutorArgs();
        parsedargs.sender = sender;
        return parsedargs;
    }

    protected boolean handleCommand(final ShopExecutorArgs e) {
        return false;
    }

}
