package dougrich.dev.mc.hermes.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopListExecutor extends ShopBaseCommandExecutor {

    protected class ShopListExecutorArgs extends ShopExecutorArgs {
        public String item;
    }

    protected ShopExecutorArgs tryGetArgs(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if(args.length != 1 || args.length != 2) {
            // This command has the wrong number of arguments.
            return null;
        }

        if(!args[0].equalsIgnoreCase("list")) {
            // This is not the list command.
            return null;
        }

        // Success case; create list command parsed arguments.
        final ShopListExecutorArgs parsedArgs = new ShopListExecutorArgs();
        parsedArgs.sender = sender;

        if(args.length == 2) {
            parsedArgs.item = args[1];
        }
        else {
            // TODO: Do we need to explicitly set this in Java?
            parsedArgs.item = null;
        }

        return parsedArgs;
    }

    protected boolean handleCommand(final ShopExecutorArgs e) {
        if(!(e.sender instanceof Player)) {
            // Server cannot send this command.
            return false;
        }

        if(!(e instanceof ShopListExecutorArgs)) {
            // These are not arguments for the list command.
            return false;
        }

        // TODO: send player shop price information.
        e.sender.sendMessage("TODO: send player shop price information");
        return true;
    }
}