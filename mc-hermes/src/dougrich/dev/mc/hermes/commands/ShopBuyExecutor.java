package dougrich.dev.mc.hermes.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopBuyExecutor extends ShopBaseCommandExecutor {

    protected class ShopBuyExecutorArgs extends ShopExecutorArgs {
        public String item;
    }

    protected ShopExecutorArgs tryGetArgs(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if(args.length != 2) {
            // This command has the wrong number of arguments.
            return null;
        }

        if(args[0].equalsIgnoreCase("buy")) {
            // This is not the buy command.
            return null;
        }

        // Success case; create buy command parsed arguments and return.
        final ShopBuyExecutorArgs parsedArgs = new ShopBuyExecutorArgs();
        parsedArgs.sender = sender;
        parsedArgs.commandtype = ShopCommandType.BUY;
        parsedArgs.item = args[1];
        return parsedArgs;
    }

    protected boolean handleCommand(final ShopExecutorArgs e) {
        if(!(e.sender instanceof Player)) {
            // Server cannot send this command.
            return false;
        }

        if(!(e instanceof ShopBuyExecutorArgs)) {
            // These are not arguments for the buy command.
            return false;
        }

        // TODO: implement buy command.
        e.sender.sendMessage("TODO: implement buy command");
        return true;
    }
}